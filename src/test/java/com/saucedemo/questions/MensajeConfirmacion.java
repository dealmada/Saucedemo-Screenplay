package com.saucedemo.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static com.saucedemo.ui.SaucedemoUI.MSG_CONFIRMATION;

public class MensajeConfirmacion {
    public static Question<String> text() {
        return actor -> Text.of(MSG_CONFIRMATION).answeredBy(actor).trim();
    }
}

