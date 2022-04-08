package com.switchfully.order.users.customer;

import com.switchfully.order.users.customer.dtos.CustomerDto;
import com.switchfully.order.users.customer.dtos.RegisterCustomerDto;
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
public class CustomerControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    void givenANewCustomer_whenYouRegisterACustomer_thenCustomerIsAddedToDatabase() {
        RegisterCustomerDto registerCustomerDto = new RegisterCustomerDto(
                "Jos",
                "De Bakker",
                "josdb@gmail.com",
                "Meir 12, 2000 Antwerpen",
                "0494485152");

        CustomerDto customerDto =
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
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                        .as(CustomerDto.class);

        Assertions.assertThat(customerDto.getFirstName()).isEqualTo(registerCustomerDto.getFirstName());
        Assertions.assertThat(customerDto.getLastName()).isEqualTo(registerCustomerDto.getLastName());
        Assertions.assertThat(customerDto.getEmailAddress()).isEqualTo(registerCustomerDto.getEmailAddress());
        Assertions.assertThat(customerDto.getAddress()).isEqualTo(registerCustomerDto.getAddress());
        Assertions.assertThat(customerDto.getPhoneNumber()).isEqualTo(registerCustomerDto.getPhoneNumber());


    }

}
