import java.util.Random;
import java.util.Scanner;

public class CardGame {
    private final CardStack playerDeck;
    private final CardStack discardedPile;
    private final CardStack playerHand;
    private final Random random;

    public CardGame() {
        playerDeck = new CardStack();
        discardedPile = new CardStack();
        playerHand = new CardStack();
        random = new Random();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] cardNames = {"Flame", "Blaze", "Burn", "Flare", "Combust"};
        for (int i = 0; i < 30; i++) {
            playerDeck.push(new Card(cardNames[random.nextInt(cardNames.length)]));
        }
    }

    private void drawCards(int commandCardCount) {
        for (int i = 0; i < commandCardCount; i++) {
            if (playerDeck.isEmpty()) {
                break;
            }
            playerHand.push(playerDeck.pop());
        }
    }

    private void discardCards(int commandCardCount) {
        for (int i = 0; i < commandCardCount; i++) {
            if (playerHand.isEmpty()) {
                break;
            }

            discardedPile.push(playerHand.pop());
        }
    }

    private void drawFromDiscardedPile(int commandCardCount) {
        for (int i = 0; i < commandCardCount; i++) {
            if (discardedPile.isEmpty()) {
                break;
            }
            playerHand.push(discardedPile.pop());
        }
    }

    private boolean emptyPileChecker(int cardPileCount) {
        return  (cardPileCount == 0);
    }

    private void displayStatus() {
        System.out.println("Player's hand:");
        playerHand.printStack();
        System.out.println("\nRemaining cards in deck: " + playerDeck.size());
        System.out.println("Cards in discarded pile: " + discardedPile.size());
        System.out.println("---------------------------------------------------");
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!playerDeck.isEmpty()) {
            int command = random.nextInt(3);
            int commandCardCount = random.nextInt(5) + 1;

            switch (command) {
                case 0:
                    System.out.println("Command: Draw " + commandCardCount + " cards");
                    drawCards(commandCardCount);
                    break;

                case 1:
                    if (emptyPileChecker(playerHand.size())) {
                        continue;
                    }

                    System.out.println("Command: Discard " + commandCardCount + " cards");
                    discardCards(commandCardCount);
                    break;

                case 2:
                    if (emptyPileChecker(discardedPile.size())) {
                        continue;
                    }

                    System.out.println("Command: Get " + commandCardCount + " cards from the discarded pile");
                    drawFromDiscardedPile(commandCardCount);
                    break;
            }

            displayStatus();
            System.out.println("Press Enter to continue to the next round...");
            scanner.nextLine();
        }

        System.out.println("The player deck is emptied. Game over!");
        scanner.close();
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.play();
    }
}
