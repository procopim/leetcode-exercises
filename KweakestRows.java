class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int[] prepro = new int[mat.length];
        int counter = mat.length - 1;
        int idx = 0;
        while (counter >= 0){
            int countRowOnes = 0;
            for (int i = 0; i < mat[idx].length; i++){
                if (mat[idx][i] == 1){
                    countRowOnes ++;
                }
                else {
                    break;
                }
            }
            prepro[idx] = countRowOnes;
            idx++;
            counter --;
        }
        int[] result = new int[k];
        
        int ppcounter = prepro.length -1;

        int resCounter = 0;

        while (ppcounter >= 0){
            int smallestIdx = 999;
            for (int ppidx = 0; ppidx < prepro.length; ppidx ++){
                if (smallestIdx == 999 && prepro[ppidx] >= 0){
                    smallestIdx = ppidx;
                }
                else {
                    if (prepro[ppidx] >= 0 && prepro[ppidx] < prepro[smallestIdx]){
                        smallestIdx = ppidx;
                    }
                }
            }
            prepro[smallestIdx] = -1;
            if (resCounter < k){
                result[resCounter] = smallestIdx;
            }
            resCounter++;
            ppcounter--;
        }
        return result;           
    }
}
//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix