package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.SaucedemoPage;
import com.saucedemo.tasks.AgregarProducto;
import com.saucedemo.tasks.Formulario;
import com.saucedemo.tasks.Login;
import com.saucedemo.tasks.VerCarrito;
import com.saucedemo.tasks.FinalizarCompra;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import com.saucedemo.models.DatosCompra;
import com.saucedemo.utils.JsonReader;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import com.saucedemo.questions.MensajeConfirmacion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinitions {

    WebDriver driver;

    private DatosCompra datosCompra;
    private Actor actor;

    @Before
    public void setUp() {
        // descarga y configura el ChromeDriver adecuado
        WebDriverManager.chromedriver().setup();

        // Opciones de navegador
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito"); // modo incógnito por popup de google

        WebDriverManager.chromedriver().setup();

        // Inicia el driver
        driver = new ChromeDriver(options);

        // Configura el escenario de Screenplay
        OnStage.setTheStage(new Cast());
        // inicializo al actor
        actor = Actor.named("Usuario");
        OnStage.theActorCalled("Usuario").can(BrowseTheWeb.with(driver));

        datosCompra = JsonReader.leerDatosCompra("src/test/resources/data/datosSaucedemo.json");
    }

    @Given("Tengo credenciales para ingresar a SauceDemo")
    public void ingreso() {
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        actor = Actor.named("Usuario");

        // Asigno habilidad BrowseTheWeb
        actor.can(BrowseTheWeb.with(driver));

        // Intenta abrir la página de Saucedemo
        actor.wasAbleTo(Open.browserOn(new SaucedemoPage()));
    }

    @When("Inicio sesion con usuario y password")
    public void inicioSesionConUsuarioyPassword() {
        String usuario = datosCompra.getUsuario();
        String password = datosCompra.getContrasena();
        actor.attemptsTo(Login.withCredentials(usuario, password));
    }

    @When("Agrego producto {string} al carrito")
    public void AgregoProducto(String p) {
        theActorInTheSpotlight().attemptsTo(new AgregarProducto(p));
    }

    @And("Visualizo mi carrito")
    public void VisualizoCarrito() {
        theActorInTheSpotlight().attemptsTo(new VerCarrito());
    }

    @And("Completo el formulario de compra con mis datos")
    public void CompletoFormulario() {
        DatosCompra.Formulario formulario = datosCompra.getFormulario();
        theActorInTheSpotlight().attemptsTo(
            new Formulario(
                    formulario.getNombre(),
                    formulario.getApellido(),
                    formulario.getCodigoPostal()
            )
        );
    }

    @And("Finalizo mi compra")
    public void FinCompra() {
        theActorInTheSpotlight().attemptsTo(new FinalizarCompra());
    }

    @Then("debo ver el mensaje de confirmación de compra {string}")
    public void Confirmacion(String mensaje) {
        theActorInTheSpotlight().should(
            seeThat("El mensaje de confirmación", MensajeConfirmacion.text(), equalTo(mensaje))
        );
    }
}
