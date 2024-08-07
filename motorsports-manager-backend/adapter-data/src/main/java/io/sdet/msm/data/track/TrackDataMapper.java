package io.sdet.msm.data.track;

import io.sdet.msm.business.track.Track;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrackDataMapper {
    TrackEntity map(Track track);

    Track map(TrackEntity trackEntity);
}
