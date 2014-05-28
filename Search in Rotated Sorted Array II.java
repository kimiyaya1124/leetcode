public class Solution {
    public boolean search(int[] A, int target) {
        if(A.length==0)
            return false;
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
        boolean res = false;
        if((target<A[head]) || (target>A[tail]))
            return res;
        int breakIndex = 0;
        int fh = 0, ft = 0,hlimit = 0, tlimit=0;
        while(true){
            hlimit = head<=tail?tail:A.length-1;
            tlimit = head<=tail?head:0;
            while(head < hlimit){
                if(A[head+1]==A[head])
                    head++;
                else
                    break;
            }
            while(tail > tlimit){
                if(A[tail-1]==A[tail])
                    tail--;
                else
                    break;
            }
            
            if(head<=tail){
                mid = (head+tail)/2;
                hlimit = tail;
                tlimit = head;
            }
            else{
                mid = ((head+tail+A.length)/2)%A.length;
                hlimit = A.length-1;
                tlimit = 0;
            }
            if(target==A[mid]){
                res = true;
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
