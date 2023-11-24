package pe.programadoredeslavadoras.ficuniverse.fanfic.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.programadoredeslavadoras.ficuniverse.fanfic.domain.model.entitie.Fanfic;
import pe.programadoredeslavadoras.ficuniverse.fanfic.domain.service.FanficService;
import pe.programadoredeslavadoras.ficuniverse.fanfic.mapping.FanficMapper;
import pe.programadoredeslavadoras.ficuniverse.fanfic.resource.CreateFanficResource;
import pe.programadoredeslavadoras.ficuniverse.fanfic.resource.FanficResource;
import pe.programadoredeslavadoras.ficuniverse.shared.exception.InternalServerErrorException;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/ficuniverse/v1/fanfics")
public class FanficController {
    private final FanficService fanficService;
    private final FanficMapper fanficMapper;

    @Operation(
            summary = "Add a new fanfic" ,
            description = "Add a new fanfic",
            operationId = "addFanfic",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = FanficResource.class)
                            )
                    ),
                    @ApiResponse (
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )
    @PostMapping
    public ResponseEntity<FanficResource> save(@RequestBody CreateFanficResource resource){
        /*Fanfic fanfic = fanficMapper.toEntity(resource);
        Fanfic savedFanfic = fanficService.save(fanfic);*/
        return new ResponseEntity<>(
                fanficMapper.toResource(fanficService.save(fanficMapper.toEntity(resource))),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Fanfic>> fetchAll(){
        return ResponseEntity.ok(fanficService.fechAll());
    }

    @Operation(
            summary = "Get a fanfic by its id" ,
            description = "Gets a fanfic fetched by its id",
            operationId = "getFanficById",
            responses = {
                    @ApiResponse (
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = FanficResource.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<FanficResource> fetchById(@PathVariable("id") Integer id){
        Fanfic fanfic = fanficService.fetchById(id);
        return new ResponseEntity<>(
                fanficMapper.toResource(fanficService.fetchById(id)),
                HttpStatus.OK);
    }

    @GetMapping("title/{title}")
    public ResponseEntity<FanficResource> fetchByTitle(@PathVariable("title") String title) {
        return new ResponseEntity<>(
                fanficMapper.toResource(fanficService.findByTitle(title)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        if(fanficService.deleteById(id)){
            return ResponseEntity.noContent().build();
        }
        throw new InternalServerErrorException("Fanfic", "id", String.valueOf(id), "deleted");
    }
}
