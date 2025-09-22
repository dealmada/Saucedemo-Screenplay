package com.saucedemo.tasks;

import com.saucedemo.ui.SaucedemoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

public class Formulario implements Task {

    private final String nombre;
    private final String apellido;
    private final String codigoPostal;

    public Formulario(String nombre, String apellido, String codigoPostal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoPostal = codigoPostal;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(nombre).into(SaucedemoUI.TEXT_NAME),
            Enter.theValue(apellido).into(SaucedemoUI.TEXT_LAST_NAME),
            Enter.theValue(codigoPostal).into(SaucedemoUI.TEXT_ZIP),
            Click.on(SaucedemoUI.BTN_CONTINUE)
        );
    }
}
