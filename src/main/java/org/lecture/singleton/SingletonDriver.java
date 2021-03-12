package org.lecture.singleton;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SingletonDriver {

    public static void main(String[] args) throws IOException, InterruptedException {
        Configuration config = Configuration.getInstance();

        do {
            switch (getOption()) {
                case 1 -> config.loadConfiguration();
                case 2 -> config.refreshConfiguration();
                case 3 -> passTime();
                case 4 -> printIngredients();
                default -> {
                    System.out.println("Exiting");
                    System.exit(0);
                }
            }
        } while (true);
    }

    /**
     * prints all configured ingredients to the console
     */
    private static void printIngredients() {
        var ingredients = Configuration.getInstance().getIngredients();
        for (var i : ingredients.entrySet()) {
            System.out.print(i.getKey());
            System.out.print(": ");
            System.out.print(i.getValue());
            System.out.println();
        }
    }

    /**
     * prints the available options to the console
     *
     * @return the chosen option
     */
    private static int getOption() {
        String options = """
                                
                1 - load configuration
                2 - refresh configuration
                3 - wait 5 seconds
                4 - print configuration
                all other values - Exit the programme          
                """;
        System.out.println(options);
        System.out.println("Choose an option: ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        //if not a number....
        if (!isValidInput(option)) {
            System.out.println("Not a valid input!");
            //... call getOption() again (recursive call!)
            return getOption();
        }

        //parses the valid number (int or double) into an int value
        Double parseDouble = Double.parseDouble(option);
        return parseDouble.intValue();


    }

    /**
     * Identifies if input is a number
     * @param toTest the input
     * @return true if the input is a valid number
     */
    private static boolean isValidInput(String toTest) {
        if (toTest == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(toTest).matches();
    }

    /**
     * Wait for 5 seconds
     * @throws InterruptedException
     */
    private static void passTime() throws InterruptedException {
        System.out.println("Waiting...");
        Thread.sleep(5000);
        System.out.println("5 seconds passed");

    }
}
