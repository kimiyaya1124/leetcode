/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.util.Hashtable;

public class Solution {
    public int maxPoints(Point[] points) {
        int i,j,samepointN,pmax,amax;
        double tmpslope;
        double EPSILON = 0.00001;
        Integer slopeN;
        Float slopeV;
        amax = 0;
        Hashtable<Float, Integer> slopes = new Hashtable<Float, Integer>();
        
        for(i = 0;i < points.length;i++){
            slopes.clear();
            samepointN = 0;
            pmax = 1;
            for(j = i+1;j<points.length;j++){
                if(points[i].x!=points[j].x){
                    float ty = points[j].y-points[i].y;
                    float tx = points[j].x-points[i].x;
                    tmpslope = ty/tx+EPSILON;
                    slopeV = new Float(tmpslope);
                }
                else{
                    if(points[i].y!=points[j].y){
                        slopeV = Float.POSITIVE_INFINITY;
                    }
                    else{
                        samepointN++;
                        continue;
                    }
                }
                slopeN = slopes.get(slopeV);
                
                if(slopeN==null){
                    slopes.put(slopeV,new Integer(2));
                }
                else{
                    slopeN = slopeN + 1;
                    slopes.put(slopeV,slopeN);
                }
                slopeN = slopes.get(slopeV);
                if(pmax < slopeN.intValue())
                    pmax = slopeN.intValue();
            }
            if(amax < pmax+samepointN)
                amax = pmax + samepointN;
        }
        return amax;
    }
}
