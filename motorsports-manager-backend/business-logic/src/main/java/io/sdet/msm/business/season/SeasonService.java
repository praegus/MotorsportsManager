package io.sdet.msm.business.season;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class SeasonService {
    private final SeasonRepository seasonRepository;

    public Season createSeason(Season season) {
        log.info(this.getClass() + ": Creating season {}", season);
        return seasonRepository.createSeason(season);
    }
}
