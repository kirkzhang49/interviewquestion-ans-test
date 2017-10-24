Question 2:
https://website.com/?first=32&alt=last&val
Question 4:
10 10 times
Question 6:
Game.prototype.start = function(inputElements){
    inputElements.forEach(function($el){
        $el.on("click",this.handleClick);
    });
};
Game.prototype.handleClick = function(e)
{
    //....
}
The click event handler written above will cal handleClick on the window instead of game obejc
Question 9:
int total =0;
for (int x=0;x<side_length;x++)
{
    for (int y=0;y<side_length;y++)
    {
        if (array[y][x]!=0)
        {
            total +=1;
        }
    }
}
The compiler is less able to optimize that loop
Question 10: I do not know all ans seems wrong
Question 11:
int ** allocate2DArray (int width,int height){
    int **array = malloc(sizeof(int *)*width);
    array[1] = malloc(sizeof(int) *height);
    return array;
}
This only allocate a single column all the columns need to be allocate in loop
 int r = 3, c = 4;
    int *arr = (int *)malloc(r * c * sizeof(int)); 
This code declare all together
Question 13:
int i;
  for (i=0;i<10;i++){}
  int x=i;
    printf("%d",x);
  ans :10
Question 14:
<div class ='first_div'>
<p>Content</p>
<div class = 'comment'></div>
<div class='comment'></div>
<div id='pagination'></div>
</div>
<script type='text/javascript'>
jQuery(function(){
    $('#pagination').addClass('comment');
    $('.first_div .comment').text('value');
});
</script>
This HTML&JavaScript is not valid
Question 15:
 matrix = Array.new
  matrix.push([1,2,3])
  matrix.push([4,5,6])
  matrix.push([7,8,9])
  x = matrix[0][2]+matrix[2][1]
  puts " ans: " + x.to_s
  Ans:11
  Question 19:
  list = list->next;
  Question 20:
  def map(array,method)
    result_array=[]
array.each do |element|
    #Call the method on the object
    value = element.send(method)
    #MISSing LINE
end

    return result_array
end
ans:result_array.push(value)

Question 21: need add one to the value it returns

Quesion 23
def f(n):
    if n<=0:
        return 0
    return n+f(int(n/2))
Ans : 7

Quesion 30
return false;

Question 31:
minValue = array[i];

Question 33:


Question 35
insertion sort

// package whatever; // don't place package name!
/*
 "Write a function that given a list of countries, returns the country(s) that occur the least times. 
i.e - [""Argentina"", ""Cuba"", ""Chile"", "Argentina""] -> [""Cuba"", ""Chile""]"                        
                     
*/

import java.io.*;
import java.*;
class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Java");
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
                if (!map.contains(s))
                    {
                       map.put(s,1);
                    }
            else map.put(s,map.get(s)+1);
            }
        
        int min = Integer.MAX_VALUE;
          for (Map.entrySet m: map)
              {
                 if (m.value()<min)
                     min=m.value;
              }
        List<String> result = new ArrayList<>();
        HashSet<String> check = new HashSet<>();
        for (Map.entrySet m:map)
            {
              if (m.value()==min&&!check.contains(m.key()))
                  result.add(m.key());
              check.add(m.key());
            }
        return result;
        }
}
