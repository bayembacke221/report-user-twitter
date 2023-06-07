package sn.pros.twitter.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserReport {
    @NotBlank
    private String apiKey;
    @NotBlank
    private String apiSecretKey;
    @NotBlank
    private String accessToken;
    @NotBlank
    private String accessTokenSecret;
    @NotBlank
    private String screenName;
    private int reportCount;


}

