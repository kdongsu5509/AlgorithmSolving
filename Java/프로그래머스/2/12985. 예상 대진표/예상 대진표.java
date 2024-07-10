class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0; // 정답을 저장할 변수 answer

        while(true){
            a = newNum(a);
            b = newNum(b);
            answer++;
            if (a == b){
                break;
            }
        }

        return answer;
    }
    
    private int newNum(int x){
        if (x % 2 == 0) {
            return x / 2;
        }
        else{
            return(x+1)/2;
        }
    }
}