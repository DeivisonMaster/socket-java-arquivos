package servidor;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;

public class SocketServidor {
	private static final int PORTA = 1234;

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(PORTA);
			Socket socket = server.accept();
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			File arquivo = new File("C:\\Users\\Master\\Downloads\\image006.gif");
			
			byte[] buffer = new byte[(int) arquivo.length()];
			
			InputStream fis = new FileInputStream(arquivo);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			bis.read(buffer, 0, buffer.length);
			
			System.out.println("Enviando aruqivo " + arquivo.getName() + "\"");
			
			dos.write(buffer, 0, buffer.length);
			dos.flush();
			dos.close();
			socket.close();
			
			server.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}















