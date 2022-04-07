package com.testautomation.manejo.tasks;

import com.testautomation.manejo.models.EmployeeCreate;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CrearEmployees implements Task {
    EmployeeCreate crearEmployee;

    public CrearEmployees(EmployeeCreate crearEmployee) {
        this.crearEmployee = crearEmployee;
    }

    public static CrearEmployees crearEm(EmployeeCreate crearEmployee) {
        System.out.println(crearEmployee == null);
        return Tasks.instrumented(CrearEmployees.class, crearEmployee);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/create").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON).
                body(crearEmployee).log().all()));
    }
}
