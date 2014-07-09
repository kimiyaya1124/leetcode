public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length<=1)
            return;
        int i,j;
        for(i = num.length-1;i>=1; i--){
            if(num[i-1]<num[i])
                break;
        }
        if(i==0){
            swap(num,0,num.length-1);
        }
        else{
            int key = num[i-1];
            for(j = num.length-1; j >= i;j--){
                if(num[j]>key)
                    break;
            }
            int tmp = num[j];
            num[j] = key;
            num[i-1] = tmp;
            swap(num,i,num.length-1);
        }
    }
    
    public void swap(int[] num, int start, int end){
        int l = start, r = end;
        while(l<r){
            int tmp = num[r];
            num[r] = num[l];
            num[l] = tmp;
            r--;
            l++;
        }
    }
}
