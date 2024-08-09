package io.sdet.msm.data.season;

import io.sdet.msm.business.season.Season;
import io.sdet.msm.business.season.SeasonRepository;
import io.sdet.msm.exception.SeasonDuplicatedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SeasonRepositoryImpl implements SeasonRepository {
    private final SeasonRepositoryJPA seasonRepositoryJPA;
    private final SeasonDataMapper seasonDataMapper;

    @Override
    public Season createSeason(Season season) {

        if (seasonRepositoryJPA.findByNameIgnoreCase(season.getName()).isPresent()) {
            throw new SeasonDuplicatedException("Season with name '" + season.getName() + "' already exists");
        }

        return seasonDataMapper.map
                (seasonRepositoryJPA.save(seasonDataMapper.map(season)));
    }

    @Override
    public Season getSeasonById(String id) {
        return seasonDataMapper.map(seasonRepositoryJPA.getReferenceById(id));
    }
}
