using System;
using System.Collections;

public class Solution {
    public int solution(int[] array) {
        int middleIdx = array.Length / 2;
        Array.Sort(array);
        return array[middleIdx];
    }
}