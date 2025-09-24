package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AgregarProducto implements Task {
    private final String producto;

    public AgregarProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target botonProducto = Target.the("Botón para agregar el producto " + producto)
                .located(By.xpath("//button[@id='add-to-cart-" + producto.replaceAll(" ", "-").toLowerCase() + "']"));
        actor.attemptsTo(
                Click.on(botonProducto)
        );
    }
}