public class Tree {
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        root.insert(value);
    }

    public void traverseInOrder() {
        if (root == null) return;
        root.traverseInOrder();
    }

    public void traverseInOrderDescending() {
        if (root == null) return;
        root.traverseInOrderDescending();
    }

    public Node getMin() {
        return root == null ? null : root.getMin();
    }

    public Node getMax() {
        return root == null ? null : root.getMax();
    }

    public Node get(int value) {
        return root == null ? null : root.get(value);
    }
}
