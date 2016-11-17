
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Servidor {
    public static void main(String[] args)  {
        try{
            //1.establecer servidor
            ServerSocket servidor = new ServerSocket(8000);
            
            System.out.println("esperando conexiones");
            //2.aceptar conexion
            Socket cliente = servidor.accept();
            System.out.println("se conecto un cliente");
            //3.abrir IO
            InputStream FlujoEntrada = cliente.getInputStream();
            OutputStream FlujoSalida = cliente.getOutputStream();
            //4.Usar decoradores para convertir bytes en texto
            BufferedReader entrada = new BufferedReader(new InputStreamReader(FlujoEntrada));
            
            BufferedReader DatosUsuario = new BufferedReader(new InputStreamReader(System.in));
            
            PrintWriter salida = new PrintWriter(FlujoSalida,true);
            
            
            String mensaje="";
            String mensajeAEnviar =""; 
            while(true){
                mensaje = entrada.readLine();
                System.out.println(mensaje);
                System.out.println("Enviar: ");
                mensajeAEnviar = DatosUsuario.readLine();
                salida.println(mensajeAEnviar);
            }
                    
                    
                    
        }catch (IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }
}
