import javax.swing.JOptionPane;
public class StartingChoice {
    public static int userStart() {
        int user_Choice = 2;
        // Setting this to a ramdon value to set off loop

            showMessageBox("Please type 1 to deal 4 cards or 0 to quit");
            String input = JOptionPane.showInputDialog("What would you like to do?: ");
            try {
                user_Choice = Integer.parseInt(input);

                switch (user_Choice) {
                    case 1:
                        showMessageBox("Dealing 4 cards...");

                        break;
                    case 0:
                        showMessageBox("Quitting the card game. Goodbye!");
                        break;
                    default:
                        showMessageBox("Invalid input. Please enter either 1 to deal 4 cards or 0 to quit.");
                }
            } catch (NumberFormatException e) {
                showMessageBox("Invalid input. Please enter a valid number.");
            }

        return user_Choice;
    }

    private static void showMessageBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
