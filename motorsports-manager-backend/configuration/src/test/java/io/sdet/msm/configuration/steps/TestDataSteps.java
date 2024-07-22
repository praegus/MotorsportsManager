package io.sdet.msm.configuration.steps;

import io.cucumber.java.en.Given;
import io.sdet.msm.data.profile.ProfileEntity;
import io.sdet.msm.data.profile.ProfileRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDataSteps {
    @Autowired
    ProfileRepositoryJPA profileRepositoryJPA;

    @Given("profile {string} already exists")
    public void createProfile(String profileName) {
        var profileEntity = new ProfileEntity();
        profileEntity.setName(profileName);
        profileRepositoryJPA.save(profileEntity);
    }
}
