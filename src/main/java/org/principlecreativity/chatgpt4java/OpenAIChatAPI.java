package org.principlecreativity.chatgpt4java;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.*;

import java.util.HashMap;
import java.util.Map;

public class OpenAIChatAPI {
    private String output;

    public OpenAIChatAPI() {
    }

    public String generateResponse(String prompt) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        JSONObject json = new JSONObject();
        json.set("model", "text-davinci-003");

        json.set("prompt", prompt);
        json.set("temperature", 0);
        json.set("max_tokens", 100);
        json.set("top_p", 1);
        json.set("frequency_penalty", 0.0);
        json.set("presence_penalty", 0.0);

        HttpResponse response = HttpRequest.post("https://api.openai.com/v1/completions")
                .headerMap(headers, false)
                .bearerAuth("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")
                .body(String.valueOf(json))
                .timeout(5 * 60 * 1000)
                .execute();
        String jsonText = response.body();
        JSONObject object = JSONUtil.parseObj(jsonText);
        JSONArray array = object.getJSONArray("choices");
        for(int i = 0; i < array.size(); i++){
            JSONObject obj = array.getJSONObject(i);
            output = obj.get("text", String.class);
        }
        return output;
    }
    }
