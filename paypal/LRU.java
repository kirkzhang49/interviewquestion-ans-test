
class Solution {
  public static void main(String[] args) {
 LRUCache cache = new LRUCache( 2 /* capacity */ );

    cache.put(1, 1);
    cache.put(2, 2);
    int result =cache.get(1);       // returns 1
    System.out.println(result);
    cache.put(3, 3);    // evicts key 2
    //cache.get(2);       // returns -1 (not found)
    result =cache.get(2); 
     System.out.println(result);
    cache.put(4, 4);    // evicts key 1
    result =cache.get(1);       // returns -1 (not found)
      System.out.println(result);
    result =cache.get(3);       // returns 3
      System.out.println(result);
    result =cache.get(4);       // returns 4
      System.out.println(result);

  }

 public static class  LRUCache {
    int left;
    HashMap<Integer,Integer> map;
    List<Integer> queue = new ArrayList<>();
    public LRUCache(int capacity) {
        left = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
          queue.remove(queue.indexOf(key));
          queue.add(key);
          return map.get(key);
        }else return -1;
    }
    
    public void put(int key, int value) {
        if (left>0||map.containsKey(key)){
          if (!map.containsKey(key)){
              left--;
          }
          map.put(key,value);
        }
        else {
            map.remove(queue.get(0));
            queue.remove(0);
            map.put(key,value);
        }
        if(queue.contains(key)){
          queue.remove(queue.indexOf(key));
        }
      queue.add(key);
    }
}
}