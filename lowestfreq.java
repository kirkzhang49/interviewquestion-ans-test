import java.util.*;

public class HelloWorld{

     public static void main(String []args){
       //System.out.println("Hello Java");
        List<String> input = new ArrayList<String>(
            Arrays.asList("Argentina","Cuba", "Chile", "Argentina"));
        List<String> rr = new ArrayList<>();
        rr=leastFre(input);
        for (String s :rr)
        System.out.println(s);
     }
       
    public static List<String> leastFre(List<String> Countries)
        {
           HashMap<String,Integer> map = new HashMap<>();
        for (String s : Countries)
            {
                if (!map.containsKey(s))
                    {
                       map.put(s,1);
                    }
            else map.put(s,map.get(s)+1);
            }
        
        int min = Integer.MAX_VALUE;
          for (Map.Entry<String,Integer> m: map.entrySet())
              {
                 if (m.getValue()<min)
                     min=m.getValue();
              }
        List<String> result = new ArrayList<>();
        HashSet<String> check = new HashSet<>();
        for (Map.Entry<String,Integer> m:map.entrySet())
            {
              if (m.getValue()==min&&!check.contains(m.getKey()))
                  result.add(m.getKey());
              check.add(m.getKey());
            }
        return result;
        }
}