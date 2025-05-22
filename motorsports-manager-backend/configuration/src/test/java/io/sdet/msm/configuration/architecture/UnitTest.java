package io.sdet.msm.configuration.architecture;

import io.orangebeard.listener.OrangebeardExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OrangebeardExtension.class)
public class UnitTest {

    @Test
    void test() {
        assertThat(Math.round(Math.random()*2)).isEqualTo(1);
    }
}
