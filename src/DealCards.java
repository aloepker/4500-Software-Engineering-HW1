import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class DealCards extends JFrame {

    public static String[] selectRandomCards(String[] cardPaths, int numberOfCards) {
        // Make a copy of the cardPaths array to avoid modifying the original array
        String[] shuffledCards = Arrays.copyOf(cardPaths, cardPaths.length);

        // Shuffle the array
        Random rand = new Random();
        for (int i = shuffledCards.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap
            String temp = shuffledCards[i];
            shuffledCards[i] = shuffledCards[j];
            shuffledCards[j] = temp;
        }

        // Take the first 'numberOfCards' elements from the shuffled array
        return Arrays.copyOfRange(shuffledCards, 0, numberOfCards);
    }

    public static String shortName(String cardName) {
        // Split the card name using "_" and "/"
        String[] parts = cardName.split("[_/]");

        // Get the rank and suit from the split parts
        String rank = parts[1];
        String suit = parts[3].substring(0, 1).toLowerCase();
        return rank + suit;
    }


    private static JFrame previousFrame;
    public static void dealHand(String[] Cards) {
        if (previousFrame != null) {
            previousFrame.dispose();
        }

        JFrame frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);

        // Create four components with images
        Component card1 = createImage(Cards[0]);
        Component card2 = createImage(Cards[1]);
        Component card3 = createImage(Cards[2]);
        Component card4 = createImage(Cards[3]);

        // Create a JPanel to hold the components horizontally
        JPanel hand = new JPanel();
        hand.setLayout(new BoxLayout(hand, BoxLayout.X_AXIS));
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);

        // Add the panel to the JFrame
        frame.add(hand);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Set the JFrame to be visible
        frame.setVisible(true);
        previousFrame = frame;
    }

    private static Component createImage(String imagePath) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));

            // Define the desired width and height
            int desiredWidth = 100; // Adjust this value accordingly
            int desiredHeight = 150; // Adjust this value accordingly

            // Scale the image
            Image scaledImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            return new JLabel(icon, JLabel.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
            return new JLabel("Error loading image", JLabel.CENTER);
        }
    }

    public static void removeHand(int delay) {
        if (previousFrame != null) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            previousFrame.dispose();  // Dispose of the JFrame to remove it from the screen
        }
    }
}
