package io.sdet.msm.business.season;

public interface SeasonRepository {

    Season createSeason(Season season);

    Season getSeasonById(String name);
}
