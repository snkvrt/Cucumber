package steps;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;


import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    WebDriver webDriver;

    @Before
    public void setupDriver(){
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void closeDriver(){
        webDriver.quit();
    }




    @Given("l'utilisateur est sur la page de connexion {string}")
    public void l_utilisateur_est_sur_la_page_de_connexion(String url) {

        webDriver.get(url);

    }

    @When("l'utilisateur insère son identifiant valide dans le champ associé {string}")
    public void lUtilisateurInsèreSonIdentifiantValideDansLeChampAssocié(String username) {

        WebElement saisie_Login = webDriver.findElement(By.id("user-name"));

        saisie_Login.sendKeys(username);

    }


    @And("qu'il insère son mot de passe valide dans le champ associé {string}")
    public void quIlInsèreSonMotDePasseValideDansLeChampAssocié(String password) {
        WebElement saisie_Password = webDriver.findElement(By.id("password"));
        saisie_Password.sendKeys(password);
    }

    @And("^qu'il appuie sur le bouton connexion")
    public void quIlAppuieSurLeBoutonConnexion() {
        WebElement btn_Connexion = webDriver.findElement(By.id("login-button"));
        btn_Connexion.click();

    }

    @Then("^l'utilisateur se connecte avec succès$")
    public void lUtilisateurSeConnecteAvecSuccès() {

        Assert.assertEquals("Products", webDriver.findElement(By.className("title")).getText());

    }

    @When("l'utilisateur insère son identifiant invalide dans le champ associé {string}")
    public void lUtilisateurInsèreSonIdentifiantInvalideDansLeChampAssocié(String s) {

        WebElement saisie_Login = webDriver.findElement(By.id("user-name"));

        saisie_Login.sendKeys(s);


    }

    @And("qu'il insère son mot de passe invalide dans le champ associé {string}")
    public void quIlInsèreSonMotDePasseInvalideDansLeChampAssocié(String s) {

        WebElement saisie_Password = webDriver.findElement(By.id("password"));
        saisie_Password.sendKeys(s);

    }

    @Then("la connexion de l'utilisateur échoue")
    public void laConnexionDeLUtilisateurÉchoue() {

        Assert.assertTrue(webDriver.findElement(By.className("error-button")).isDisplayed());

    }


}
