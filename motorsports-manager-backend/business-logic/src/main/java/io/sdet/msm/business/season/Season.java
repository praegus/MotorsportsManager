package io.sdet.msm.business.season;

import io.sdet.msm.business.profile.Profile;
import io.sdet.msm.business.track.Track;
import io.sdet.msm.business.vehicle.Vehicle;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Builder
@Data
public class Season {

    private String name;

    private Vehicle vehicle;

    private List<Track> tracks;

    private Set<Profile> profiles;
}
