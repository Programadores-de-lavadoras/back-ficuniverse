package pe.programadoredeslavadoras.ficuniverse.profile2.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.programadoredeslavadoras.ficuniverse.profile2.domain.model.entity.Profile;
import pe.programadoredeslavadoras.ficuniverse.profile2.resource.CreateProfileResource;
import pe.programadoredeslavadoras.ficuniverse.profile2.resource.ProfileResource;
import pe.programadoredeslavadoras.ficuniverse.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

@Component
public class ProfileMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Profile toEntity(CreateProfileResource resource) {
        return this.mapper.map(resource, Profile.class);
    }

    public ProfileResource toResource(Profile profile) {
        return this.mapper.map(profile, ProfileResource.class);
    }
}
