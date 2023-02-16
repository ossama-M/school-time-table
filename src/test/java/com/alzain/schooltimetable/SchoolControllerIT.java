package com.alzain.schooltimetable;


import com.alzain.schooltimetable.Model.Entity.GradeWClasses;
import com.alzain.schooltimetable.Model.Entity.School;
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

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SchoolTimeTableApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SchoolControllerIT {
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testaddSchool() throws JSONException {

        School school = School.builder().schoolName("Al Foursan").id(1).location("Cairo").build();
        HttpEntity<School> entity = new HttpEntity<School>(school, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/school"),
                HttpMethod.POST, entity, String.class);

        String expected = "{" +
                "  \"id\": 1," +
                "  \"schoolName\": \"Al Foursan\"," +
                "  \"location\": \"Cairo\"" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testGetSchool() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/school/1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{" +
                "  \"id\": 1," +
                "  \"schoolName\": \"Al Foursan\"," +
                "  \"location\": \"Cairo\"" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testUpdateSchool() throws JSONException {

        School school = School.builder().schoolName("Al Manara"). location("Cairo").build();
        HttpEntity<School> entity = new HttpEntity<School>(school, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/school/1"),
                HttpMethod.PUT, entity, String.class);

        String expected = "{" +
                "  \"id\": 1," +
                "  \"schoolName\": \"Al Manara\"," +
                "  \"location\": \"Cairo\"" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testDeleteSchool() throws JSONException {

        School school = School.builder().schoolName("Al Orman").id(2).location("Cairo").build();
        HttpEntity<School> entity1 = new HttpEntity<School>(school, headers);

        ResponseEntity<String> response1 = restTemplate.exchange(
                createURLWithPort("/school"),
                HttpMethod.POST, entity1, String.class);

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/school/2"),
                HttpMethod.DELETE, entity, String.class);

        String expected = null;

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }




    public   String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
