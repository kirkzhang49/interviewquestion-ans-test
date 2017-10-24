public class RandomizedSet {
      ArrayList<Integer> nums;
      HashMap<Integer,Integer> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer,Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Boolean contain = locs.containsKey(val);
        if (contain) return false;//check for uniqueness
        locs.put(val,nums.size());//map it
        nums.add(val);//add it 
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Boolean contain = locs.containsKey(val);
        if (!contain) return false;
        int loc = locs.get(val);
        if (loc < nums.size()-1)//if the position is not last
        {
            int lastone = nums.get(nums.size()-1);
            nums.set(loc,lastone);//set the location loc to lastone val
            //so when we delete val it use last space
            locs.put(lastone,loc);//put lastone in loc position 
            //so when delete it delete val but lastone still exist!
        }
        locs.remove(val); //remove val from map
        nums.remove(nums.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
        //get a random number out of nums.size's range.
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */