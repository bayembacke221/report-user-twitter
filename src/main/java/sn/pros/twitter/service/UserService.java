package sn.pros.twitter.service;

import org.springframework.stereotype.Service;
import sn.pros.twitter.model.UserReport;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@Service
public class UserService {
    public void reportUser(UserReport userReport) throws TwitterException {

        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(userReport.getApiKey(), userReport.getApiSecretKey());
        twitter.setOAuthAccessToken(new AccessToken(userReport.getAccessToken(), userReport.getAccessTokenSecret()));

        for (int i = 1; i < userReport.getReportCount(); i++) {
            twitter.reportSpam(userReport.getScreenName());
        }
    }
}

