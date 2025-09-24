@CompraExitosa
Feature: Proceso de compra en SauceDemo

  Como usuario existente y habilitado en SauceDemo
  Quiero ingresar a mi cuenta
  Para poder hacer un compra con éxito

  Scenario Outline: Realizar compra con éxito
    Given Tengo credenciales para ingresar a SauceDemo
    When Inicio sesion con usuario y password
    When Agrego producto <producto> al carrito
    And Visualizo mi carrito
    And Completo el formulario de compra con mis datos
    And Finalizo mi compra
    Then debo ver el mensaje de confirmación de compra "Thank you for your order!"
    Examples:
      | producto |
      | "Sauce Labs Backpack" |
      | "Sauce Labs Bolt T-Shirt" |

