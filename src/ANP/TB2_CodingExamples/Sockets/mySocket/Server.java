package ANP.TB2_CodingExamples.Sockets.mySocket;

import java.net.*;
import java.io.*;

public class Server {
    public static final int PORT = 8989;
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");

            try (Socket socket = server.accept()) {
                System.out.println("Client accepted");
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    String line = in.readLine();
                    System.out.println("Rec: " + line);

                    out.println(line);
                    System.out.println("Send: " + line);
                    if (line.equals("end")) break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
