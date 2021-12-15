package com.foxbox.hoodie.test.e2e.mail.model;

import lombok.Data;

public @Data class Inbox {

    private Long id;
    private String from;
    private String subject;
    private String date;

}
