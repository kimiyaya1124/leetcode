public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        
        int index = binarySearch(matrix,target);
        if(index < 0)
            return false;
        if(matrix[index][0]==target)
            return true;
        else{
            int index2 = binarySearch2(matrix[index],target);
            if(index2 < 0)
                return false;
            if(matrix[index][index2]==target)
                return true;
            else
                return false;
        }
    }
    
    public int binarySearch(int[][] arr, int target){
        int h = 0, t = arr.length-1;
        while(h <= t){
            if(target>arr[(h+t)/2][0])
                h = (h+t)/2+1;
            else if(target < arr[(h+t)/2][0])
                t = (h+t)/2-1;
            else{
                return (h+t)/2;
            }
        }
        return h-1;
    }
    
    public int binarySearch2(int[] arr, int target){
        int h = 0, t = arr.length-1;
        while(h <= t){
            if(target>arr[(h+t)/2])
                h = (h+t)/2+1;
            else if(target < arr[(h+t)/2])
                t = (h+t)/2-1;
            else{
                return (h+t)/2;
            }
        }
        return h-1;
    }
}
