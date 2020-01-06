package cat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send extends Thread {

    private String name;
    private Socket socket;

    public Send(Socket socket,String name) {
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        new Thread(() ->{

            try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

                while (true){
                    String line = in.readLine();
                    if (line == null || line.equals("bey")){
                        break;
                    }
                    System.out.println(name + " > " + line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
