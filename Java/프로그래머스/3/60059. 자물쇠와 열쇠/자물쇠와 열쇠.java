import java.util.*;

class Solution {
    static int[][] keyCopy;
    static int keySize;
    static int[][] lockCopy;
    static int lockSize;

    public boolean solution(int[][] key, int[][] lock) {
        keyCopy = key;
        lockCopy = lock;
        keySize = key.length;
        lockSize = lock.length;

        int expandSize = lockSize + 2 * (keySize - 1);
        int[][] expandLock = new int[expandSize][expandSize];

        // 기존 자물쇠를 중앙에 배치
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                expandLock[i + keySize - 1][j + keySize - 1] = lock[i][j];
            }
        }

        // 4방향 회전하며 탐색
        int[][] rotatedKey = key;
        for (int rot = 0; rot < 4; rot++) {
            rotatedKey = turn(rotatedKey);
            if (match(rotatedKey, expandLock)) return true;
        }

        return false;
    }

    // 🔄 90도 회전하는 함수
    private static int[][] turn(int[][] org) {
        int[][] temp = new int[keySize][keySize];
        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                temp[i][j] = org[keySize - 1 - j][i];
            }
        }
        return temp;
    }

    // 🔑 key를 lock 위에서 움직이며 맞춰보는 함수
    private static boolean match(int[][] key, int[][] lock) {
        int expandSize = lock.length;

        // key를 움직이면서 lock과 맞춰보기
        for (int x = 0; x <= expandSize - keySize; x++) {
            for (int y = 0; y <= expandSize - keySize; y++) {
                if (isKey(x, y, key, lock)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 🔍 특정 위치에서 key가 lock과 맞는지 확인하는 함수
    private static boolean isKey(int x, int y, int[][] key, int[][] lock) {
        int[][] testLock = new int[lock.length][lock.length];

        // lock을 복사
        for (int i = 0; i < lock.length; i++) {
            testLock[i] = lock[i].clone();
        }

        // key를 testLock에 더하기
        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                testLock[x + i][y + j] += key[i][j];
            }
        }

        // 중앙 부분이 모두 1인지 확인 (자물쇠가 풀리는 조건)
        for (int i = keySize - 1; i < keySize - 1 + lockSize; i++) {
            for (int j = keySize - 1; j < keySize - 1 + lockSize; j++) {
                if (testLock[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
