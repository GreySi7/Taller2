package com.vichamalab.api.producto.hooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ScenarioHook {
	private static final Logger logger = LoggerFactory.getLogger(ScenarioHook.class);
	
	   @Before
	    public void SetupScenario(Scenario scenario) {
	        String scenarioName = scenario.getName();
	        String featureName = scenario.getUri().toString();

	        logger.info("Iniciando el escenario: " + scenarioName);
	        logger.info("Feature: " + featureName);
	    }
	
	    @After
	    public void CleanScenarios(Scenario scenario) {
	        String scenarioName = scenario.getName();
	        String featureName = scenario.getUri().toString();

	        logger.info("Escenario finalizado: " + scenarioName);
	        logger.info("Feature: " + featureName);
	        logger.info("Estado del escenario: " + scenario.getStatus());
	    }

}
