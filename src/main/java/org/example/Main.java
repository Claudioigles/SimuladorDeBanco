package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        mostrarMensaje("Bienvenidos a Banelco");
        int intentos=0;
        boolean ingreso =true;
        String usuarioCorrecto="claudio";
        String contrasenaCorrecta="12345";
        double dineroEnCuenta =0, dineroIngresado, dineroRetirar, total=0;
        while (intentos <= 3 || ingreso){
            //Ingreso usuario y contraseña
            String usuarioIgresado=obtenerUsuario();
            //Verifico las credenciales
            if (usuarioCorrecto.equals(usuarioIgresado) && usuarioIgresado!= null){
                mostrarMensaje("Usuario correcto");
                String contrasenaIngresada= obtenerContrase();
                if (contrasenaCorrecta.equals(contrasenaIngresada) && contrasenaIngresada!=null){
                    mostrarMensaje("Ingreso al sistema");
                    int opcion;
                    do {
                        opcion =  Integer.parseInt(JOptionPane.showInputDialog(null,"Elja una opcion: 1_ Retirar dinero\n 2_ Ingresar dinero\n 3_Ver Dinero en Cuenta\n 4_Exit"));
                        switch (opcion){
                             case 1:
                                 dineroRetirar=Double.parseDouble(JOptionPane.showInputDialog(null,"Cuanto desea retirar"));
                                 total= retirar(total,dineroRetirar);
                                 mostrarMensaje("Ahora su saldo es de: ");
                                 obtenerSaldo(total);
                                 break;
                             case 2:
                                 dineroIngresado=Double.parseDouble(JOptionPane.showInputDialog(null,"Cuanto dinero desea Ingresar a su cuenta"));
                                 total=suma(dineroEnCuenta,dineroIngresado);
                                 obtenerSaldo(total);
                                 break;
                             case 3:
                                 obtenerSaldo(total);
                                break;
                         }
                     }while(opcion!=4);
                    mostrarMensaje("Gracias por su visita");
                    break;
                }else {
                    mostrarMensaje("Error de  contraseña");
                    intentos ++;
                }
            }else {
                mostrarMensaje("Error de usuario");
                intentos ++;
            }
            ingreso=false;
        }


    }
    public static String obtenerUsuario(){
        String usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        return usuario;
    }
    public static String obtenerContrase(){
        String contra = JOptionPane.showInputDialog("Ingrese su contraseña:");
        return contra;
    }
    public static void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public static double suma(double a, double b){
        double total= a + b;
        return total;
    }
    public  static double retirar(double a, double b){
        if (b > a) {
            mostrarMensaje("No puede retirar más dinero del que tiene en la cuenta.");
            return a;
        } else {
            double total = a - b;
            return total;
        }
    }
    public static void obtenerSaldo(double total){
        JOptionPane.showMessageDialog(null,"Su cuenta ahora tiene : $"+total);
    }

}

