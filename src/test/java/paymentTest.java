import org.junit.Assert;
import org.junit.Test;

public class paymentTest extends paymentTestMethods {
    @Test
    public void Test() throws InterruptedException {
        paymentTest pt1 = new paymentTest();
        pt1.Setup();
        pt1.verifyPageTitle();
        pt1.verifytermsAndConditionsButton();
        pt1.verifyPrivacyButton();
        pt1.InputCardDetails();
        pt1.compareUrl();

    }
}
