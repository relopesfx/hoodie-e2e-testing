package com.foxbox.hoodie.test.e2e.mail.model;

import lombok.Data;

public @Data class Message {

    private Long id;
    private String from;
    private String subject;
    private String date;
//    private String[] attachments;
    private String body;
    private String textBody;
    private String htmlBody;

}
