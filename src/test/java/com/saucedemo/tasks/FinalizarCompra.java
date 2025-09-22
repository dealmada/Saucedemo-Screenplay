package com.saucedemo.tasks;

import com.saucedemo.ui.SaucedemoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class FinalizarCompra implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SaucedemoUI.BTN_FINISH)
        );
    }
}
