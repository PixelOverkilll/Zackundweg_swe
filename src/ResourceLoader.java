// Benötigen externe Class (durch chatgpt generiert) damit Content in JAR geladen werden kann.

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ResourceLoader {
    // Loads an ImageIcon from resources inside the JAR
    public static ImageIcon loadIcon(String resourceName) {
        URL url = ResourceLoader.class.getResource("/" + resourceName);
        if (url != null) {
            return new ImageIcon(url);
        } else {
            System.err.println("Resource not found: " + resourceName);
            return null;
        }
    }

    // Loads an Image from resources inside the JAR
    public static Image loadImage(String resourceName) {
        URL url = ResourceLoader.class.getResource("/" + resourceName);
        if (url != null) {
            try {
                return ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Resource not found: " + resourceName);
        }
        return null;
    }
}
