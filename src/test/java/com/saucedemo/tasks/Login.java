package com.saucedemo.tasks;

import com.saucedemo.ui.SaucedemoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Tasks;

public class Login implements Task {

    private final String usuario;
    private final String password;

    public Login(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public static Login withCredentials(String usuario, String password) {
        return Tasks.instrumented(Login.class, usuario, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(SaucedemoUI.TEXT_USERNAME),
                Enter.theValue(password).into(SaucedemoUI.TEXT_PASSWORD),
                Click.on(SaucedemoUI.BTN_LOGIN)
        );
    }
}
