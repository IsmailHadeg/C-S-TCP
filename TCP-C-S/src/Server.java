import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Creazione del socket del server sulla porta 9999
            ServerSocket serverSocket = new ServerSocket(9999);

            while (true) {
                // Accettazione della connessione da parte del client
                Socket clientSocket = serverSocket.accept();

                // Creazione dei buffer di input e output per comunicare con il client
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

                // Lettura del messaggio inviato dal client
                String clientMessage = inFromClient.readLine();
                System.out.println("Messaggio ricevuto dal client: " + clientMessage);

                // Risposta al client
                String response = "Bene";
                outToClient.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
