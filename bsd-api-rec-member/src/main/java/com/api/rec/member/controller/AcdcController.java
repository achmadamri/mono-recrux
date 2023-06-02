package com.api.rec.member.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Base64;

@CrossOrigin
@RestController
public class AcdcController {
    @Autowired
	private Environment env;

    @RequestMapping(value = "/")
    public String index() {
        return "/advanced-integration/public/index";
    }

    @RequestMapping("/api/token")
    public String generateClientToken() throws JSONException {
        String accessToken = "Bearer " + generateAccessToken();
        String url = "https://api-m.sandbox.paypal.com/v1/identity/generate-token";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", accessToken);
        headers.set("Accept-Language", "en_US");
        String req = "{}";
        HttpEntity requestHeader = new HttpEntity(req, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestHeader, String.class);
        JSONObject jsonResponse = new JSONObject(response.getBody());
        return jsonResponse.toString();
    }

    @RequestMapping("/api/orders")
    public String createOrder() throws JSONException {
        String accessToken = "Bearer " + generateAccessToken();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // PurchaseUnits purchaseJsonObject = new PurchaseUnits();
        headers.set("Authorization", accessToken);
        JSONObject order = new JSONObject();
        JSONObject purchaseUnits = new JSONObject();
        JSONObject amount = new JSONObject();
        amount.put("value", "100.00");
        amount.put("currency_code", "USD");
        purchaseUnits.put("amount", amount);
        order.put("purchaseunits", Arrays.asList(purchaseUnits));
        order.put("intent", "capture");

        // JsonObject purchaseJson = new JsonObject();
        String req = "{\"intent\": \"CAPTURE\",\\n" +
                "    \"purchase_units\": [\\n" +
                "        {\\n" +
                "            \"amount\": {\\n" +
                "                \"currency_code\": \"USD\",\\n" +
                "                \"value\": \"83.04\"\\n" +
                "            }\\n" +
                "        }\\n" +
                "    ]\\n" +
                "}";
        HttpEntity requestHeader = new HttpEntity(req, headers);
        String url = "https://api-m.sandbox.paypal.com/v2/checkout/orders";
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestHeader, String.class);
        // System.out.println(response.toString());
        String responseString = response.toString();
        JSONObject jsonResponse = new JSONObject(response.getBody());
        String orderId = jsonResponse.getString("id");
        return jsonResponse.toString();
    }

    @RequestMapping("/api/orders/{orderId}/capture")
    public String capturePayment(@PathVariable("orderId") String orderId) throws JSONException {
        String accessToken = "Bearer " + generateAccessToken();
        return capturePayment(accessToken, String.valueOf(orderId));
    }

    public String capturePayment(String accessToken, String orderId) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", accessToken);
        String req = "{}";
        HttpEntity requestHeader = new HttpEntity(req, headers);
        String url = "https://api-m.sandbox.paypal.com/v2/checkout/orders/" + orderId + "/capture";
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestHeader, String.class);
        // System.out.println(response.toString());
        String responseString = response.toString();
        JSONObject jsonResponse = new JSONObject(response.getBody());
        String orderIds = jsonResponse.getString("id");
        return jsonResponse.toString();
    }

    public String generateAccessToken() throws JSONException {
        String clientIdSecret = env.getProperty("paypall.client_id") + ":" + env.getProperty("paypall.client_secret");
        String encodedClientId = Base64.getEncoder().encodeToString(clientIdSecret.getBytes());
        System.out.println("Client Id= " + encodedClientId);
        String template = "Basic " + encodedClientId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", template);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");
        map.add("response_type", "token");
        map.add("ignoreCache", "true");
        HttpEntity requestHeader = new HttpEntity(map, headers);
        String url = "https://api-m.sandbox.paypal.com/v1/oauth2/token";
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestHeader, String.class);
        // System.out.println(response.toString());
        JSONObject jsonResponse = new JSONObject(response.getBody());
        String accessToken = jsonResponse.getString("access_token");
        return accessToken;
    }

}