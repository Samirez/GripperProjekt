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
import java.net.UnknownHostException;
import java.io.IOException;
/**
 *
 * @author Ahmad
 */
public class EchoClient {
    private DatagramSocket socket;
    private InetAddress address;
 
    private byte[] buf;
 
    public EchoClient(){
        try {
        socket = new DatagramSocket();
        try {
        address = InetAddress.getByName("localhost");
        } catch (UnknownHostException e){
            System.out.println(e.getMessage());
        }
        } catch(SocketException e){
        }
    }
     public String sendEcho(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet 
          = new DatagramPacket(buf, buf.length, address, 4445);
        try {
        socket.send(packet);
        } catch(IOException e){
                System.out.println(e.getMessage());
            }
        packet = new DatagramPacket(buf, buf.length);
        try {
        socket.receive(packet);
        } catch(IOException e){
                System.out.println(e.getMessage());
            }
        String received = new String(
          packet.getData(), 0, packet.getLength());
        return received;
    }
 
    public void close() {
        socket.close();
    }
}
