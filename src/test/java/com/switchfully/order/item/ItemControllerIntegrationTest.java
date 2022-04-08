package com.switchfully.order.item;

import com.switchfully.order.users.customer.dtos.CustomerDto;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.http.ContentType.JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ItemControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    void givenANewItem_whenYouAddAnItem_thenItemIsAddedToDatabase() {
        AddItemDto addItemDto = new AdditemDto(
                "Iphone 13",
                "Apple Smartphone",
                1000.00,
                15);

        Admin admin = new Admin(new UsernamePassword("Michael", "Jorden"));
        adminRepositiry.save(admin);

        ItemDto itemDto =
                RestAssured
                        .given()
                        .body(addItemDto)
                        .accept(JSON)
                        .contentType(JSON)
                        .when()
                        .port(port)
                        .post("/items")
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                        .as(ItemDto.class);

        Assertions.assertThat(itemDto.getName()).isEqualTo(addItemDto.getName());
        Assertions.assertThat(itemDto.getDescription()).isEqualTo(addItemDto.getDescription());
        Assertions.assertThat(itemDto.getPrice()).isEqualTo(addItemDto.getPrice());
        Assertions.assertThat(itemDto.getAmount()).isEqualTo(addItemDto.getAmount());


    }


}
