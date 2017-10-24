import java.io.*;
import java.util.*;
import java.nio.file.*

public class Soltuion{
     public String GoatLatinLanguage(String s)
     {
    String [] ss = s.trim().split("\\s+");
    for (int i =0;i<ss.length;i++)
    {
     if (ss[i].matches("^[AEIOUaeiou]"))
     {//if start from AEIOU  
         ss[i] =ss[i] +"ma"; //and with "ma"
     }
     else
     {//if not put first letter to the end 
    ss[i] = ss[i].substring(1) +ss[i].charAt(0);
     }
 StringBuilder sb = new StringBuilder ();
 for (int j =0;j<=i;j++)
 {//first one a second two a and so on 
     sb.append("a");
 }
  ss[i] += sb.toString();
    }  
    return String.join(" ",ss);
    //join by split by space  
     }   



}