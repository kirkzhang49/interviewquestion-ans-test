public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int left = max(A,E),right = max(min(C,G),left);
    //more right more large,left is max 
    //of A,E right is max of ((min of C,G),left)
    int bottom = max(B,F),top = max(min(D,H),bottom);
    //see picture 
    return (C-A)*(D-B) -(top - bottom)*(right-left) +(G-E)*(H-F);
    }
}