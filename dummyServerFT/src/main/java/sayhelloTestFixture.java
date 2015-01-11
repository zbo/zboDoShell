import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
/**
 * Created by twer on 14-12-30.
 */
@RunWith(ConcordionRunner.class)
public class sayhelloTestFixture {
    public String getGreeting() {
        return "Hello World!";
    }
}



