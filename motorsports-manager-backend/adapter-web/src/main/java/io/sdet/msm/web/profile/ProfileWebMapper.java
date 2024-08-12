package io.sdet.msm.web.profile;

import io.sdet.msm.business.profile.Profile;
import io.sdet.msm.business.profile.SeasonRegistration;
import io.sdet.msm.business.profile.TrackRecord;
import io.sdet.msm.business.profile.Vehicle;
import io.sdet.msm.model.*;
import org.mapstruct.Mapper;


@Mapper
public interface ProfileWebMapper {
    Profile map(CreateProfileRequest createProfileRequest);

    ProfileResponse map(Profile profile);

    SeasonRegistrationResponse map(SeasonRegistration profile);

    TrackRecordResponse map(TrackRecord profile);

    VehicleResponse map(Vehicle profile);
}
