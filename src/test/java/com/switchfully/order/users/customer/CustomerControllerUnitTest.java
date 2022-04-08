package com.switchfully.order.users.customer;

import com.switchfully.order.users.customer.dtos.RegisterCustomerDto;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.http.ContentType.JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomerControllerUnitTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CustomerRepository customerRepository;

    @Nested
    @DisplayName("Firstname tests")
    class FirstNameTests {
        @Test
        void givenANewCustomer_WhenFirstnameIsNull_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    null,
                    "Debakker",
                    "JosDB@gmail.com",
                    "Meir 20, 2000 Antwerpen",
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewCustomer_WhenFirstnameIsEmpty_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "",
                    "Debakker",
                    "JosDB@gmail.com",
                    "Meir 20, 2000 Antwerpen",
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewCustomer_WhenFirstnameIsBlank_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "     ",
                    "Debakker",
                    "JosDB@gmail.com",
                    "Meir 20, 2000 Antwerpen",
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }


    }


    @Nested
    @DisplayName("Lastname tests")
    class LastNameTests {
        @Test
        void givenANewCustomer_WhenLastnameIsNull_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    null,
                    "JosDB@gmail.com",
                    "Meir 20, 2000 Antwerpen",
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewCustomer_WhenLastnameIsEmpty_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    "",
                    "JosDB@gmail.com",
                    "Meir 20, 2000 Antwerpen",
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewCustomer_WhenLastnameIsBlank_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    "     ",
                    "JosDB@gmail.com",
                    "Meir 20, 2000 Antwerpen",
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }


    }

    @Nested
    @DisplayName("EmailAddress tests")
    class EmailAddressTests {
        @Test
        void givenANewCustomer_WhenEmailAddressIsNull_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    "Debakker",
                    null,
                    "Meir 20, 2000 Antwerpen",
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewCustomer_EmailAddressIsEmpty_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    "Debakker",
                    "",
                    "Meir 20, 2000 Antwerpen",
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewCustomer_WhenEmailAddressIsBlank_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    "Debakker",
                    "    ",
                    "Meir 20, 2000 Antwerpen",
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }


    }


    @Nested
    @DisplayName("Address tests")
    class AddressTests {
        @Test
        void givenANewCustomer_WhenAddressIsNull_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    "Debakker",
                    "JosDB@gmail.com",
                    null,
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewCustomer_AddressIsEmpty_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    "Debakker",
                    "JosDB@gmail.com",
                    "",
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewCustomer_WhenAddressIsBlank_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    "Debakker",
                    "JosDB@gmail.com",
                    "    ",
                    "0515151515");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }


    }

    @Nested
    @DisplayName("PhoneNumber tests")
    class PhoneNumberTests {
        @Test
        void givenANewCustomer_WhenPhoneNumberIsNull_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    "Debakker",
                    "JosDB@gmail.com",
                    "Meir 20, 2000 Antwerpen",
                    null);

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewCustomer_WhenPhoneNumberIsEmpty_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    "Debakker",
                    "JosDB@gmail.com",
                    "Meir 20, 2000 Antwerpen",
                    "");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }

        @Test
        void givenANewCustomer_WhenPhoneNumberIsBlank_ThenBadRequestIsThrown() {
            RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                    "Jos",
                    "Debakker",
                    "JosDB@gmail.com",
                    "Meir 20, 2000 Antwerpen",
                    "  ");

            RestAssured
                    .given()
                    .body(registerCustomerDto)
                    .accept(JSON)
                    .contentType(JSON)
                    .when()
                    .port(port)
                    .post("/customers")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }


    }


}
