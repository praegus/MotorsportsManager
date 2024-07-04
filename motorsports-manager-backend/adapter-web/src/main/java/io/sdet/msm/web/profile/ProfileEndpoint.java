package io.sdet.msm.web.profile;

import io.sdet.msm.api.ProfileApi;
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
public class ProfileEndpoint implements ProfileApi {

    private final ProfileService profileService;
    private final ProfileWebMapper profileWebMapper;

    @Override
    public ResponseEntity<Void> createProfile(ProfileRequest profileRequest) {
        Profile profile = profileWebMapper.map(profileRequest);

        profileService.createProfile(profile);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(profile.getName())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<List<ProfileResponse>> getProfile() {
        return null;
    }
}
