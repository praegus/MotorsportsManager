package io.sdet.msm.configuration;

import io.cucumber.java.Before;
import io.sdet.msm.data.profile.ProfileRepositoryJPA;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.beans.factory.annotation.Autowired;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumber.json")
public class CucumberRunnerTest {

    @Autowired
    ProfileRepositoryJPA profileRepositoryJPA;

    //Before hook cleans database before scenarios run
    @Before
    public void clearProfilesTable() {
        profileRepositoryJPA.deleteAll();
    }
}
