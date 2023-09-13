package testSteps.spec;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class apiSpec {

    public static RequestSpecification requestSpec = with()
            .filter(new AllureRestAssured())
            .log().uri()
            .log().body()
            .header("Content-type", "application/json");


    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(LogDetail.BODY)
            .build();
}
