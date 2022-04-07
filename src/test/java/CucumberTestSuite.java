
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/consumo_servicio.feature",
        glue = {"com.testautomation.manejo.stepdefinitions"},
        tags = {"@testsUno"}
)
public class CucumberTestSuite {

}
