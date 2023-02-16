package com.alzain.schooltimetable;

import com.alzain.schooltimetable.Model.Entity.School;
import com.alzain.schooltimetable.Model.Entity.Subject;
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
public class SubjectControllerIT {

    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testAddSubject() throws JSONException {

        Subject subject = Subject.builder().subjectName("Math").id(1).duration("02:00").build();
        HttpEntity<Subject> entity = new HttpEntity<Subject>(subject, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/subject"),
                HttpMethod.POST, entity, String.class);

        String expected = "{" +
                "  \"id\": 1," +
                "  \"subjectName\": \"Math\"," +
                "  \"duration\": \"02:00\"" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testGetSubject() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/subject/1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{" +
                "  \"id\": 1," +
                "  \"subjectName\": \"Math\"," +
                "  \"duration\": \"02:00\"" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testUpdateSubject() throws JSONException {

        Subject subject = Subject.builder().subjectName("Arabic"). duration("02:00").build();
        HttpEntity<Subject> entity = new HttpEntity<Subject>(subject, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/subject/1"),
                HttpMethod.PUT, entity, String.class);

        String expected = "{" +
                "  \"id\": 1," +
                "  \"subjectName\": \"Arabic\"," +
                "  \"duration\": \"02:00\"" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testDeleteSubject() throws JSONException {

        Subject subject = Subject.builder().subjectName("English").id(2).duration("02:00").build();
        HttpEntity<Subject> entity1 = new HttpEntity<Subject>(subject, headers);

        ResponseEntity<String> response1 = restTemplate.exchange(
                createURLWithPort("/subject"),
                HttpMethod.POST, entity1, String.class);

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/subject/2"),
                HttpMethod.DELETE, entity, String.class);

        String expected = null;

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }




    public   String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
