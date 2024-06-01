#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>

/*
* 백준 1260번 문제 풀이 코드
* 
* BFS, DFS를 이용하여 그래프를 탐색하는 문제
* 입력 -> 인접 리스트
*/

//그래프 정의
typedef struct GraphType {
    int nodeNum;
    int** adj_mat;
} GraphType;

typedef GraphType* Graph;

//그래프 초기화
void initGraph(Graph graph, int nodeNum);

//그래프 출력 -> 확인용
void printGraph(Graph graph) {
    int size = graph->nodeNum;

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            printf("%5d", graph->adj_mat[i][j]);
        }
        printf("\n");
    }
}

//그 뭐냐, graph 삽입
void insertEdge(Graph graph, int a, int b) {
    graph->adj_mat[a][b] = 1;
    graph->adj_mat[b][a] = 1;
}

//Queue 정의
typedef int element;
typedef struct {
    element *queue;
    int front, rear;
} QueueType;

void initQueue(QueueType* queue, int size) {
    queue->queue = (element*)malloc(sizeof(element) * size);
    queue->front = 0;
    queue->rear = 0;
}

void insert_queue(QueueType* queue, element item) {
    queue->queue[queue->rear++] = item;
}

element pop_queue(QueueType* queue) {
    return queue->queue[queue->front++];
}

int is_empty(QueueType* queue) {
    return queue->front == queue->rear;
}

//DFS
void dfs(Graph graph, int start, int* visited) {
    visited[start] = 1;
    printf("%d ", start + 1);

    for (int i = 0; i < graph->nodeNum; i++) {
        if (graph->adj_mat[start][i] == 1 && !visited[i]) {
            dfs(graph, i, visited);
        }
    }
}

//BFS
void bfs(Graph graph, int start, int* visited) {
    QueueType queue;
    initQueue(&queue, graph->nodeNum);
    
    visited[start] = 1;
    insert_queue(&queue, start);

    while (!is_empty(&queue)) {
        int v = pop_queue(&queue);
        printf("%d ", v + 1);

        for (int i = 0; i < graph->nodeNum; i++) {
            if (graph->adj_mat[v][i] == 1 && !visited[i]) {
                visited[i] = 1;
                insert_queue(&queue, i);
            }
        }
    }
}

//전역 변수
//1. 그래프
QueueType QUEUE;
Graph graph;
int* dfsVisited;
int* bfsVisited;

//2. DFS 방문 여부

//3. BFS 방문 여부

int main() {
    int nodeNum, edgeNum, startNode;
    scanf("%d %d %d", &nodeNum, &edgeNum, &startNode);

    //그래프 동적 할당
    graph = (Graph)malloc(sizeof(GraphType));
    graph->adj_mat = (int**)malloc(sizeof(int*) * nodeNum);
    for (int i = 0; i < nodeNum; i++) {
        graph->adj_mat[i] = (int*)malloc(sizeof(int) * nodeNum);
    }

    initGraph(graph, nodeNum);

    for (int j = 0; j < edgeNum; j++) {
        int a, b;
        scanf("%d %d", &a, &b);
        insertEdge(graph, a - 1, b - 1);
    }

    // 그래프 출력 (확인용)
    // printGraph(graph);

    //DFS
    dfsVisited = (int*)malloc(sizeof(int) * nodeNum);
    for (int i = 0; i < nodeNum; i++) {
        dfsVisited[i] = 0;
    }
    dfs(graph, startNode - 1, dfsVisited);
    printf("\n");

    //BFS
    bfsVisited = (int*)malloc(sizeof(int) * nodeNum);
    for (int i = 0; i < nodeNum; i++) {
        bfsVisited[i] = 0;
    }
    bfs(graph, startNode - 1, bfsVisited);
    printf("\n");

    // 메모리 해제
    for (int i = 0; i < nodeNum; i++) {
        free(graph->adj_mat[i]);
    }
    free(graph->adj_mat);
    free(graph);
    free(dfsVisited);
    free(bfsVisited);

    return 0;
}

void initGraph(Graph graph, int nodeNum) {
    graph->nodeNum = nodeNum;
    for (int i = 0; i < nodeNum; i++) {
        for (int j = 0; j < nodeNum; j++) {
            graph->adj_mat[i][j] = 0;
        }
    }
}
