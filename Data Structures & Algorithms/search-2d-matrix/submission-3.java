class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++){
            if(target > matrix[i][n-1]){
                continue;
            }else{
                int l = 0;
                int j = n-1;

                while(l<=j){
                    int mid = l + (j-l)/2;
                    if(target == matrix[i][mid] || 
                        target == matrix[i][l] || 
                        target == matrix[i][j]){
                        return true;
                    }else if(target > matrix[i][mid]){
                        l = mid+1;
                    }
                    else{
                        j = mid-1;
                    }
                }
            }
        }

        return false;
    }
}
