class Solution {
    int[] arr;
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=matrix.length-1; i>=0; i--){
            if(matrix[i][0] == target) return true;

            if(matrix[i][0] < target){
                arr = matrix[i];
                break;
            }
        }

        if (arr == null) return false;


        int l =0;
        int r =arr.length-1;
        int mid = 0;

        while(l<=r){
            mid = l + (r-l) / 2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                r = mid-1;
            }
            else if(arr[mid] < target){
                l = mid+1;
            }
        }

        return false;
        
    }
}
