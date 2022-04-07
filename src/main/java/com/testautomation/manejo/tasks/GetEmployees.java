package com.testautomation.manejo.tasks;


import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetEmployees implements Task {
    public GetEmployees() {
    }

    public static GetEmployees obtenerEmployees() {
        return Tasks.instrumented(GetEmployees.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/employees/").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );
    }
}
