package pe.programadoredeslavadoras.ficuniverse.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.programadoredeslavadoras.ficuniverse.profile.domain.model.entities.Profile;
import pe.programadoredeslavadoras.ficuniverse.profile.domain.persistance.ProfileRepository;
import pe.programadoredeslavadoras.ficuniverse.profile.domain.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile createProfile(Profile profile){return profileRepository.save(profile);}
    @Override
    public Profile getUserByEmail(String email){return profileRepository.findByEmail(email);}
}
