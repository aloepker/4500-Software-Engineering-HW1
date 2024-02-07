public class Main {

    public static void main(String[] args) {

        //Splash Message:
        new Splash();

        //Create Deck Array from Local Folder "Cards":
        String[] cardPaths = {
                "cards/2_of_clubs.png",
                "cards/2_of_diamonds.png",
                "cards/2_of_hearts.png",
                "cards/2_of_spades.png",
                "cards/3_of_clubs.png",
                "cards/3_of_diamonds.png",
                "cards/3_of_hearts.png",
                "cards/3_of_spades.png",
                "cards/4_of_clubs.png",
                "cards/4_of_diamonds.png",
                "cards/4_of_hearts.png",
                "cards/4_of_spades.png",
                "cards/5_of_clubs.png",
                "cards/5_of_diamonds.png",
                "cards/5_of_hearts.png",
                "cards/5_of_spades.png",
                "cards/6_of_clubs.png",
                "cards/6_of_diamonds.png",
                "cards/6_of_hearts.png",
                "cards/6_of_spades.png",
                "cards/7_of_clubs.png",
                "cards/7_of_diamonds.png",
                "cards/7_of_hearts.png",
                "cards/7_of_spades.png",
                "cards/8_of_clubs.png",
                "cards/8_of_diamonds.png",
                "cards/8_of_hearts.png",
                "cards/8_of_spades.png",
                "cards/9_of_clubs.png",
                "cards/9_of_diamonds.png",
                "cards/9_of_hearts.png",
                "cards/9_of_spades.png",
                "cards/10_of_clubs.png",
                "cards/10_of_diamonds.png",
                "cards/10_of_hearts.png",
                "cards/10_of_spades.png",
                "cards/11_of_clubs.png",
                "cards/11_of_diamonds.png",
                "cards/11_of_hearts.png",
                "cards/11_of_spades.png",
                "cards/12_of_clubs.png",
                "cards/12_of_diamonds.png",
                "cards/12_of_hearts.png",
                "cards/12_of_spades.png",
                "cards/13_of_clubs.png",
                "cards/13_of_diamonds.png",
                "cards/13_of_hearts.png",
                "cards/13_of_spades.png",
                "cards/14_of_clubs.png",
                "cards/14_of_diamonds.png",
                "cards/14_of_hearts.png",
                "cards/14_of_spades.png"
        };

        //Open the tile to write to:
        File.openFile();

        //Wait for a moment:
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int response;

        //Main program loop:
        do {
            response = StartingChoice.userStart();


            if (response == 1) {
                //Select a hand:
                String[] chosenHand = DealCards.selectRandomCards(cardPaths,4);

                //Show hand to user:
                DealCards.dealHand(chosenHand);

                //write the selected hand to the file:
                File.writeToFile(DealCards.shortName(chosenHand[0]) + ","
                        + DealCards.shortName(chosenHand[1]) + ","
                        + DealCards.shortName(chosenHand[2]) + ","
                        + DealCards.shortName(chosenHand[3])
                );

                //Pause to show the cards before asking again:
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }while(response != 0);

        //Close the file:
        File.closeFile();

        //Closing Splash Screen:
        ClosingSplash.ClosingSplash();

        //Pause to display Closing splash screen before application termination:
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Kill program:
        System.exit(0);
    }
}