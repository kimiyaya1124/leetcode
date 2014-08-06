public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height==null || height.length<=0)
            return 0;
        Stack<Integer> sta = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= height.length; i++){
            int curval = i==height.length?-1:height[i];
            while(!sta.isEmpty() && curval<=height[sta.peek()]){
                int h = height[sta.pop()];
                int w = sta.isEmpty()?i:i-sta.peek()-1;
                maxArea = Math.max(maxArea,h*w);
            }
            sta.push(i);
        }
        return maxArea;
    }
}
