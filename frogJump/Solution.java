package frogJump;

public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		int X = 105;
		int Y = 14;
		int D = 23;
		System.out.print(s.solution(X, Y, D));
	}
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        if(Y==X)
            return 0;
        return (Y-X)%D > 0 ? ((Y-X)/D)+1 : (Y-X)/D;
    }
}
