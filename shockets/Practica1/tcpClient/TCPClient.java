package tcpClient;
import java.net.*;
import java.io.*;

import util.Settings;

/**
 * <p>Title: Ejemplo 1: TCPClient</p>
 *
 * <p>Description: Basic TCP client</p>
 *
 * <p>Copyright: Copyright (c) 2012</p>
 *
 * <p>Company: ESIDE</p>
 *
 * @author Iaki Vzquez
 * @version 1.0
 */

public class TCPClient {
    public static void main(String[] args) throws Exception {
        String sentence=""; // Texto del usuario
        String modifiedSentence=""; // Texto modificado en maysculas
        try {
            // Creacin del socket con host/direccin y puerto destino
        	// Inicializacin de los streams de E/S        	
            Socket socketCliente = new Socket("127.0.0.1", Settings.PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintStream out = new PrintStream(socketCliente.getOutputStream());
            
            // Creacin de un stream para leer del teclado
            BufferedReader inputTeclado = new BufferedReader(new InputStreamReader(System.in));
            
            // Leer del teclado hasta que escriban "bye" y proceder con la comunicacin
            while (!sentence.equals("bye")) {
            	// Leer texto del teclado
            	System.out.print("Texto a enviar: ");
                sentence = inputTeclado.readLine();
                // Enviar el texto al servidor con final de linea a mano
                out.print(sentence + "\r\n");
                // Leer la respuesta del servidor
                modifiedSentence = in.readLine();
                // Mostrar dicha respuesta por pantalla 
                System.out.println("Respuesta del servidor: " + modifiedSentence);
            }
            System.out.println("Fin del ejemplo");
            in.close();
            out.close();
            socketCliente.close();
        } catch (Exception e) {
			System.err.println("main: " + e);
			e.printStackTrace();
        }

    }
    }
