package io.sdet.msm.configuration;

import io.cucumber.java.Before;
import io.sdet.msm.data.profile.ProfileRepositoryJPA;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.beans.factory.annotation.Autowired;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
public class CucumberRunnerTest {

    @Autowired
    ProfileRepositoryJPA profileRepositoryJPA;

    //Before hook cleans database before scenarios run
    @Before
    public void clearProfilesTable() {
        profileRepositoryJPA.deleteAll();
    }
}
