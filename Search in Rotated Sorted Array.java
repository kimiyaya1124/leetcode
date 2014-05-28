public class Solution {
    public int search(int[] A, int target) {
        if(A.length==0)
            return -1;
        int i=0,j=0,head=-1,tail=0,mid=0,h = 0;
        for(i = 0; i < A.length-1;i++){
            if(A[i+1]<A[i]){
                head = i+1;
                tail = i;
                break;
            }
        }
        if(head==-1){
            head = 0;
            tail = A.length-1;
        }
        h = head;
        if((target<A[head]) || (target>A[tail]))
            return -1;
        int res = -1;
        int breakIndex = 0;
        int fh = 0, ft = 0;
        while(true){
            if(head<=tail)
                mid = (head+tail)/2;
            else
                mid = ((head+tail+A.length)/2)%A.length;
            if(target==A[mid]){
                res = mid;
                break;
            }
            else if(target>A[mid]){
                head = mid+1;
                if(head >= A.length)
                    head = head - A.length;
            }
            else{
                tail = mid-1;
                if(tail < 0){
                    tail = tail + A.length;
                }
            }
            fh = head<h?head+A.length:head;
            ft = tail<h?tail+A.length:tail;
            if(fh > ft)
                break;
        }
        return res;
    }
}
