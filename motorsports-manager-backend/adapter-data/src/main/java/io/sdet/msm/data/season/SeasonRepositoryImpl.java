package io.sdet.msm.data.season;

import io.sdet.msm.business.season.Season;
import io.sdet.msm.business.season.SeasonRepository;
import io.sdet.msm.exception.ProfileDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SeasonRepositoryImpl implements SeasonRepository {
    private final SeasonRepositoryJPA seasonRepositoryJPA;
    private final SeasonDataMapper seasonDataMapper;

    @Override
    public Season getSeason(String name) {
        return null;
    }

    @Override
    public Season createSeason(Season season) {

        if (seasonRepositoryJPA.findByNameIgnoreCase(season.getName()).isPresent()) {
            throw new ProfileDuplicatedException("Season with name '" + season.getName() + "' already exists");
        }

        return seasonDataMapper.map
                (seasonRepositoryJPA.save(seasonDataMapper.map(season)));
    }
}
