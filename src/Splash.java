import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    public class Splash extends JFrame {
        public Splash() {
            setTitle("Draw 4 Cards");
            setSize(1000, 800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Displayed messages
            JLabel sentence1Label = new JLabel("This program is designed to randomly select and display four cards from a standard deck of 52 cards.");
            JLabel sentence2Label = new JLabel("Each time you click the \"Draw Again\" button, a new set of four cards will be presented.");
            JLabel sentence3Label = new JLabel("You can repeat this process as many times as you like.");
            JLabel sentence4Label = new JLabel("When you're ready to exit the program, simply click the \"Quit Program\" button.");
            JLabel sentence5Label = new JLabel("Enjoy drawing!");

            // For font size and font style
            Font font = new Font("script", Font.PLAIN, 30);
            sentence1Label.setFont(font);
            sentence2Label.setFont(font);
            sentence3Label.setFont(font);
            sentence4Label.setFont(font);
            sentence5Label.setFont(font);

            // Creating the content panel and setting up its layout
            JPanel contentPane = new JPanel();
            contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
            setContentPane(contentPane);

            // Message labels
            contentPane.add(sentence1Label);
            contentPane.add(sentence2Label);
            contentPane.add(sentence3Label);
            contentPane.add(sentence4Label);
            contentPane.add(sentence5Label);

            // Creation of OK button
            JButton okButton = new JButton("OK");
            okButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Align button to center horizontally
            okButton.addActionListener(new ActionListener() {

                // This will cause the program to stop running when OK is clicked
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            // This is for the OK button
            contentPane.add(Box.createVerticalGlue()); // Add vertical glue for spacing
            contentPane.add(okButton);

            setVisible(true);
        }

    }

