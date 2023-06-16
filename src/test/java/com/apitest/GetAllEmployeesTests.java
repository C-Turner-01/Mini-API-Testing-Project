package com.apitest;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;
import com.fasterxml.jackson.annotation.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class GetAllEmployeesTests {
    private static ResponseDTO responseDTO;
    private static Response response;

    @BeforeAll
    public static void createResponse() {
        response = RestAssured.get(Routes.getEmployees_url);
        responseDTO = response.as(ResponseDTO.class, ObjectMapperType.JACKSON_2);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)

    @Test
    @DisplayName("Check Response Status Code is 200")
    void checkResponseStatusCodeIs200() {
        assertThat(response.getStatusCode(), equalTo(200));
    }
    
    @Test
    @DisplayName("Check That Status Equals Success")
    void checkThatStatusEqualsSuccess() {
        assertThat(responseDTO.getStatus(), equalTo("success"));
    }

    @Test
    @DisplayName("Check that the message states that the request has been successful")
    void checkThatTheMessageStatesThatTheRequestHasBeenSuccessful() {
     assertThat(responseDTO.getMessage(), equalTo("Successfully! All records has been fetched."));
    }
    
    @Test
    @DisplayName("Check that the server is correct")
    void checkThatTheServerIsCorrect() {
        assertThat(response.getHeader("server"), equalTo(	"nginx/1.21.6"));
    }

    @Test
    @DisplayName("test that there are 24 items in the array")
    void testThatThereAre24ItemsInTheArray() {
     assertThat(responseDTO.getData().size(), equalTo(24));
    }

    @Test
    @DisplayName("check no employees are younger than 18")
    void checkNoEmployeesAreYoungerThan18() {
        for (int i = 0; i < responseDTO.getData().size(); i++) {
            assertThat(responseDTO.getData().get(i).getEmployeeAge(), greaterThanOrEqualTo(18));
        }
    }

}
