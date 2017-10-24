public class Java8FileReader { public static void main(String args[]) throws IOException 
{ // reading a file line by line before Java 8 
FileReader fr = new FileReader("manifest.mf"); 
BufferedReader bufr = new BufferedReader(fr); 
int count = 1; 
String line = bufr.readLine(); 
System.out.println("Old way of reading file line by line in Java : "); 
while(line != null)
{ 
    System.out.println(count + " : " + line); 
    line = bufr.readLine(); 
    count++; 
    } 
    bufr.close(); // reading file line by line in Java 8 
    System.out.println("Reading file line by line using Files.lines() in Java 8"); 
    Files.lines(Paths.get("manifest.mf")).forEach(System.out::println); 
    // You can do even better, you can read all lines 
    // trim them and filter out all empty lines 
    // before printing as shown in following example 
    System.out.println("Doing more things than just reading file using Java 8 Streams");
     Files.lines(new File("manifest.mf").toPath()) .map(s -> s.trim()) .filter(s -> !s.isEmpty()) .forEach(System.out::println);
 // You can also filter line using String methods 
 // e.g. print only lines which starts with " 
 System.out.println("Printing lines which startswith ); 
 Files.lines(Paths.get("build.xml")) .map(s -> s.trim()) .filter(s -> s.startsWith(")) .forEach(System.out::println); } }

Read more: http://javarevisited.blogspot.com/2015/07/3-ways-to-read-file-line-by-line-in.html#ixzz4QZllenXp