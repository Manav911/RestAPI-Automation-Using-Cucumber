package com.testing.testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/testing/features",glue = "com.testing.stepDefinations")
public class PlaceTestRunner {

}
