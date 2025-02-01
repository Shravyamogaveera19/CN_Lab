import java.io.*;
import java.net.*;

class TCPS{
    public static void main(String args[]) throws Exception{
        ServerSocket sersock = new ServerSocket(3300);
        System.out.println("Server is ready for connection");
        Socket sock= sersock.accept();
        System.out.println("Cunnection is successfully established and server is waiting for client request");
        InputStream istream = sock.getInputStream();
        BufferedReader fileRead= new BufferedReader(new InputStreamReader(istream));
        String fname = fileRead.readLine();
        BufferedReader contentRead = new BufferedReader(new FileReader(fname));
        OutputStream ostream= sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream,true);

        String str;
        while((str = contentRead.readLine())!= null){
            pwrite.println(str);
        }

        sock.close();
        sersock.close();
        pwrite.close();
        fileRead.close();
    }
}