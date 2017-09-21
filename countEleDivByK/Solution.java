package countEleDivByK;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.solution(5, 10, 2));
	}
	public int solution(int A, int B, int K) {
        // write your code in Java SE 8
		int i =0;
        i = (B/K - A/K);
        if(A%K == 0)
            i++;
        return i;
    }

}
