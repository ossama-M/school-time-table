package com.alzain.schooltimetable;

import com.alzain.schooltimetable.Model.Entity.GradeWClasses;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.shaded.org.apache.commons.lang3.ObjectUtils;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SchoolTimeTableApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GradeWClassControllerIT {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testAddGradeWClass() throws JSONException {

        GradeWClasses gradeWClasses = GradeWClasses.builder().classes('B').grade(1).schoolId(1).build();
        HttpEntity<GradeWClasses> entity = new HttpEntity<GradeWClasses>(gradeWClasses, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/gradeWclass"),
                HttpMethod.POST, entity, String.class);

        String expected = "{" +
                "    \"id\": 2," +
                "    \"grade\": 1," +
                "    \"classes\": \"B\"," +
                "    \"schoolId\": 1" +
                "  }";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testGetGradeWClass() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/gradeWclass/1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{" +
                "    \"id\": 1," +
                "    \"grade\": 1," +
                "    \"classes\": \"A\"," +
                "    \"schoolId\": 1" +
                "  }";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testUpdateGradeWClass() throws JSONException {

        GradeWClasses gradeWClasses = GradeWClasses.builder().classes('D').grade(1).schoolId(1).build();
        HttpEntity<GradeWClasses> entity = new HttpEntity<GradeWClasses>(gradeWClasses, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/gradeWclass/2"),
                HttpMethod.PUT, entity, String.class);

        String expected = "{" +
                "    \"id\": 2," +
                "    \"grade\": 1," +
                "    \"classes\": \"D\"," +
                "    \"schoolId\": 1" +
                "  }";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testDeleteGradeWClass() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/gradeWclass/2"),
                HttpMethod.DELETE, entity, String.class);

        String expected = null;

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }




    public   String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }



}
