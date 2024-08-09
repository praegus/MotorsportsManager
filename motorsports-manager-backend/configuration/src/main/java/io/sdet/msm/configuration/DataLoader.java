package io.sdet.msm.configuration;

import io.sdet.msm.business.season.Season;
import io.sdet.msm.business.season.SeasonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {
    private final SeasonRepository seasonRepository;

    public DataLoader(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    public void run(ApplicationArguments args) {
        log.info("Dataloader is loading initial season");
        seasonRepository.createSeason(Season.builder().name("2024-2025").build());
    }
}
