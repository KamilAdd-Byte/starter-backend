package pl.starter.feed.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.starter.basic.FeedDTO;
import pl.starter.sourdough.service.StarterService;

@RestController
@RequestMapping("api/v1/starter/feed")
@RequiredArgsConstructor
public class FeedingStarterController {

    private final StarterService starterService;

    @PostMapping
    public ResponseEntity<StarterFeedingDTO> feedStarter(
            @Parameter(description = "Details of the starter to be created")
            @RequestBody FeedDTO feedDTO) {
        StarterFeedingDTO newStarter = starterService.feedStarter(feedDTO);
        return ResponseEntity.ok(newStarter);
    }
}
