package posts.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Factory zum Erstellen von Controllern basierend auf einer Konfigurationsdatei.
 */
public class ControllerFactory {

    /**
     * Lädt Controller-Klassen basierend auf einer Datei.
     * @param filePath Pfad zur Datei mit den Controllernamen.
     * @return Eine Liste von Controller-Instanzen.
     */
    public static List<ControllerInterface> loadControllers(String filePath) {
        List<ControllerInterface> controllers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String className;
            while ((className = br.readLine()) != null) {
                className = className.trim();
                if (!className.isEmpty()) {
                    ControllerInterface controller = createController(className);
                    if (controller != null) {
                        controllers.add(controller);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return controllers;
    }

    /**
     * Erstellt eine Controller-Instanz anhand des Klassennamens.
     * @param name Der Name der Controller-Klasse.
     * @return Eine Instanz des Controllers oder null, falls ein Fehler auftritt.
     */
    private static ControllerInterface createController(String name) {
        try {
            Class<?> controllerClass = Class.forName(name);
            Constructor<?> constructor = controllerClass.getDeclaredConstructor();
            Object controllerInstance = constructor.newInstance();

            if (controllerInstance instanceof ControllerInterface) {
                return (ControllerInterface) controllerInstance;
            } else {
                System.err.println("❌ Fehler: " + name + " implementiert ControllerInterface nicht.");
            }
        } catch (Exception e) {
            System.err.println("❌ Fehler beim Laden von: " + name);
        }
        return null;
    }
}