from collections import deque

# BFS 함수 정의
def BFS(x, y):
    queue = deque([(x, y)])

    while queue:
        cx, cy = queue.popleft()

        for k in range(4):
            nx, ny = cx + dx[k], cy + dy[k]

            if 0 <= nx < M and 0 <= ny < N and field[ny][nx] == 1:
                field[ny][nx] = 0  # 방문한 배추는 0으로 표시
                queue.append((nx, ny))

# 테스트 케이스 개수 입력
test_case_num = int(input())

# 상하좌우 이동을 위한 dx, dy 정의
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(test_case_num):
    # 배추밭의 가로, 세로, 배추의 개수 입력
    M, N, K = map(int, input().split())

    # 배추밭 초기화
    field = [[0] * M for _ in range(N)]

    # 배추 위치 입력
    for _ in range(K):
        X, Y = map(int, input().split())
        field[Y][X] = 1

    # 배추 흰지렁이의 개수 초기화
    worm_count = 0

    # 배추밭을 순회하며 BFS 수행
    for i in range(N):
        for j in range(M):
            if field[i][j] == 1:
                BFS(j, i)
                worm_count += 1

    print(worm_count)
