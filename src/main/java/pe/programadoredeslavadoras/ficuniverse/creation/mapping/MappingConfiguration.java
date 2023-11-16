package pe.programadoredeslavadoras.ficuniverse.creation.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("ficuniverseMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ChapterMapper chapterMapper() {
        return new ChapterMapper();
    }
}
