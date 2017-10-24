package test; 
import java.io.BufferedReader; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStream;
 import java.io.InputStreamReader;
  import java.nio.charset.StandardCharsets; 
  import java.nio.file.Files; 
  import java.nio.file.Paths; 

Read more: http://javarevisited.blogspot.com/2015/09/how-to-read-file-into-string-in-java-7.html#ixzz4QZib3KEz
/**
 * Java Program to demonstrate different ways to loop over collection in 
 * pre Java 8 and Java 8 world using Stream's forEach method.
 * @author Javin Paul
 */
public class FileToStringJava8 {

    public static void main(String args[]) throws IOException {

        // How to read file into String before Java 7
        InputStream is = new FileInputStream("manifest.mf");//string file to input file stream
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));//input to buffer
        
        String line = buf.readLine();//string line = first line 
        StringBuilder sb = new StringBuilder();//declear StringBuilder
        
        while(line != null){
            sb.append(line).append("\n");//append line and \n 
            line = buf.readLine();//next line 
        }
        
        String fileAsString = sb.toString();//StringBuilder to string 
        System.out.println("Contents (before Java 7) : " + fileAsString);
        
        
        // Reading file into Stirng in one line in JDK 7
        String contents = new String(Files.readAllBytes(Paths.get("manifest.mf")));
        System.out.println("Contents (Java 7) : " + contents);//one line read file to string 
        
        
        
        // Reading file into String using proper character encoding
        String fileString = new String(Files.readAllBytes(Paths.get("manifest.mf")), StandardCharsets.UTF_8);
        System.out.println("Contents (Java 7 with character encoding ) : " + fileString);
        

        // It's even easier in Java 8
        Files.lines(Paths.get("manifest.mf"), StandardCharsets.UTF_8).forEach(System.out::println);
        
    }


}


Read more: http://javarevisited.blogspot.com/2015/09/how-to-read-file-into-string-in-java-7.html#ixzz4QZiPcRqy