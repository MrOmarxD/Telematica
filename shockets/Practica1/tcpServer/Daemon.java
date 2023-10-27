/**
 * <p>Title: Ejemplo 1: Daemon</p>
 *
 * <p>Description: Daemon</p>
 *
 * <p>Copyright: Copyright (c) 2012</p>
 *
 * <p>Company: ESIDE</p>
 *
 * @author Iaki Vzquez
 * @version 1.0
 */
package tcpServer;

import java.io.IOException;
import java.net.ServerSocket;

import util.Settings;

public class Daemon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Crea un ServerSocket y escucha por el puerto
			ServerSocket ss = new ServerSocket(Settings.PORT);
			System.out.println("Daemon en ejecucion...");
			for(;;){
				// Aceptar conexiones entrantes de clientes y crear un servidor hijo por cada una
				TCPServer server = new TCPServer(ss.accept());
				server.start();			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
