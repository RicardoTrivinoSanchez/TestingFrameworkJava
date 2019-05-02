package com.trivinosanchez;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"}, features="/home/ricardo/Projects/TestingFrameworkJava/src/test/resources/features", glue="")
public class CucumberRunner {

}
