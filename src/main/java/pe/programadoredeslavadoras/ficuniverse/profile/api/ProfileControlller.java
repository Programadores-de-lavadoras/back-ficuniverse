package pe.programadoredeslavadoras.ficuniverse.profile.api;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.programadoredeslavadoras.ficuniverse.profile.domain.model.entities.Profile;
import pe.programadoredeslavadoras.ficuniverse.profile.domain.service.ProfileService;
import pe.programadoredeslavadoras.ficuniverse.profile.mapping.ProfileMapper;
import pe.programadoredeslavadoras.ficuniverse.profile.resource.CreateProfileResource;
import pe.programadoredeslavadoras.ficuniverse.profile.resource.ProfileResource;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ficuniverse/v1/profiles")
public class ProfileControlller {

    private ProfileService profileService;
    private ProfileMapper profileMapper;

    @PostMapping
    public ResponseEntity<ProfileResource> save(@RequestBody CreateProfileResource resource){
        return new ResponseEntity<>(
                profileMapper.toResource(profileService.save(profileMapper.toEntity(resource))),
                HttpStatus.CREATED
        );
    }

    @GetMapping("email/{email}")
    public ResponseEntity<ProfileResource> fetchByEmail(@PathVariable("email") String email){
        return new ResponseEntity<>(
                profileMapper.toResource(profileService.findByEmail(email)),
                HttpStatus.OK
        );
    }
}
