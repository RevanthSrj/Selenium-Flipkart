package runnerPack;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import basePack.BaseFlip;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src\\test\\java\\featurePack\\flipkart.feature",glue = "stepPack",dryRun = false)
public class RunnerFlipkart extends BaseFlip {

	@BeforeClass
	public static void start() {
		Bowserlaunch();
		Maximize();
	}
	@AfterClass
	public static void end() {
//		driver.quit();
	}
	
}
