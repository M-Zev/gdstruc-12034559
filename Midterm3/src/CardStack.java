package midterms;

import java.util.LinkedList;

public class CardStack {
    private LinkedList<Card> stack;

    public CardStack() {
        stack = new LinkedList<>();
    }

    public void push(Card card) {
        stack.addFirst(card);
    }

    public Card pop() {
        return stack.isEmpty() ? null : stack.removeFirst();
    }

    public Card peek() {
        return stack.isEmpty() ? null : stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void printStack() {
        for (Card card : stack) {
            System.out.println(card);
        }
    }
}
