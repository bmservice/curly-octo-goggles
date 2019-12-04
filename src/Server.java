import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=new ServerSocket(30000);
        while (true){
            Socket s= serverSocket.accept();
            PrintStream printStream=new PrintStream(s.getOutputStream());
            printStream.println("helloworld");
            printStream.close();
            s.close();
        }
    }
}
class Client{
    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("127.0.0.1",30000);
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line=br.readLine();
        System.out.println("来自服务器数据:"+line);
        br.close();
        socket.close();
    }
}
