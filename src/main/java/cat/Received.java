package cat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Received extends Thread {

    private Socket socket;
    private String name;

    public Received(Socket socket,String name) {
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        new Thread(() -> {
            try(PrintWriter out = new PrintWriter(socket.getOutputStream());
                BufferedReader sin = new BufferedReader(new InputStreamReader(System.in))){

                while (true){
                    String line = sin.readLine();
                    if (line == null || line.equals("bey")){
                        break;
                    }
                    out.println(line);
                    out.flush();
                    System.out.println(name + " > " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
