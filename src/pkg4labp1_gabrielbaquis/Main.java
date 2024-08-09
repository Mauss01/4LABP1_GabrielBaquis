/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg4labp1_gabrielbaquis;

import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int decision;
        
        do {
            System.out.println();
            System.out.println("...Menu...");
            System.out.println("1) suma de binarios");
            System.out.println("2) caracteres y numeros");
            System.out.println("3) se encuentra el patron?");
            System.out.println("4) Sslir");
            System.out.println();
            decision = sc.nextInt();
            
            
            String cadena1;
            String cadena2;
            
            switch(decision){
                case 1:
                    System.out.println("Ingrese primera cadena de binarios: ");
                    cadena1 = sc.next();
                    
                    System.out.println("Ingrese primera cadena de binarios: ");
                    cadena2 = sc.next();
                    
                    String resultado = sumar_Binarios(cadena1, cadena2);
                    System.out.println();
                    
                    System.out.println("  "+cadena1);
                    System.out.println("+ "+cadena2);
                    System.out.println("-------------");
                    System.out.println(resultado);
                    break;
                    
                case 2:
                    System.out.println("Ingrese una cadena : ");
                    String cadena = sc.next();
                    
                    String resul = verificar_Cadena(cadena);
                    System.out.println(resul);
                    break;  
                    
                case 3:
                    break;    
                    
                case 4:
                    System.out.println("Saliendo del programa....");
                    sc.close();
                    break;
            }
        } while (decision != 4);
    }
      
    public static String sumar_Binarios(String cadena1, String cadena2) {
        if(cadena1.length() != 8 || cadena2.length() != 8) {
            System.out.println("Ambas cadenas deben tener exactamente 8 digitos.");            
        }

        for (int i = 0; i < 8; i++) {
            if ((cadena1.charAt(i) != '0' && cadena1.charAt(i) != '1') || (cadena2.charAt(i) != '0' && cadena2.charAt(i) != '1')) {
                System.out.println("Las cadenas solo deben contener caracteres 0s y 1s.");
            }
        }

        String resultado = "";
        int acarreo = 0;

        for (int i = 7; i >= 0; i--) {
            int bit1 = cadena1.charAt(i) - '0';  
            int bit2 = cadena2.charAt(i) - '0';

            int suma = bit1 + bit2 + acarreo;

            if (suma == 0) {
                resultado = '0' + resultado;
                acarreo = 0;
            } else if (suma == 1) {
                resultado = '1' + resultado;
                acarreo = 0;
            } else if (suma == 2) {
                resultado = '0' + resultado;
                acarreo = 1;
            } else if (suma == 3) {
                resultado = '1' + resultado;
                acarreo = 1;
            }
        }

        return resultado;
    }
    
    public static String verificar_Cadena(String cadena) {
        boolean letras = false;
        boolean num = false;

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z')) {
                letras = true;
            }

            if (caracter >= '0' && caracter <= '9') {
                num = true;
            }
        }
        
        String resul = "";
        
        if (letras && num) {
            resul = "La cadena es alfanumerica";
        } else if (letras) {
            resul = "La cadena solo tiene letras";
        } else if (num) {
            resul = "La cadena solo tiene numeros";
        } else {
            resul = "La cadena no contiene letras ni numeros";
        }
        return resul;
    }
}
