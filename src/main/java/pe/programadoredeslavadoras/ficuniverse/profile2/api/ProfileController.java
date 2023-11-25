package pe.programadoredeslavadoras.ficuniverse.profile2.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.programadoredeslavadoras.ficuniverse.profile2.domain.model.entity.Profile;
import pe.programadoredeslavadoras.ficuniverse.profile2.domain.service.ProfileService;
import pe.programadoredeslavadoras.ficuniverse.profile2.mapping.ProfileMapper;
import pe.programadoredeslavadoras.ficuniverse.profile2.resource.CreateProfileResource;
import pe.programadoredeslavadoras.ficuniverse.profile2.resource.ProfileResource;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/ficuniverse/v1/profiles")
public class ProfileController {
    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    @PostMapping
    public ResponseEntity<ProfileResource> save(@RequestBody CreateProfileResource createProfileResource){
        return new ResponseEntity<>(profileMapper.toResource(profileService.createProfile(profileMapper.toEntity(createProfileResource))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProfileResource>> getAllProfiles(){
        return new ResponseEntity<>(profileService.getAllProfiles().stream().map(this::convertToResource).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(profileMapper.toResource(profileService.getProfileById(id)),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileResource> updateProfile(@PathVariable("id") Integer id, @RequestBody CreateProfileResource createProfileResource){
        return new ResponseEntity<>(profileMapper.toResource(profileService.update(id,profileMapper.toEntity(createProfileResource))),HttpStatus.OK);
    }

    private ProfileResource convertToResource(Profile profile){
        return profileMapper.toResource(profile);
    }



}
