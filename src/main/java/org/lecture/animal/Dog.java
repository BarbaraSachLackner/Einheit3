package org.lecture.animal;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a Dog. Equal, if name and breed are equal
 */
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)  //otherwise all fields get included
public class Dog {

    @EqualsAndHashCode.Include
    private final String name;
    @EqualsAndHashCode.Include
    private final Breed breed;

    private final boolean barfed;
    private final int age;
    private final double height;
    private final double weight;
    private final String sound;
    private final String walk;
    private final List<String> owners;

    /**
     *
     * Constructor taking all available parameters to create a valid dog
     * Private, because only the Builder must be used.
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
    private Dog(String name, int age, double height, double weight, Breed breed, boolean barfed, String sound, String walk, List<String> owners) {
        this.barfed = barfed;
        this.breed = breed;
        this.age = age;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.sound = sound;
        this.walk = walk;
        this.owners = owners;
    }

    /**
     * Class to build a Dog
     */
    public static class DogBuilder {

        private String name;
        private Breed breed;
        private boolean barfed;
        private int age;
        private double height;
        private double weight;
        private String sound;
        private String walk;

        private List<String> owners = new ArrayList<>();

        public DogBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DogBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public DogBuilder withBarfed(boolean barfed) {
            this.barfed = barfed;
            return this;
        }

        public DogBuilder withHeight(double height) {
            this.height = height;
            return this;
        }

        public DogBuilder wtihHeight(double height) {
            this.height = height;
            return this;
        }

        public DogBuilder withOwner(List<String> owners) {
            this.owners = owners;
            this.owners.addAll(owners);
            return this;
        }

        public DogBuilder withSound(String sound) {
            this.sound = sound;
            return this;
        }

        public DogBuilder withWalk(String walk) {
            this.walk = walk;
            return this;
        }

        public DogBuilder withWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public DogBuilder withBreed(Breed breed) {
            this.breed = breed;
            return this;
        }


        /**
         * Builds a Dog with all its value. For some values, defaults are set.
         * The DogBuilder has to return itself to be able to continue adding the values to be able to create the dog.
         * Breed stays not set if not given, as there can't be any sensible default value
         *
         * @return a Dog
         */
        public Dog build() {

            //set default values
            if (sound == null) {
                this.sound = "Ruff Ruff";
            }
            if (walk == null) {
                this.walk = "trots";
            }
            if (name == null) {
                name = "Nameless Dog";
            }
            if (sound == null) {
                this.sound = "Ruff Ruff";
            }
            if (walk == null) {
                walk = "runs";
            }
            if (this.owners == null) {
                owners = new ArrayList<>();

            }
            return new Dog
                    (name, age, height, weight, breed, barfed,
                            sound, walk, owners);
        }

    }


}
