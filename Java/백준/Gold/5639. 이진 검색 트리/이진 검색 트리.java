import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        binarySearchTree bst = new binarySearchTree();

        // 트리에 값 삽입 (입력 종료는 EOF 기준)
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            bst.insert(Integer.parseInt(input));
        }

        // 후위 순회 출력
        bst.postOrderTraversal();
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class binarySearchTree {
    private Node root;

    // 노드 삽입
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node current, int val) {
        if (current == null) {
            return new Node(val);
        }

        if (val < current.val) {
            current.left = insertRec(current.left, val);
        } else if (val > current.val) {
            current.right = insertRec(current.right, val);
        }

        return current;
    }

    // 후위 순회 (Post-order Traversal)
    public void postOrderTraversal() {
        postOrderRec(root);
        System.out.println(); // 마지막 줄 개행
    }

    private void postOrderRec(Node current) {
        if (current != null) {
            postOrderRec(current.left); // 왼쪽 서브트리 방문
            postOrderRec(current.right); // 오른쪽 서브트리 방문
            System.out.println(current.val); // 현재 노드 출력
        }
    }
}
