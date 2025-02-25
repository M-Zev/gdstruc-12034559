package midterms;

import java.util.Random;
import java.util.Scanner;

public class CardGame {
    private CardStack playerDeck;
    private CardStack discardedPile;
    private CardStack playerHand;
    private Random random;

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

    private void drawCards(int drawCardsCount) {
        for (int i = 0; i < drawCardsCount; i++) {
            if (playerDeck.isEmpty()) {
                break;
            }
            playerHand.push(playerDeck.pop());
        }
    }

    private void discardCards(int discardCardsCount) {
        for (int i = 0; i < discardCardsCount; i++) {
            if (playerHand.isEmpty()) {
                break;
            }
            discardedPile.push(playerHand.pop());
        }
    }

    private void getCardsFromDiscardedPile(int drawDiscardCardsCount) {
        for (int i = 0; i < drawDiscardCardsCount; i++) {
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
            int x = random.nextInt(5) + 1;

            switch (command) {
                case 0:
                    System.out.println("Command: Draw " + x + " cards");
                    drawCards(x);
                    break;

                case 1:
                    if (emptyPileChecker(playerHand.size())) {
                        continue;
                    }

                    System.out.println("Command: Discard " + x + " cards");
                    discardCards(x);
                    break;

                case 2:
                    if (emptyPileChecker(discardedPile.size())) {
                        continue;
                    }

                    System.out.println("Command: Get " + x + " cards from the discarded pile");
                    getCardsFromDiscardedPile(x);
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
