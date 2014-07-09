public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> outerArr = new ArrayList<ArrayList<Integer>>();
        if(num.length<=0)
            return outerArr;
        Arrays.sort(num);
        nextpermutation(num,outerArr);
        return outerArr;
    }
    
    public void nextpermutation(int[] num, ArrayList<ArrayList<Integer>> outerArr){
        while(true){
            ArrayList<Integer> innerArr = new ArrayList<Integer>();
            for(int i =0; i < num.length;i++){
                innerArr.add(num[i]);
            }
            outerArr.add(innerArr);
        
            int k;
            for(k = num.length-2;k>=0;k--){
                if(num[k]<num[k+1])
                    break;
            }
            if(k < 0)
                break;
            int j;
            for(j = num.length-1;j>k;j--){
                if(num[j]>num[k])
                    break;
            }
            swap(num,k,j);
            reverse(num,k+1,num.length-1);
        }
    }
    
    public void swap(int[] num,int start, int end){
        int tmp = num[end];
        num[end] = num[start];
        num[start] = tmp;
    }
    
    public void reverse(int[] num, int start, int end){
        int l = start, r = end;
        while(l <= r){
            int tmp = num[r];
            num[r] = num[l];
            num[l] = tmp;
            r--;
            l++;
        }
    }
}
