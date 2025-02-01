import java.io.*;
import java.net.*;
class UDPC{
    public static void main(String args[]) throws Exception{
        BufferedReader inFormUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        System.out.println("Enter the string in lowercase so that you can get it in Uppercase from server");
        String sentence = inFormUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,5454);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedsentence = new String(receivePacket.getData());
        System.out.println("modified Sentence:" +modifiedsentence);
        clientSocket.close();
    }
}