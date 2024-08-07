package io.sdet.msm.data.season;

import io.sdet.msm.business.season.Season;
import io.sdet.msm.business.vehicle.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeasonDataMapper {
    SeasonEntity map(Season season);

    Season map(SeasonEntity seasonEntity);

    Vehicle map(String value);

    String map(Vehicle value);
}
