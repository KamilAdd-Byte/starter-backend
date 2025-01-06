package pl.ryestarter.sourdough.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ryestarter.basic.StarterActiveDTO;
import pl.ryestarter.basic.StarterCreatedDTO;
import pl.ryestarter.basic.StarterDTO;
import pl.ryestarter.sourdough.service.StarterService;

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
    public ResponseEntity<StarterCreatedDTO> createStarter(
            @Parameter(description = "Details of the starter to be created")
            @RequestBody StarterDTO starterDTO) {
        StarterCreatedDTO newStarter = starterService.createNewStarter(starterDTO);
        return ResponseEntity.ok(newStarter);
    }

    @GetMapping("/active")
    public ResponseEntity<StarterActiveDTO> getActiveStarter() {
        StarterActiveDTO activeStarter = starterService.getActiveStarter();
        return ResponseEntity.ok(activeStarter);
    }
}
