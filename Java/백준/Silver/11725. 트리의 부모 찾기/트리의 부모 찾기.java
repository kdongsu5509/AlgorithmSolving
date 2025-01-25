import java.io.*;
import java.util.*;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static int[] parent; // 부모 노드 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 개수

        // 트리를 위한 인접 리스트
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 부모 노드 저장 배열 초기화
        parent = new int[n + 1];

        // 루트 노드부터 중위 순회 시작 (1번이 루트라고 가정)
        boolean[] visited = new boolean[n + 1];
        Node root = new Node(1);
        buildTree(root, graph, visited);

        // 중위 순회를 수행하면서 부모를 출력
        StringBuilder sb = new StringBuilder();
        inOrder(root);
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    // 트리 구성 (이진 트리 형태)
    private static void buildTree(Node current, List<List<Integer>> graph, boolean[] visited) {
        visited[current.value] = true;

        int childCount = 0; // 좌측, 우측 구분을 위해 자식 순서 추적
        for (int neighbor : graph.get(current.value)) {
            if (!visited[neighbor]) {
                Node child = new Node(neighbor);
                parent[neighbor] = current.value; // 부모 설정
                if (childCount == 0) {
                    current.left = child; // 첫 번째 자식을 왼쪽으로
                } else {
                    current.right = child; // 두 번째 자식을 오른쪽으로
                }
                childCount++;
                buildTree(child, graph, visited); // 재귀적으로 트리 구성
            }
        }
    }

    // 중위 순회
    private static void inOrder(Node current) {
        if (current == null) return;

        inOrder(current.left); // 왼쪽 자식
        // 중위 순회 시 아무 작업이 필요하지 않음 (부모 정보는 이미 설정됨)
        inOrder(current.right); // 오른쪽 자식
    }
}
