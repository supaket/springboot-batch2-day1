package com.example.demo.users.gateway;

import com.example.demo.lottery.service.LotteryService;
import com.example.demo.users.repository.UserRepository;
import com.example.demo.users.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureWireMock(port = 9999)
class PostGatewayTest {

    @Autowired
    PostGateway postGateway;

    @Test
    public void shouldGetTodosFromPostGatewayResponse(){
        //Arrange
        //if calling to wiremock with /todos/10
        // then return {
        //  "userId": 1,
        //  "id": 1,
        //  "title": "delectus aut autem",
        //  "completed": false
        //}

        stubFor(get(urlEqualTo("/todos/10"))
                .willReturn(aResponse().withStatus(200)
                .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .withBody(
                        "{\n" +
                                "  \"userId\": 1,\n" +
                                "  \"id\": 1,\n" +
                                "  \"title\": \"delectus aut autem\",\n" +
                                "  \"completed\": false\n" +
                                "}"
                )));

        //Act
        Optional<PostResponse> postResponse = postGateway.getTodosById(10);

        //Assert
        assertEquals("1", postResponse.get().getId());
        assertEquals("delectus aut autem", postResponse.get().getTitle());

    }

}