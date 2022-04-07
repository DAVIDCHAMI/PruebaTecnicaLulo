package com.testautomation.manejo.stepdefinitions;


import com.testautomation.manejo.models.EmployeeCreate;
import com.testautomation.manejo.tasks.CrearEmployees;


import com.testautomation.manejo.tasks.EliminarEmployee;
import com.testautomation.manejo.tasks.GetEmployees;
import com.testautomation.manejo.tasks.GetOneEmployee;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {

    private static final String restApiUrl = "http://dummy.restapiexample.com/api/v1";
    Actor david = Actor.named("david");
    @Given("^que quiero crear un employee$")
    public void que_quiero_crear_un_employee() {
         david.whoCan(CallAnApi.at(restApiUrl));
    }

    @When("^cuando consuma el servicio con (.*), salario(.*) y edad (.*)$")
    public void cuando_consuma_el_servicio_con_salario_y_edad(String nombre, String salario, String edad) {

        EmployeeCreate crearEmployee = new EmployeeCreate();
        crearEmployee.setName(nombre);
        crearEmployee.setSalary(salario);
        crearEmployee.setAge(edad);
        david.attemptsTo(CrearEmployees.crearEm(crearEmployee));
    }

    @Then("^se debe crear el usuario arrojando el mensaje de (.*)$")
    public void se_debe_crear_el_usuario_arrojando_el_mensaje_de(String mensaje) {
        david.should(seeThatResponse("usuario no se pudo crear, codigo respuesta", response -> response.statusCode(200).
                body("message", equalTo(mensaje))));

    }



    @Given("^que quiero eleiminar un employee$")
    public void que_quiero_eleiminar_un_employee() throws Exception {
        david.whoCan(CallAnApi.at(restApiUrl));
    }


    @When("^elimine el employee (.*)$")
    public void elimine_el_employee(String empleado) throws Exception {
        david.attemptsTo(EliminarEmployee.delete());

    }

    @Then("^se debe eliminar el employee arrojando el mensaje de (.*)$")
    public void se_debe_eliminar_el_employee_arrojando_el_mensaje_de(String mensaje) throws Exception {
        System.out.println(mensaje);
        david.should(seeThatResponse("usuario no se pudo eliminar, codigo respuesta", response -> response.statusCode(200).
                body("message", equalTo(mensaje))));

    }

    @Given("^que quiero consultar un employee$")
    public void que_quiero_consultar_un_employee() throws Exception {
        david.whoCan(CallAnApi.at(restApiUrl));
    }


    @When("^cuando consulte el  employee (.*)$")
    public void cuando_consulte_el_employee(String empleado) throws Exception {
        david.attemptsTo(GetOneEmployee.obtenerUnEmployees());
}

    @Then("^se debe consultar el usuario arrojando el mensaje de (.*)$")
    public void se_debe_consultar_el_usuario_arrojando_el_mensaje_de(String mensaje) throws Exception {

        System.out.println(mensaje);
        david.should(seeThatResponse("usuario no se puede consultar", response -> response.statusCode(200).
                body("message", equalTo(mensaje))));
    }


    @Given("^que quiero consultar los employees$")
    public void que_quiero_consultar_los_employees() throws Exception {
        david.whoCan(CallAnApi.at(restApiUrl));
    }


    @When("^cuando consulte los  employee$")
    public void cuando_consulte_los_employee() throws Exception {
        david.attemptsTo(GetEmployees.obtenerEmployees());
    }

    @Then("^se debe consultar los usuarios arrojando el mensaje de (.*)$")
    public void se_debe_consultar_los_usuarios_arrojando_el_mensaje_de(String mensaje) throws Exception {
        david.should(seeThatResponse("usuarios no se pueden consultar", response -> response.statusCode(200).
                body("message", equalTo(mensaje))));
        david.should(seeThatResponse("no se encontraron datos", response -> response.statusCode(200).
                body("data[0].id",equalTo(1) )));
    }



}
