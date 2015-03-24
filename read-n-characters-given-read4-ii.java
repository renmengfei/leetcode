public class Solution extends Reader4 {
    char[] buffer = new char[4];
    int offset=0;
    int buffersize = 0;
    
    public int read(char[] buf, int n) {
        int result = 0;
        boolean eof = false;
        while(!eof && result <n){
            //empty
            if(buffersize==0){
                buffersize = read4(buffer);
                if(buffersize<4) eof = true;
            }
            int bytes = Math.min(buffersize, n-result);
            System.arraycopy(buffer,offset,buf,result,bytes); 
            offset = (offset+bytes)%4;
            result+=bytes;
            buffersize-=bytes;
        }
        return result;
    }
}
