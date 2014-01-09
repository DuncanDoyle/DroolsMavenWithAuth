package org.jboss.ddoyle.drools.auth;

import java.util.Properties;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RulesTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(RulesTest.class);
	
	@Test
	public void testScanner() {
		Properties props = System.getProperties();
		LOGGER.info("Using Maven settings: " + props.getProperty("kie.maven.settings.custom"));
		
		LOGGER.info("Starting New-CA Client.");
		KieServices kieServices = KieServices.Factory.get();
		
		ReleaseId releaseId = kieServices.newReleaseId("org.jboss.ddoyle.drools.auth", "MyTestRules", "1.0.0-SNAPSHOT");
		
		KieContainer kieContainer = kieServices.newKieContainer(releaseId);
		
		KieScanner scanner = kieServices.newKieScanner(kieContainer);
		scanner.start(1000);;
		
		LOGGER.info("Creating new KieSession.");
		KieSession kieSession = kieContainer.newKieSession();
		
		LOGGER.info("Disposing KieSession.");
		kieSession.dispose();
	}
	
}
