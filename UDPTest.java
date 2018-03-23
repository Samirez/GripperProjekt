/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urcapsplugin;
/**
 *
 * @author Ahmad
 */
public class UDPTest {
    EchoClient client;
 
    @Before
    public void setup(){
        new EchoServer().start();
        client = new EchoClient();
    }
 
    @Test
    public void whenCanSendAndReceivePacket_thenCorrect() {
        String echo = client.sendEcho("hello server");
        assertEquals("hello server", echo);
        echo = client.sendEcho("server is working");
        assertFalse(echo.equals("hello server"));
    }
 
    @After
    public void tearDown() {
        client.sendEcho("end");
        client.close();
    }
}