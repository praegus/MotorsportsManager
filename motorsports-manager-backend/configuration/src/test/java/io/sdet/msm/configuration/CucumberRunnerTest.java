package io.sdet.msm.configuration;

import io.cucumber.java.After;
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

    //After hooks clean table after scenarios tagged with @DirtiesProfiles
    @After(value="@DirtiesProfiles")
    public void clearProfilesTable() {
        profileRepositoryJPA.deleteAll();
    }
}
