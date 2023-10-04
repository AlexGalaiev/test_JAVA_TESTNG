package org.functions;

import net.datafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomUser {
    Faker faker = new Faker();
    Random random = new Random();
    public RandomUser(){
        generateRandomPerson();
    }

    public Map<String, String> generateRandomPerson(){
        Map<String, String> randomPerson = new HashMap<String, String>();
        randomPerson.put("firstName", faker.name().firstName());
        randomPerson.put("lastName", faker.name().lastName());
        randomPerson.put("userEmail", faker.name().firstName().toString()+faker.name().lastName().toString()+"@i.com");
        randomPerson.put("age", String.valueOf(random.nextInt(90)));
        randomPerson.put("salary", String.valueOf(random.nextInt(10000)));
        randomPerson.put("department", String.valueOf(faker.funnyName().name()));
        return randomPerson;
    }
}
