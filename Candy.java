public class Solution {
    public int candy(int[] ratings) {
        int totalNum = 0;
        if(ratings == null || ratings. length <= 0)
            return totalNum;
        totalNum += ratings.length;
        int[] candyNum = new int[ratings.length];
        for(int i = 0; i < ratings.length;i++){
            candyNum[i] = 1;
        }
        for(int i = 0; i < ratings.length-1;i++){
            if(ratings[i+1] > ratings[i]){
                candyNum[i+1] = candyNum[i]+1;
                totalNum += candyNum[i+1]-1;
            }
        }
        for(int i = ratings.length-1; i > 0; i--){
            if(ratings[i-1]>ratings[i] && candyNum[i-1]<=candyNum[i]){
                totalNum -= candyNum[i-1];
                candyNum[i-1] = candyNum[i]+1;
                totalNum += candyNum[i-1];
            }
        }
        return totalNum;
    }
}
