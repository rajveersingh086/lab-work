package adv_DS;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class binarytree {
    Node root;

    public binarytree() {
        root = null;
    }

    public void insert(int data) {
        root = insertrec(root, data);
    }

    private Node insertrec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertrec(root.left, data);
        } else if (data > root.data) {
            root.right = insertrec(root.right, data);
        }
        return root;
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        binarytree tree = new binarytree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order Traversal of the Tree:");
        tree.inorderTraversal(tree.root);
    }
}
