import java.net.*;
import java.io.*;
import java.lang.Runnable;

public class MiniHTTP {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening on 8080...");
        while (true) {
            Socket s = server.accept();
            new Thread(() -> handle(s)).start();
        }
    }
    static void handle(Socket s) {
        try (var in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             var out = new PrintWriter(s.getOutputStream())) {
            in.readLine();
            out.println("HTTP/1.1 200 OK\r");
            out.println("Content-Type: text/plain\r");
            out.println();
            out.println("Hello from Dalvik!");
            out.flush();
        } catch (IOException e) { e.printStackTrace(); }
    }
}
