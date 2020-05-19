package cliente;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class SocketCliente {
	  private static final String HOST = "127.0.0.1";
	  private static final int PORTA = 1234;
	  private static final int FILE_SIZE = 6022386;
	  
	  public static void main(String[] args) {
	    try {
	      Socket socket = new Socket(HOST, PORTA);
	  
	      DataInputStream dis = new DataInputStream(socket.getInputStream());
	  
	      byte[] mybytearray = new byte[FILE_SIZE];
	  
	      FileOutputStream fos = new FileOutputStream("C:\\Users\\Master\\Downloads\\arquivos\\android_copy5.gif");
	  
	      BufferedOutputStream bos = new BufferedOutputStream(fos);
	  
	      int bytesRead = dis.read(mybytearray, 0, mybytearray.length);
	  
	      int current = bytesRead;
	  
	      do {
	        bytesRead = dis.read(mybytearray, current, (mybytearray.length - current));
	        if (bytesRead >= 0) {
	          current += bytesRead;
	        }
	      } while (bytesRead > -1);
	  
	      bos.write(mybytearray, 0, current);
	  
	      System.out.println("Arquivo recebido com sucesso!");
	  
	      bos.flush();
	  
	      bos.close();
	  
	      socket.close();
	    } catch (Exception ex) {
	      System.out.println(ex.getMessage());
	    }
	  }
}
