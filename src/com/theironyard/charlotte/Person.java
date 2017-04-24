package com.theironyard.charlotte;

/**
 * Created by Ben on 4/13/17.
 */
public class Person implements Comparable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;

        return name.compareTo(p.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
