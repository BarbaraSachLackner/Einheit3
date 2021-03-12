package org.lecture.singleton;

import lombok.Getter;
import lombok.ToString;

/**
 * Class representing an ingredient
 * Immutable class
 */

@Getter
@ToString
public class Ingredient {

    private final String name;
    private final int amount;

    public Ingredient(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

}
