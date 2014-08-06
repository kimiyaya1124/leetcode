public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> outerArr = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length<=0)
            return outerArr;
        Arrays.sort(num);
        for(int i = 0; i < num.length-3;i++){
            if(i!=0 && num[i]==num[i-1])
                continue;
            for(int j = i+1;j < num.length-2;j++){
                if(j!=i+1 && num[j]==num[j-1])
                    continue;
                int left = j+1;
                int right = num.length-1;
                while(left<right){
                    int sum = num[i]+num[j]+num[left]+num[right];
                    if(sum==target){
                        ArrayList<Integer> innerArr = new ArrayList<Integer>();
                        innerArr.add(num[i]);
                        innerArr.add(num[j]);
                        innerArr.add(num[left]);
                        innerArr.add(num[right]);
                        outerArr.add(innerArr);
                        left++;
                        right--;
                        while(left<right && num[left]==num[left-1])
                            left++;
                        while(right>left && num[right]==num[right+1])
                            right--;
                    }
                    else if(sum<target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return outerArr;
    }
}
