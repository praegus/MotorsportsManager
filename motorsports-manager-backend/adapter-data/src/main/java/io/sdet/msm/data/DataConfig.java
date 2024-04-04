package io.sdet.msm.data;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "io.sdet.msm.data")
@EntityScan("io.sdet.msm.data.*")
@Configuration
public class DataConfig {
}
