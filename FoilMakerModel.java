import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Nicholas on 10/24/2016.
 */
public class FoilMakerModel {

    public String logIn(String username,String password){
        String response;
        response = getResponse("CREATENEWUSER--" + username + password);
        return response;
        //response = response.replace("RESPONSE--CREATENEWUSER--","");
        //return response.replace("--","");
    }

    public String getResponse(String messageToServer){
        String serverIP = "localhost";
        int serverPort = 6000;
        try {
            // Connect to server
            Socket socket = new Socket(serverIP, serverPort);

            // Create data writer
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create data reader
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            // Send message to server
            out.println(messageToServer);

            // Read server response
            String serverMessage = in.readLine();
            return serverMessage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        FoilMakerModel test = new FoilMakerModel();
        System.out.println("Login: Bobby\nPassword: bob1");
        System.out.println(test.logIn("Bobby","bob1"));
    }
}
