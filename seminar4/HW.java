package seminar4;

public class HW {

    
    private Node root;

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == seminar4.HW.Node.Color.red &&
                    (result.leftChild == null || result.leftChild.color == seminar4.HW.Node.Color.black)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == seminar4.HW.Node.Color.red &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == seminar4.HW.Node.Color.red) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == seminar4.HW.Node.Color.red &&
                    result.rightChild != null && result.rightChild.color == seminar4.HW.Node.Color.red) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = seminar4.HW.Node.Color.black;
            return result;
        } else {
            root = new Node();
            root.color = seminar4.HW.Node.Color.black;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = seminar4.HW.Node.Color.red;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = seminar4.HW.Node.Color.red;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = seminar4.HW.Node.Color.red;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = seminar4.HW.Node.Color.red;
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.rightChild.color = seminar4.HW.Node.Color.black;
        node.leftChild.color = seminar4.HW.Node.Color.black;
        node.color = seminar4.HW.Node.Color.red;
    }


    public class Node {
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;

        private enum Color {
            red, black;
        }
    }

    
}


