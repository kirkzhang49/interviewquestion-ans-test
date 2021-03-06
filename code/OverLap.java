public class OverLap {
   //rectangle A,B
   //time O(1), space O(1)
public static boolean check (Node topLeftA,Node topLeftB,Node bottomRightA,Node bottomRightB)
{
  if(bottomRightA.y<topLeftB.y || bottomRightB.y<=topLeftA.y)
  {
      return false;//if bottomright.y less than topleft for 
      //sure not overlab
  }
  if (topLeftA.x>=bottomRightB.x || topLeftB.x>=bottomRightA.x)
  {
      return false;//if topleft.x greater than bottomright.x 
      //return false;
  }
  return true;
}
   public static class Node 
   {
       double x;
       double y;
       public Node (double x,double y)
       {
           this.x=x;
           this.y=y;
       }
   }
}