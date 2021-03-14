package org.lecture.animal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DogTest {

    @Test
    public void buildDefaultValues() {
        Dog actual = new Dog.DogBuilder()
                .withAge(2)
                .build();

        //asserting default values
        assertEquals("Nameless Dog", actual.getName());
        assertEquals(Collections.EMPTY_LIST, actual.getOwners());
        assertEquals("Ruff Ruff", actual.getSound());
        assertEquals("trots", actual.getWalk());
        assertNull(actual.getBreed());
        assertEquals(0.0, actual.getWeight());
        assertEquals(0.0, actual.getHeight());
        assertFalse(actual.isBarfed());
    }

    @Test
    public void buildSetExplicitValues() {
        List<String> owner = new ArrayList<>();
        owner.add("Michael");

        Dog actual = new Dog.DogBuilder()
                .withAge(2)
                .withBreed(Breed.AMSTAFF)
                .withHeight(1.50)
                .withName("Rocky")
                .withSound("howls")
                .withWalk("runs")
                .withBarfed(true)
                .withOwner(owner)
                .withBarfed(true)
                .withWeight(20.73)
                .build();

        //asserting set values
        assertEquals("Rocky", actual.getName());
        assertEquals(owner, actual.getOwners());
        assertEquals("howls", actual.getSound());
        assertEquals("runs", actual.getWalk());
        assertEquals(Breed.AMSTAFF, actual.getBreed());
        assertEquals(20.73, actual.getWeight());
        assertEquals(1.50, actual.getHeight());
        assertEquals(2, actual.getAge());
        assertTrue(actual.isBarfed());
    }

    @Test
    public void dogEquality(){
        Dog actual = new Dog.DogBuilder()
                .withName("Rocky")
                .withAge(2)
                .withBreed(Breed.AMSTAFF)
                .build();

        Dog expected = new Dog.DogBuilder()
                .withName("Rocky")
                .withAge(5)
                .withBreed(Breed.AMSTAFF)
                .build();

        assertEquals(expected, actual);

    }



}