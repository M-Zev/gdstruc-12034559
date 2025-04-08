public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(25);
        tree.insert(17);
        tree.insert(29);
        tree.insert(10);
        tree.insert(16);
        tree.insert(-5);
        tree.insert(60);
        tree.insert(55);

        System.out.println("Ascending:");
        tree.traverseInOrder();

        System.out.println("\nDescending:");
        tree.traverseInOrderDescending();

        System.out.println("\nMinimum Value: " + tree.getMin().getData());
        System.out.println("Maximum Value: " + tree.getMax().getData());
    }
}
