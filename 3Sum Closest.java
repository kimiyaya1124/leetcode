public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num.length<3)
            return 0;
        
        Arrays.sort(num);
        int sum = num[0]+num[1]+num[2];
        int i;
        for(i = 0; i < num.length-2;i++){
            int l = i+1;
            int r = num.length-1;
            while(l<r){
                if(Math.abs(sum-target)>Math.abs(num[l]+num[i]+num[r]-target)){
                    sum = num[l]+num[i]+num[r];
                }
                if(sum==target)
                    return sum;
                if(num[l]+num[i]+num[r]>target)
                    r--;
                else
                    l++;
            }
        }
        return sum;
    }
}
