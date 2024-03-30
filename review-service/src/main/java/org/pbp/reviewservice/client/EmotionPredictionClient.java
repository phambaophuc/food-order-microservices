package org.pbp.reviewservice.client;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@Slf4j
public class EmotionPredictionClient {

    private final RestTemplate restTemplate;
    private final String EMOTION_URL = "http://localhost:5000/predict-emotion";

    public EmotionPredictionClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String predictEmotion(String comment) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            JSONObject requestBodyJson = new JSONObject();
            requestBodyJson.put("text", comment);

            HttpEntity<String> requestBody = new HttpEntity<>(requestBodyJson.toString(), headers);

            String responseBody = restTemplate.postForObject(EMOTION_URL, requestBody, String.class);

            JSONObject jsonResponse = new JSONObject(responseBody);
            return jsonResponse.getString("emotion");
        } catch (JSONException e) {
            log.error("Error parsing JSON response: " + e.getMessage());
            return "Unknown";
        } catch (Exception e) {
            log.error("Error processing request: " + e.getMessage());
            return "Unknown";
        }
    }
}
