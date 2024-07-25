package io.sdet.msm.web.profile;

import io.sdet.msm.api.ProfilesApi;
import io.sdet.msm.business.profile.Profile;
import io.sdet.msm.business.profile.ProfileService;
import io.sdet.msm.model.ProfileRequest;
import io.sdet.msm.model.ProfileResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ProfilesEndpoint implements ProfilesApi {

    private final ProfileService profileService;
    private final ProfileWebMapper profileWebMapper;

    @Override
    public ResponseEntity<ProfileResponse> createProfile(ProfileRequest profileRequest) {
        Profile profile = profileWebMapper.map(profileRequest);

        Profile createdProfile = profileService.createProfile(profile);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(createdProfile.getName().toLowerCase())
                .toUri();

        return ResponseEntity.created(location).body(profileWebMapper.map(createdProfile));
    }

    @Override
    public ResponseEntity<List<ProfileResponse>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAllProfiles().stream().map(profileWebMapper::map).toList());
    }

    @Override
    public ResponseEntity<ProfileResponse> getProfileByName(String name) {
        ProfileResponse profileResponse = profileWebMapper.map(profileService.getProfileByName(name));
        return ResponseEntity.ok(profileResponse);
    }
}
