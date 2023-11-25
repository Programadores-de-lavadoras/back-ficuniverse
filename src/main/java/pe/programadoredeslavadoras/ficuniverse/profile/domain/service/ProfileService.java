package pe.programadoredeslavadoras.ficuniverse.profile.domain.service;

import pe.programadoredeslavadoras.ficuniverse.profile.domain.model.entities.Profile;

public interface ProfileService {
    public abstract Profile createProfile(Profile profile);
    public abstract Profile getUserByEmail(String profile_email);
}
