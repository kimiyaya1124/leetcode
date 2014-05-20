public class Solution {
    public int maxArea(int[] height) {
        if((height.length==0) || (height.length==1)){
            return 0;
        }
        
        int head = 0, tail = height.length-1;
        int maxA = 0;
        int curA = 0;
        while(head < tail){
            curA = Math.min(height[tail],height[head])*(tail-head); 
            if(curA>maxA)
                maxA = curA;
            if(height[tail]>height[head])
                head++;
            else
                tail--;
        }
        return maxA;
    }
}
