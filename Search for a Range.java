public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0]=-1;
        res[1]=-1;
        if(A.length<=0){
            return res;
        }
        int head = 0;
        int tail = A.length-1,mid;
        while(head<=tail){
            if((A[head]==A[tail]) && (A[head]==target)){
                res[0]=head;
                res[1]=tail;
                break;
            }
            mid = (head+tail)/2;
            int curmid = mid;
            if(A[curmid]==target){
                while((A[mid]==target) && (mid!=head)){
                    mid=(mid+head)/2;
                }
                if(A[mid]!=target)
                    head=mid+1;
                mid=curmid;
                while((A[mid]==target)&&(mid!=tail-1))
                    mid=(mid+tail)/2;
                if(A[mid]!=target)
                    tail=mid-1;
                else
                    tail=A[tail]==target?tail:mid;
            }
            else if(target>A[curmid])
                head=curmid+1;
            else if(target<A[curmid])
                tail = curmid-1;
        }
        return res;
    }
}
