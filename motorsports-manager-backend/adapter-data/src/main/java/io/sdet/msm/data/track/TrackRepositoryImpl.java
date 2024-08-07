package io.sdet.msm.data.track;

import io.sdet.msm.business.track.Track;
import io.sdet.msm.business.track.TrackRepository;
import io.sdet.msm.exception.ProfileDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TrackRepositoryImpl implements TrackRepository {
    private final TrackRepositoryJPA trackRepositoryJPA;
    private final TrackDataMapper trackDataMapper;

    @Override
    public Track getById(long id) {
        return null;
    }

    @Override
    public Track createTrack(Track track) {
        if (trackRepositoryJPA.findByNameIgnoreCase(track.getName()).isPresent()) {
            throw new ProfileDuplicatedException("Track with name '" + track.getName() + "' already exists");
        }

        return trackDataMapper.map
                (trackRepositoryJPA.save(trackDataMapper.map(track)));
    }

    @Override
    public List<Track> getAllTracks() {
        return List.of();
    }
}
