package sn.pros.twitter.web;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sn.pros.twitter.model.UserReport;
import sn.pros.twitter.service.UserService;
import twitter4j.TwitterException;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Tutorial", description = "Tutorial management APIs")
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = UserReport.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/report-user")
    public ResponseEntity<String> reportUser(@RequestBody UserReport userReport) {
        try {
            userService.reportUser(userReport);
            return new ResponseEntity<>("User reported successfully.", HttpStatus.OK);
        } catch (TwitterException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to report user.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
