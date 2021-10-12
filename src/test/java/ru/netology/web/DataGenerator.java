package ru.netology.web;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    private Faker faker;
    private LocalDate today = LocalDate.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String generateCity() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.address().cityName();
    }

    public static String generatePhone() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
    }
}
