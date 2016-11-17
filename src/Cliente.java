
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        try{
        //1.establecer comunicacion con el servidor
            Socket cliente = new Socket("localhost",8000);
            
            
        
            InputStream FlujoEntrada = cliente.getInputStream();
            OutputStream FlujoSalida = cliente.getOutputStream();
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(FlujoEntrada));
            
            PrintWriter salida = new PrintWriter(FlujoSalida,true);
            
            //flujo para datos del tecflado
            BufferedReader DatosUsuario = new BufferedReader(new InputStreamReader(System.in));
            
            String mensajeAEnviar = "";
            String mensajeARecibir = "";
            
            while(true){
                System.out.println("Enviar: ");
                mensajeAEnviar = DatosUsuario.readLine();
                salida.println(mensajeAEnviar);
                mensajeARecibir = entrada.readLine();
                System.out.println(mensajeARecibir);
            }
        }catch(IOException ex){
            
        }    
    }
    
}
