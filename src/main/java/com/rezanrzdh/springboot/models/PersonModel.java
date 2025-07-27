package com.rezanrzdh.springboot.models;

public class PersonModel implements Comparable<PersonModel> {
    private String name;
    private int age;

    public PersonModel() {}

    public PersonModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(PersonModel other) {
        return this.age - other.age;
    }
}
