import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Server Class
public class Server {
    private ServerSocket server;
    private Socket socket;
    
    private BufferedReader br; // to read data
    private PrintWriter pw; // to write data

    public Server() {
        try {
            server = new ServerSocket(2320);
            System.out.println("Server is ready to accept connections...");
            System.out.println("Waiting...");
            socket = server.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();

        } catch (Exception e) {
            System.out.println("Connection closed");
        }
    }

    private void startReading() {
        Runnable readerTask = () -> {
            System.out.println("Reader started...");
            while (true) {
                try {
                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("Client terminated the chat");
                        socket.close();
                        break;
                    }
                    System.out.println("Client: " + msg);
                } catch (Exception e) {
                    System.out.println("Connection closed");
                    break;
                }
            }
        };
        new Thread(readerTask).start();
    }

    private void startWriting() {
        Runnable writerTask = () -> {
            System.out.println("Writer started...");
            try {
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                while (!socket.isClosed()) {
                    String content = consoleReader.readLine();
                    pw.println(content);
                    pw.flush();
                    if (content.equals("exit")) {
                        socket.close();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Connection closed");
            }
        };
        new Thread(writerTask).start();
    }

    public static void main(String[] args) {
        System.out.println("Server is running...");
        new Server();
    }
}
