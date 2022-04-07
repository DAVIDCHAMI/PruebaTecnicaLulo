Feature: Consumo de servicios


  Scenario: crear usuario
    Given que quiero crear un employee
    When cuando consuma el servicio con sebas, salario 214 y edad 24
    Then se debe crear el usuario arrojando el mensaje de Successfully! Record has been added.


  Scenario: Eliminar usuario
    Given que quiero eleiminar un employee
    When elimine el employee 8
    Then se debe eliminar el employee arrojando el mensaje de Successfully! Record has been deleted


  Scenario: consultar un usuario
    Given que quiero consultar un employee
    When cuando consulte el  employee 1
    Then se debe consultar el usuario arrojando el mensaje de Successfully! Record has been fetched.

  Scenario: consultar todos los usuarios
    Given que quiero consultar los employees
    When cuando consulte los  employee
    Then se debe consultar los usuarios arrojando el mensaje de Successfully! All records has been fetched.
