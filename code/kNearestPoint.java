import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Math;

public static class Point{
    double x;
    double y;
    public Point(double a,double b)
    {
        x=a;
        y=b;
    }
}

public class kNearestPoint {
    public Point[] Solution (Point [] array,Point origin,int k )
    {
     Point [] result = new Point[k];
     int index=0;
     //getDistance(b, origin) - getDistance(a, origin) nearest
     //points, getDistance(a, origin) - getDistance(b, origin) oppoist
     PriorityQueue<Point> pq = new PriorityQueue <Point> (k,new Comparator<Point>(){
     @Override 
      public int compare (Point a, Point b)
      {
       return (int) (getDistance(b,origin)-getDistance(a,origin));
      } 
     });
     for (int i =0; i <array.length;i++)
     {
         pq.offer(array[i]);
         if (pq.size()>k)
            pq.poll();//above size just throw it nearest points will be in 
            //throw the fartest
     }
     while (!pq.isEmpty())
     {
         result[index++] = pq.poll();
     }
     return result;
    }
  private double getDistance (Point a, Point b)
  { 
return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
  }
}