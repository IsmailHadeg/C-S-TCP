import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Creazione del socket del client e connessione al server sulla porta 9999
            Socket clientSocket = new Socket("localhost", 9999);

            // Creazione dei buffer di input e output per comunicare con il server
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Invio della richiesta al server
            String request = "Come stai?";
            outToServer.println(request);

            // Lettura della risposta dal server
            String response = inFromServer.readLine();
            System.out.println("Risposta dal server: " + response);

            // Chiusura del socket del client
            clientSocket.close();
        } catch (IOException e) {

        }
    }
}



