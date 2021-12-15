package com.foxbox.hoodie.test.e2e.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private StringUtils() {

    }

    public static Set<String> extractUrlFromText(String text) {

        Set<String> urlsFound = new HashSet<>();

        final String regex = "\\b((?:https?)://[-a-zA-Z0-9+&@#/%?=~_|!:, .;]*[-a-zA-Z0-9+&@#/%=~_|])";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            urlsFound.add(text.substring(matcher.start(0), matcher.end(0)));
        }

        return urlsFound;
    }

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(3));
    }

}
