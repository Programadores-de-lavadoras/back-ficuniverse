package pe.programadoredeslavadoras.ficuniverse.creation.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("creationMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ChapterMapper chapterMapper() {
        return new ChapterMapper();
    }
}
