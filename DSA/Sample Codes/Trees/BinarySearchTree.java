/**
 * @author chamodshehanka on 10/21/2019
 * @project Demo
 **/
class Node {
    public int iData; // data item AKA key
    public double dData; // other data
    public Node leftChild; // node's left child
    public Node rightChild; // node's right child

    public void displayNode() {
        System.out.print("{");
        System.out.print(iData);
        System.out.print(",");
        System.out.print(dData);
        System.out.print("}");
    }
}

public class BinaryTree {

    private Node root; // first root of tree

    public BinaryTree() {
        root = null;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;

        if (root == null){
            root = newNode;
        }else {
            Node current = root;
            Node parent;

            while (true){
                parent = current;
                if (id < current.iData){ // go left
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int id) {
        return false;
    }

    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.leftChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null){
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }

    private void preOrder(Node localRoot){
        if (localRoot != null){
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot){
        if (localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            localRoot.displayNode();
        }
    }

}
