package pe.programadoredeslavadoras.ficuniverse.profile.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pe.programadoredeslavadoras.ficuniverse.profile.domain.model.entities.Profile;
import pe.programadoredeslavadoras.ficuniverse.profile.domain.persistance.ProfileRepository;
import pe.programadoredeslavadoras.ficuniverse.profile.domain.service.ProfileService;
import pe.programadoredeslavadoras.ficuniverse.profile.mapping.ProfileMapper;
import pe.programadoredeslavadoras.ficuniverse.profile.resource.CreateProfileResource;
import pe.programadoredeslavadoras.ficuniverse.profile.resource.ProfileResource;
import pe.programadoredeslavadoras.ficuniverse.shared.exception.ResourceValidationException;
import pe.programadoredeslavadoras.ficuniverse.shared.exceptions.FetchNotFoundException;

import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;
    private final Validator validator;

    @Transactional
    @Override
    public Profile save(Profile profile){
        Set<ConstraintViolation<Profile>> violation = validator.validate(profile);
        if (violation.isEmpty()){
            return profileRepository.save(profile);
        }
        throw new ResourceValidationException("Profile",violation);
    }

    @Transactional(readOnly = true)
    @Override
    public Profile findByEmail(String email){
        Optional<Profile> optionalProfile = profileRepository.sqlFindByEmail(email);
        if (optionalProfile.isPresent()){
            return optionalProfile.get();
        }
        throw new FetchNotFoundException("Profile","email",email);
    }
}
