package pe.programadoredeslavadoras.ficuniverse.fanfic.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.programadoredeslavadoras.ficuniverse.fanfic.domain.model.entitie.Fanfic;
import pe.programadoredeslavadoras.ficuniverse.fanfic.resource.CreateFanficResource;
import pe.programadoredeslavadoras.ficuniverse.fanfic.resource.FanficResource;
import pe.programadoredeslavadoras.ficuniverse.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

@Component
public class FanficMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Fanfic toEntity(CreateFanficResource resource) {
        return this.mapper.map(resource, Fanfic.class);
    }

    public FanficResource toResource(Fanfic fanfic) {
        return this.mapper.map(fanfic, FanficResource.class);
    }
}
