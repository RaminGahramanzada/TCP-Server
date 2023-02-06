/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package tcpserver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import lombok.SneakyThrows;
import util.FileUtil;

/**
 *
 * @author Lenovo
 */
public class TCPServer {

    public static void main(String[] args) throws IOException, Exception {
        readAsByte();
    }

    @SneakyThrows
    public static void readAsByte() {

        ServerSocket ourFirstServerSocket = new ServerSocket(6789);

        while (true) {
            System.out.println("Wait for new client");
            Socket connection = ourFirstServerSocket.accept();
            System.out.println("Hey have a new Client");
           
            DataInputStream dataStream = new DataInputStream(connection.getInputStream());

          byte [] arr = readMessage(dataStream);
            System.out.println("message length2="+arr.length);
            FileUtil.writeBytes(arr,"C:\\Users\\Lenovo\\Desktop\\test.jpg");

        }
    }

    @SneakyThrows
    public static byte[] readMessage(DataInputStream din) {
        
        int msgLen = din.readInt();
        System.out.println("message length ="+msgLen);
        byte[] msg = new byte[msgLen];
        din.readFully(msg);
        return msg;
    }

    @SneakyThrows
    public static void readAsString() {

        ServerSocket ourFirstServerSocket = new ServerSocket(6789);

        while (true) {
            System.out.println("Wait for new client");
            Socket connection = ourFirstServerSocket.accept();
            System.out.println("Hey have a new Client");
            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bReader = new BufferedReader(reader);

            String messageFromClient = bReader.readLine();
            System.out.println("Client say that:" + messageFromClient);

        }
    }

}
