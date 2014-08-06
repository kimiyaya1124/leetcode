public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length<=2)
            return null;
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length;i++){
            map.put(numbers[i],i+1);
        }
        
        for(int i = 0; i < numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                int left = i+1;
                int right = map.get(target-numbers[i]);
                if(left==right)
                    continue;
                else{
                    res[0] = left;
                    res[1] = right;
                    return res;
                }
            }
        }
        return res;
    }
}
