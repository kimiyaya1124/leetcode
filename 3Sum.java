public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length<3)
            return res;
        Arrays.sort(num);
        for(int i = 0; i < num.length-2; i++){
            if(i!=0 && num[i]==num[i-1])
                continue;
            int left = i+1;
            int right = num.length-1;
            while(left<right){
                int sum = num[i]+num[left]+num[right];
                if(sum==0){
                    ArrayList<Integer> innerres = new ArrayList<Integer>();
                    innerres.add(num[i]);
                    innerres.add(num[left]);
                    innerres.add(num[right]);
                    res.add(innerres);
                    left++;
                    right--;
                    while(left<right && num[left-1]==num[left])
                        left++;
                    while(left<right && num[right+1]==num[right])
                        right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return res;
    }
}
