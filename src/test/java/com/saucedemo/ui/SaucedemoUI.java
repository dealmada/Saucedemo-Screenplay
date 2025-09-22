package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SaucedemoUI {
    // Inicio sesión
    public static final Target TEXT_USERNAME = Target.the("Campo Usuario").located(By.id("user-name"));
    public static final Target TEXT_PASSWORD = Target.the("Campo Password").located(By.id("password"));
    public static final Target BTN_LOGIN = Target.the("Botón Login").located(By.id("login-button"));

    // Agrega al carrito
    public static final Target BTN_ADD_PRODUCT_1 = Target.the("Botón agregar producto 1").located(By.id("add-to-cart-sauce-labs-backpack"));
    public static final Target BTN_ADD_PRODUCT_2 = Target.the("Botón agregar producto 2").located(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
    public static final Target BTN_SHOPPING_CART = Target.the("Ver carrito compra").located(By.className("shopping_cart_link"));

    // Checkout
    public static final Target BTN_CHECKOUT = Target.the("Revisar carrito compras").located(By.id("checkout"));

    // Formulario
    public static final Target TEXT_NAME = Target.the("Campo Nombre").located(By.id("first-name"));
    public static final Target TEXT_LAST_NAME = Target.the("Campo Apellido").located(By.id("last-name"));
    public static final Target TEXT_ZIP = Target.the("Campo Codigo Postal").located(By.id("postal-code"));
    public static final Target BTN_CONTINUE = Target.the("Procesar Formulario").located(By.id("continue"));

    public static final Target BTN_FINISH = Target.the("Finalizar Compra").located(By.id("finish"));
    public static final Target MSG_CONFIRMATION = Target.the("El mensaje de confirmación").located(By.className("complete-header"));
}
