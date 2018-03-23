/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urcapsplugin;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.io.IOException;
/**
 *
 * @author Ahmad
 */
public class EchoServer extends Thread{
    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];
 
    public EchoServer() {
        try{
    socket = new DatagramSocket(4445);   
    } catch(SocketException e){
        System.out.println(e.getMessage());
    } 
}
    public void run() {
        running = true;
 
        while (running) {
            DatagramPacket packet 
              = new DatagramPacket(buf, buf.length);
            try {
            socket.receive(packet);
            } catch(IOException e){
                System.out.println(e.getMessage());
            }
             
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            String received 
              = new String(packet.getData(), 0, packet.getLength());
             
            if (received.equals("end")) {
                running = false;
                continue;
            }
            try {
            socket.send(packet);
             } catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        socket.close();
    }
}