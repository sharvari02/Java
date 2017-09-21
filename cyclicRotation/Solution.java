package cyclicRotation;

public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		int[] A = {};
		int[] B = s.solution(A, 5);
		for(int i=0;i<B.length;i++)
			System.out.print(B[i]+" ");
	}
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
           int[] B = new int[A.length];
           if(A.length<1)
               return B;
           if(K%A.length == 0)
               return A; //rotation will result in same array
           K = K % (A.length);
           for(int i = 0; i<A.length; i++)
               B[i] = (i<K) ? A[A.length+i-K] : A[i-K];

           return B;
       }
}