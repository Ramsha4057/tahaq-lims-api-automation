package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    static int passedCount = 0;
    static int failedCount = 0;

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            failedCount++;

            System.out.println("❌ FAILED: " + scenario.getName());

        } else {

            passedCount++;

            System.out.println("✅ PASSED: " + scenario.getName());
        }

        System.out.println("----------------------------------");
        System.out.println("TOTAL PASSED: " + passedCount);
        System.out.println("TOTAL FAILED: " + failedCount);
        System.out.println("----------------------------------");
    }
}