class Solution {
    public int solution(int chicken) {
        //service의 개수와 coupon의 개수를 따로 관리해야함.
        int coupon = chicken;
        int serviceTotal = 0;
        
        while(coupon >= 10){
            int newService = coupon / 10;
            coupon -= newService*10;
            coupon += newService;
            serviceTotal += newService;
        }
        int answer = serviceTotal;
        return answer;
    }
}