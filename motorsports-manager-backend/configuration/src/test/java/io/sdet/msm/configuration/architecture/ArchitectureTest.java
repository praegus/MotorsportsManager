package io.sdet.msm.configuration.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.core.importer.ImportOption;
import io.orangebeard.listener.OrangebeardExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.tngtech.archunit.junit.ArchTest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "io.sdet.msm", importOptions = ImportOption.DoNotIncludeTests.class)
@ExtendWith(OrangebeardExtension.class)
class ArchitectureTest {

    @ArchTest
    static final ArchRule SOME_ARCHITECTURE_RULE =
        classes().that().haveSimpleNameContaining("Configuration").should().beAnnotatedWith(EnableWebMvc.class);

}
