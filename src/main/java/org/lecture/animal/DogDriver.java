package org.lecture.animal;

public class DogDriver {

    public static void main(String[] args) {
        /*Dog d = new Dog
                ("Rocky", 2, 1.5, 39, Breed.GERMAN_SHEPHERD_DOG, true,
                        "Ruff Ruff", "runs", Collections.emptyList());
        */

        //create e new Dog (=new Dog) and access its static inner class, the DogBuilder.
        Dog dogWithBuilder = new Dog.DogBuilder()
                .withName("Rocky")
                .withAge(2)
                .withBreed(Breed.AMSTAFF)
                .build();

        System.out.println(dogWithBuilder);
    }



}
