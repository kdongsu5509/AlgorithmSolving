import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        // 우선 14 * 14로 각 호수 별 인원 정하자.
        int[][] members = new int[15][15];

        // 0층 채우기
        for (int i = 1; i < 15; i++) {
            members[0][i] = i;
        }

        // i가 여기서는 층, j가 호수.
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                if (j == 1) {
                    members[i][j] = 1;
                    continue;
                }

                members[i][j] = members[i][j - 1] + members[i - 1][j];
            }
        }

        for (int x = 0; x < testCase; x++) {
            int floor = sc.nextInt();
            int roomNum = sc.nextInt();

            System.out.println(members[floor][roomNum]);
        }

    }
}