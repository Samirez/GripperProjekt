package urcapsplugin;
/**
 *
 * @author Ahmad
 */
public class URcapsPlugin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here7
        RobotClient Ra = new RobotClient("3234",54);
        try {
        Ra.connect();
        }catch (NullPointerException e){
        System.out.println(e.getMessage());
        }
        if (Ra.isConnected())
        {
            System.out.println("TCP connection is completed");
        }
        else 
        {
            System.out.println("connection failed");
        }
        Ra.disconnect();
    }
}
