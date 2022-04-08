package com.switchfully.order.item;

import com.switchfully.order.customer.dtos.RegisterCustomerDto;
import com.switchfully.order.item.dtos.AddItemDto;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.http.ContentType.JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ItemControllerUnitTest {
    @LocalServerPort
    private int port;

    @Nested
    @DisplayName("Name tests")
    class NameTests {
        @Test
        void givenANewItem_WhenNameIsNull_ThenBadRequestIsThrown() {
            AddItemDto addItemDto = new AddItemDto(
                    null,
                    "Apple Smartphone",
                    1000.00,
                    12);

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
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewItem_WhenNameIsEmpty_ThenBadRequestIsThrown() {
            AddItemDto addItemDto = new AddItemDto(
                    "",
                    "Apple Smartphone",
                    1000.00,
                    12);

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
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewItem_WhenNameIsBlank_ThenBadRequestIsThrown() {
            AddItemDto addItemDto = new AddItemDto(
                    "    ",
                    "Apple Smartphone",
                    1000.00,
                    12);

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
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }


    }

    @Nested
    @DisplayName("Description tests")
    class DescriptionTests {
        @Test
        void givenANewItem_WhenDescriptionIsNull_ThenBadRequestIsThrown() {
            AddItemDto addItemDto = new AddItemDto(
                    "Iphone 13",
                    null,
                    1000.00,
                    12);

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
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewItem_WhenDescriptionIsEmpty_ThenBadRequestIsThrown() {
            AddItemDto addItemDto = new AddItemDto(
                    "Iphone 13",
                    "",
                    1000.00,
                    12);

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
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewItem_WhenDescriptionIsBlank_ThenBadRequestIsThrown() {
            AddItemDto addItemDto = new AddItemDto(
                    "Iphone 13",
                    "    ",
                    1000.00,
                    12);

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
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

    }

    @Test
    void givenANewItem_WhenPriceIsNull_ThenBadRequestIsThrown() {
        AddItemDto addItemDto = new AddItemDto(
                "Iphone 13",
                "Apple smartphone",
                null,
                12);

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
                .statusCode(HttpStatus.BAD_REQUEST.value());

    }


}

