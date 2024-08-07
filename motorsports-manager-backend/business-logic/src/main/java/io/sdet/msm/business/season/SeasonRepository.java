package io.sdet.msm.business.season;

public interface SeasonRepository {

    Season getSeason(String name);

    Season createSeason(io.sdet.msm.business.season.Season season);
}
