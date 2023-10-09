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
        randomPerson.put("firstName", getFakeName());
        randomPerson.put("lastName", getFakeLastName());
        randomPerson.put("userEmail", getFakeUsermail());
        randomPerson.put("age", getFakeAge());
        randomPerson.put("salary", getFakeSalary());
        randomPerson.put("department", getFakeDepartment());
        return randomPerson;
    }

    private String getFakeName(){
        return faker.name().firstName();
    }
    private String getFakeLastName(){
        return faker.name().lastName();
    }
    private String getFakeUsermail(){
        return faker.name().firstName().toString()+faker.name().lastName().toString()+"@i.com";
    }
    private String getFakeAge(){
        return String.valueOf(random.nextInt(90));
    }
    private String getFakeSalary(){
        return String.valueOf(random.nextInt(10000));
    }
    private String getFakeDepartment(){
        return String.valueOf(faker.funnyName().name());
    }
}
