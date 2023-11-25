package pe.programadoredeslavadoras.ficuniverse.profile.domain.service;

import pe.programadoredeslavadoras.ficuniverse.profile.domain.model.entities.Profile;

public interface ProfileService {
    Profile save(Profile profile);
    Profile findByEmail(String profile_email);
}
