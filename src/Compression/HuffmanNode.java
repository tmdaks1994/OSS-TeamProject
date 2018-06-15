package Test;

public class HuffmanNode {
    HuffmanNode left, right;
    double value;
    String character;

    public HuffmanNode(double value, String character) {
        this.value = value;
        this.character = character;
        left = null;
        right = null;
    }

    public HuffmanNode(HuffmanNode left, HuffmanNode right) {
        this.value = left.value + right.value;
        character = left.character + right.character;
        if (left.value > right.value) {
            this.right = right;
            this.left = left;
        } else {
            this.right = left;
            this.left = right;
        }
    }
}
