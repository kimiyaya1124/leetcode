public class Solution {
    public double pow(double x, int n) {
        if(n==0)
            return 1;
        if(n == 1)
            return x;
        double tmpow = pow(x,Math.abs(n)/2);
        if(n > 0){
            if(n%2==1)
                return tmpow*tmpow*x;
            else
                return tmpow*tmpow;
        }
        else{
            if(Math.abs(n)%2==1)
                return 1/(tmpow*tmpow*x);
            else
                return 1/(tmpow*tmpow);
        }
    }
}
