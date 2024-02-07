public class Main {
    public static void main(String[] args) {
        new Splash();
        File.openFile();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int response;


        do {
            response = StartingChoice.userStart();

            String usersHand = "user's hand";
            File.writeToFile(usersHand);
            File.writeToFile(Integer.toString(response));

        }while(response != 0);

        File.closeFile();
        ClosingSplash.ClosingSplash();

    }
}