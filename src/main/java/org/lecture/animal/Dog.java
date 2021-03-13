package org.lecture.animal;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 *  Creates an (immutable) Dog
 *
 */
@Getter
@ToString
public class Dog {

    @EqualsAndHashCode.Include
    private final String name;

    private final Breed breed;
    private final boolean barfed;
    private final int age;
    private final double height;
    private final double weight;
    private final String sound;
    private final String walk;
    private final List<String> owners = new ArrayList<>();

    /**
     *
     * Constructor taking all available parameters to create a valid dog
     *
     * @param name name
     * @param age age
     * @param height height in cm
     * @param weight weight in kg
     * @param breed the breed
     * @param barfed is fed with only meat
     * @param sound which sound this specific dog makes
     * @param walk how this specific dog walks
     * @param owners the list of current owners
     */
    public Dog(String name, int age, double height, double weight, Breed breed, boolean barfed, String sound, String walk, List<String> owners) {
        this.barfed = barfed;
        this.breed = breed;
        this.age = age;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.sound = sound;
        this.walk = walk;
        this.owners.addAll(owners);
    }
}
