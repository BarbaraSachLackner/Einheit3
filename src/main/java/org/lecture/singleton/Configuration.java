package org.lecture.singleton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Map;
import java.util.TreeMap;

/**
 * Singleton to represent loading and refreshing a cache of ingredients
 */
public class Configuration {

    private static Configuration instance;
    private Map<String, Ingredient> config;
    private LocalTime nextRefresh = LocalTime.now();
    private final Path p = Paths.get("src/main/resources/config.txt");

    private Configuration() {
        //nothing to do here
    }

    /**
     * Returns the instance of the class
     * @return instance
     */
    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();  //calling private constructor
        }
        return instance;
    }

    /**
     * Loads configuration from a a fixed path (src/main/resources/config.txt) and creates the cashe
     *
     * @throws IOException
     */
    public void loadConfiguration() throws IOException {
        if (Files.exists(p)) {
            config = new TreeMap<>();
            var allLines = Files.readAllLines(p);
            for (String line : allLines) {
                var key = line.split("#");
                var configuration = line.substring(line.indexOf("#") + 1);
                var ingredient = configuration.split(",");
                Ingredient ingredientObject = new Ingredient(ingredient[0], Integer.parseInt(ingredient[1]));
                config.put(key[0], ingredientObject);
            }
            System.out.println("Configuration loaded");
        } else {
            System.out.println("no config file present");
        }
    }

    /**
     * Refreshes the configuration. It only refreshes after 10 seconds between two calls.
     * @throws IOException
     */
    public void refreshConfiguration() throws IOException {
        //check if enough time has passed since the last successful refresh
        if (nextRefresh.isAfter(LocalTime.now())) {
            loadConfiguration();
            if (!config.isEmpty()) {
                System.out.println("Configuration refreshed");
            }
        } else {
            System.out.println("Configuration not refreshed, try again later");
        }

        //set next earliest refresh time
        nextRefresh = LocalTime.now().plusSeconds(10);
    }

    /**
     * @return all configured ingredients
     */
    public Map<String, Ingredient> getIngredients() {
        return config;
    }


}
