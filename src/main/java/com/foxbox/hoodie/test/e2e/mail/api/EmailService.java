package com.foxbox.hoodie.test.e2e.mail.api;

import com.foxbox.hoodie.test.e2e.mail.model.Inbox;
import com.foxbox.hoodie.test.e2e.mail.model.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmailService {

    private static final String ENDPOINT = "https://www.1secmail.com/api/v1/";

    private final String email;
    private final String login;
    private final String domain;

    private Gson gson;

    public EmailService(String email) {

        Unirest.config()
                .defaultBaseUrl(ENDPOINT)
                .setDefaultHeader("Content-Type", "application/json");

        this.email = email;
        this.login = email.split("@")[0];
        this.domain = email.split("@")[1];
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public List<Inbox> getInbox() {

        HttpResponse<JsonNode> response =
                Unirest.get("/")
                        .queryString("action", "getMessages")
                        .queryString("login", this.login)
                        .queryString("domain", this.domain)
                        .asJson();

        Inbox[] inbox = gson.fromJson(response.getBody().toString(), Inbox[].class);

        return Arrays.asList(inbox);
    }

    public int getMessagesCount() {
        return this.getInbox().size();
    }

    public boolean hasMessages() {
        return this.getMessagesCount() >= 1;
    }

    public Message getMessageBy(Long id) {

        HttpResponse<JsonNode> response =
                Unirest.get("/")
                        .queryString("action", "readMessage")
                        .queryString("login", this.login)
                        .queryString("domain", this.domain)
                        .queryString("id", id)
                        .asJson();

        return gson.fromJson(response.getBody().toString(), Message.class);
    }

    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>();

        getInbox().forEach(message -> messages.add(this.getMessageBy(message.getId())));

        return messages;
    }

    public Message getLastMessage() {
        if (! hasMessages()) {
            throw new IllegalArgumentException("No messages found for '" + email + "'");
        }

        return this.getAllMessages().get(0);
    }



    public static void main(String[] args) {
        EmailService emailService = new EmailService("user35049-prod@1secmail.com");
        System.out.println(emailService.getMessagesCount());

//        StringUtils.extractUrlFromText(emailService.getAllMessages().get(0).getHtmlBody())
//                .stream()
//                .filter(url -> url.contains("reset-password"))
////                .filter(url -> url.contains("email-verification"))
//                .forEach(System.out::println);
    }



}
