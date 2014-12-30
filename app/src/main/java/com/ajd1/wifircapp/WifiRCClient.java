package com.ajd1.wifircapp;

        import java.io.DataOutputStream;
        import java.io.IOException;
        import java.net.Socket;

public class WifiRCClient {
    String IP;
    int PORT;

    public WifiRCClient(String ipaddress, int port) {
        IP = ipaddress;
        PORT = port;
    }

    public void WifiForward() throws IOException {
        Socket socket = new Socket(IP, PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(1);
        socket.close();
    }

    public void WifiReverse() throws IOException {
        Socket socket = new Socket(IP, PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(2);
        socket.close();
    }

    public void WifiRight() throws IOException {
        Socket socket = new Socket(IP, PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(3);
        socket.close();
    }

    public void WifiLeft() throws IOException {
        Socket socket = new Socket(IP, PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(4);
        socket.close();
    }

    public void WifiStop() throws IOException {
        Socket socket = new Socket(IP, PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(5);
        socket.close();
    }

    public void WifiExit() throws IOException {
        Socket socket = new Socket(IP, PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(6);
        socket.close();
    }

    public void WifiHonk() throws IOException {
        Socket socket = new Socket(IP, PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(7);
        socket.close();
    }

    public void WifiFire() throws IOException {
        Socket socket = new Socket(IP, PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(8);
        socket.close();
    }

    public void WifiStopFire() throws IOException {
        Socket socket = new Socket(IP, PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(9);
        socket.close();
    }
}

