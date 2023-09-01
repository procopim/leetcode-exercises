class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 1){
            return nums;
        }
        int[] answer = new int[nums.length];
        
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        L[0] = 1;
        for (int l = 1; l < L.length; l++){
            L[l] = L[l-1] * nums[l-1];
        }

        R[nums.length -1] = 1;
        for (int r = R.length -2; r >= 0; r--){
            R[r] = R[r+1] * nums[r+1];
        }

        for (int i = 0; i < nums.length; i++){
            answer[i] = L[i]*R[i];
        }
        return answer;         
    }
}
//https://leetcode.com/problems/product-of-array-except-self/