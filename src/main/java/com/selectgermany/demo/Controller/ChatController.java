package com.selectgermany.demo.Controller;

import com.selectgermany.demo.DTO.ChatRequest;
import com.selectgermany.demo.DTO.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
public class ChatController {

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;
    @Value("${openai.api.url}")
    private String apiUrl;

    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) throws UnsupportedEncodingException {
        ChatRequest request = new ChatRequest(model, prompt);

        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);
        if ((response == null || response.getChoices() == null || response.getChoices().isEmpty())){
            return "no response";
        }
        return response.getChoices().get(0).getMessage().getContent();
    }
}
