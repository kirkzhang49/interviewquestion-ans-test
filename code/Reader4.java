/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     private int buffPtr = 0;
     private int buffCnt = 0;
     private char [] buff = new char [4];
    public int read(char[] buf, int n) {
        int ptr =0;//record how many chars in file
        while (ptr<n)
        {
         if(buffPtr == 0)
         {
         buffCnt = read4(buff);//record buff read by read4
         }
         //while loop to save read4 buff until buffCnt or n
         while (ptr<n&&buffPtr<buffCnt)
         {//save read buff into buff
             buf[ptr++] = buff[buffPtr++];
         }
         if(buffPtr==buffCnt) buffPtr=0;//reset ptr since all chars buff saved
         if(buffCnt<4) break;//if read4 less than 4,end of file 
        }
        return ptr;
    }
}
/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.
*/