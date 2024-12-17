package pl.starter.bread.starter.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.starter.bread.basic.StarterDTO;
import pl.starter.bread.starter.service.StarterService;

@RestController
@RequestMapping("api/v1/starter")
@RequiredArgsConstructor
public class StarterController {

    private final StarterService starterService;

    @Operation(
            summary = "Create a new starter",
            description = "This endpoint allows you to create a new starter by providing its details."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Starter created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input provided")
    })
    @PostMapping
    public ResponseEntity<StarterDTO> createStarter(
            @Parameter(description = "Details of the starter to be created")
            @RequestBody StarterDTO starterDTO) {
        StarterDTO createdStarter = starterService.createNewStarter(starterDTO);
        return ResponseEntity.ok(createdStarter);
    }
}
