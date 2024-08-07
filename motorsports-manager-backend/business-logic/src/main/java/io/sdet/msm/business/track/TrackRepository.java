package io.sdet.msm.business.track;

import java.util.List;

public interface TrackRepository {
    Track getById(long id);

    Track createTrack(Track track);

    List<Track> getAllTracks();

}
