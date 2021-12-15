package com.foxbox.hoodie.test.e2e.utils;

import com.foxbox.hoodie.test.e2e.config.PropertiesManager;
import com.github.javafaker.Faker;

import java.util.Locale;

public abstract class DataFactory<T> {

    protected Faker faker;

    public DataFactory() {
        this.faker = new Faker(new Locale(PropertiesManager.get().fakerLocale()));
    }

    public abstract T create();
}
