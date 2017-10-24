static class Point{ 
    int x; 
    int y; 
    Point prev;
     int keys; 
     public Point(int x, int y, int k, Point p)
        { 
             this.x = x;
        this.y = y;
        this.keys = k; 
        prev = p; 
        }
        @Override public String toString()
        {
             return this.x + “” + this.y; 
        } 
        } 
        static List getShortestPath(char grid)
        { 
            if(map.length == 0) 
        return new ArrayList(); 
        // preprocessing to find start and end points 
        int m = map.length, n = map.length();
         Point start = null, end = null; 
         for(int i = 0; i< m; i++)
         { 
         for(int j = 0; j< n; j++) { 
            if(grid == ‘2’) start = new Point(i, j, 0, null); 
            if(grid == ‘3’) end = new Point(i,j, 0, null); 
         } 
        } 
        // System.out.println(“Start: ” + start.toString());// System.out.println(“End: ” + end.toString()); 
        // bfs lookup int 
        visited = new int;
         Point path = null;
          Queue que = new LinkedList();
         que.offer(start); 
         while(!que.isEmpty()) { 
        Point p = que.poll(); 
        // out of boundary 
        if(!isValid(p, m, n)) continue; // in water 
        if(grid == ‘0’) continue; // check the position visited or not before, 
        // also need to check my current keys the same as visiting this position last time 
        // if the same, just continue 
        if((visited & 1) == 1 && ((visited >> 1) ^ p.keys) == 0)
         continue; if(grid >= ‘A’ && grid <= ‘Z’){ int key = grid - ‘A’; 
         // i dont have the key for this door 
         if((p.keys & (1 << (key+1))) == 0) continue; 
         else 
         p.keys -= (1 << (key+1)); 
         }
         // have the key, use it and remove from my key chain 
          if(grid >= ‘a’ && grid <= ‘z’){
               int key = grid - ‘a’; 
               p.keys += (1 << key); 
               } // found a path 
               if(p.x == end.x && p.y == end.y)
               { 
                   path = p; break; 
                   }
                    System.out.println(“Dealing with point: ” + p.toString());
                     visited = (p.keys << 1) + 1; // move around 4 directions
                      int d = new int{1,0,-1,0,1}; 
                      for(int i = 0; i< 4; i++) {
                           int dx = p.x + d;
                            int dy = p.y + d;
                             que.offer(new Point(dx, dy, p.keys, p));
                              } } // build the path;
                               LinkedList ans = new LinkedList(); 
                               while(path != null) {
                                    ans.addFirst(path); 
                                    path = path.prev;
                                     }
                                      return ans; 
                                      } 
// check a point out of boundary or not 
private static boolean isValid(Point p, int m, int n)
{ return p.x >= 0 && p.x < m && p.y >= 0 && p.y < n; }
