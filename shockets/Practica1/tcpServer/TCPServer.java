/**
 * <p>Title: Ejemplo 1: TCPServer</p>
 *
 * <p>Description: Basic TCP server</p>
 *
 * <p>Copyright: Copyright (c) 2012</p>
 *
 * <p>Company: ESIDE</p>
 *
 * @author Iaki Vzquez
 * @version 1.0
 */
package tcpServer;
import java.net.*;
import java.io.*;

/* Clase del servidor hijo */
public class TCPServer extends Thread{

		// Socket conectado con el cliente
		Socket socketToClient;
		// Streams de E/S
		BufferedReader in = null;
		PrintStream out = null;
		
		// Crea un SocketManager para gestionar la comunicacin con el cliente
		public TCPServer(Socket s) throws IOException{			
			socketToClient = s;
            in = new BufferedReader(new InputStreamReader(socketToClient.getInputStream()));
            out = new PrintStream(socketToClient.getOutputStream());
		}
		
		// Implementa el protocolo CEP - Capitalized Echo Protocol
        public void run(){
	        String clientSentence="";
	        String capitalizedSentence="";
	        try{
	        	// Procesar mensajes del cliente hasta recibir un "bye"
	            while (!clientSentence.equals("bye")) {
	                // Leer el mensaje del cliente
	                clientSentence = in.readLine();
	                // Ponerlo en maysculas
	                capitalizedSentence = clientSentence.toUpperCase();
	                // Enviar la respuesta
	                out.println(capitalizedSentence);
	            }
	            
	            // Liberar recursos
	            in.close();
	            out.close();
	            socketToClient.close();
	        }catch(Exception e){
	            System.err.println("main: " + e);
	            e.printStackTrace();
	        }
    }
}
