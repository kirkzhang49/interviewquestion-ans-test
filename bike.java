  import java.io.*;
  import java.util.*;


  class Solution {

    public static class ride
    {
       private String StartTime = "";
       private String EndTime = "";
       private String Items ="";
      
        public ride(String S,String E,String I)
        {
            StartTime = S;
            EndTime = E;
            Items = I;
        }
      
        public  String getStartTime()
        {
             return StartTime;
        }
      
        public  String getEndTime()
        {
            return EndTime;
        }
      
        public  String getItems()
        {
            return Items;
        }
    }

      public static class baskets
    {
        private String time;
        private int key;
        private String item;
        private Boolean flag;
        
      public baskets(String s,int n,String i,Boolean f)
      {
        time =s;
        key = n;
        item = i;
        flag = f;
      }
        
      public String getTime()
      {
        return time;
      }
        
      public int getKey()
      {
        return key;
      }
        
      public String getItem()
      {
        return item;
      }
        
      public Boolean getFlag()
      {
        return flag;
      }
        
    }

    
    public static void main(String[] args) {
      
        ride input = new ride("07:00","07:30","2 apples, 1 brownie");
        ride input1 = new ride("07:10","08:00","1 apple, 3 carrots");
        ride input2 = new ride("07:20","07:45","1 apple, 2 brownies, 4 diamonds");
        //ride RepeatCase = new ride("07:00","07:20","1 QQ, 2 GGs");
        ItemCounter counter = new ItemCounter();
        counter.process_ride(input);
         counter.process_ride(input1);
        counter.process_ride(input2);
        //counter.process_ride(RepeatCase);
        counter.print_items_per_interval();
      
    }

    public static class ItemCounter
    {
      
      private HashMap<String,Integer> map = new HashMap<>();
      private  List<baskets> list = new ArrayList<>();
      private PriorityQueue<baskets> heap =
              new PriorityQueue<>((a,b)->(a.getKey()-b.getKey()));
        
        public  void process_ride(ride newRide)
        {
            //list.add(newRide);
          String start = newRide.getStartTime();
          String end = newRide.getEndTime();
          String item = newRide.getItems();
            int Time1 = CalTime(start);
            int Time2 = CalTime(end);
          baskets StartTime = new baskets(start,Time1,item,true);
          baskets EndTime = new baskets(end,Time2,item,false);
          list.add(StartTime);
          list.add(EndTime);

        }

        public  void print_items_per_interval()
        {
          
            heap.addAll(list);
            baskets start;
            baskets end;
            String currentItem;
            Boolean CheckCase = false;

            while(!heap.isEmpty()) 
            {

               start = heap.poll();

              if(!heap.isEmpty())
              {

                end = heap.peek();

              while (start.getTime()==end.getTime())
              {

                if (heap.size()==1) 
                {
                  CheckCase=true;
                   break;
                }

                currentItem = CalItem(start);
                start = heap.poll();
                end = heap.peek();

              }
                if (CheckCase) 
                {
                  heap.poll();
                  break;
                }

              currentItem = CalItem(start);
              System.out.print(start.getTime()+"-"+
              end.getTime()+" --> "+currentItem+"\n");
               
            }
          }
        
        }

      public String CalItem(baskets input)
      {

          String [] set = input.getItem().split(",");
          Boolean check = input.getFlag();
          String result ="";

          for (int i=0;i<set.length;i++)
          {
            String temp = set[i].trim();
            String [] ss = temp.split(" ");
            int num = Integer.parseInt(ss[0]);
            String str = ss[1];
            

              if (map.containsKey(str))
              {
                if (check)
                {
                  num = map.get(str) + num;
                }
                else 
                {
                  num = map.get(str) - num;
                  map.remove(str);
                }
              }
            
              if (map.containsKey(str+"s"))
              {
                if (check)
                {
                  num = map.get(str+"s") + num;
                }
                else 
                {
                  num = map.get(str+"s") - num;
                  map.remove(str+"s");
                }
              }
            
              if (map.containsKey(str.substring(0,str.length()-1)))
              {
                if (check)
                {
                  num = map.get(str.substring(0,str.length()-1)) + num;
                  
                  if (num>1) map.remove(str.substring(0,str.length()-1));
                  
                }
                
                else 
                {
                  num = map.get(str.substring(0,str.length()-1)) - num;
                  map.remove(str);
                }
              }
            
            if (num>1){
               if (str.charAt(str.length()-1)!='s')
               {
                map.remove(str);
                str=str+"s";
 
               }
               map.put(str,num);
            }
            
            if (num==1)
            {
                 if (str.charAt(str.length()-1)=='s')
               {
                map.remove(str);
                str=str.substring(0,str.length()-1);
               }
                  map.put(str,num);
            }

          }
        
      List<Map.Entry<String, Integer>> Templist = 
      new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        
        Collections.sort( Templist, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, 
                               Map.Entry<String, Integer> o2) 
            {
                return (o1.getKey()).compareTo( o2.getKey() );
            }
        });
        
        
        for (Map.Entry<String,Integer> m:Templist)
        result+= m.getValue().toString() +" " + m.getKey() +", ";
        
          result=result.substring(0,result.length()-2);
        
          return result;
      }

       public  int CalTime(String time)
        {
         
            String s[] = time.split(":");
            int result =0;

            if (s[0].charAt(0)=='0')
            {
             result+=Character.getNumericValue(s[0].charAt(1))*60;
            }
         
            else 
              result+=Integer.parseInt(s[0])*60;

             if (s[1].charAt(0)=='0')
            {
             result+=Character.getNumericValue(s[1].charAt(1));
            }
            else
              result+=Integer.parseInt(s[1]); 
         
            return result;
        }
    }

  }