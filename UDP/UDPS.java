import java.net.*;

class UDPS{
    public static void main(String args[]) throws Exception{
        DatagramSocket Serversocket = new DatagramSocket(5454);
        System.out.println("Server is ready to receive");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        while(true){
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            Serversocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.println("RECEIVED :" +sentence);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalised = sentence.toUpperCase();
            sendData = capitalised.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
            Serversocket.send(sendPacket);

        }
    }
}

