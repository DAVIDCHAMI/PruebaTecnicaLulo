package com.testautomation.manejo.tasks;


import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
public class EliminarEmployee implements Task {



    public static Performable delete() {
       return Tasks.instrumented(EliminarEmployee.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/delete/3").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );
    }

}
