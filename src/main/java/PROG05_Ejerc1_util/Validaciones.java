/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG05_Ejerc1_util;
import PROG05_Ejerc1.Vehiculo;
import static PROG05_Ejerc1.Vehiculo.numDni;
import java.time.LocalDate;
/**
 *clase para validar que los datos introducidos son correctos. 
 * Se valida el dni, kilómetros del vehículo, y su fecha de matriculación
 * @author Laura
 */
public class Validaciones {
    
//VALIDACIÓN DE KILÓMETROS:
    
    /**
     * Método para validar que el número de kilómetros no es inferior a 0
     * @param numKilom: valor recibido con el número de kilómtros del vehículo
     * @return <code>true</code> si el valor es mayor de 0; <code>false</code> si no lo es. 
     */
    public static boolean validarKilom (int numKilom ){
        
        boolean validarKilom= true;
        
        if (numKilom < 0){
            
            validarKilom=false;
            
            System.out.println("Error: introduce un valor mayor de 0");
        }
        
        return validarKilom;
    }
    
//VALIDACIÓN DE LA FECHA DE MATRICULACIÓN    
    /**
     * Método para validar que la fecha de matriculación es anterior a la actual
     * @param fecha: fecha de matriculación del vehículo
     * @return:<code>true</code>si la fecha es anterior a la actual;<code>false</code>si no lo es.
     */
    public static boolean validarFecha (LocalDate fecha){
        
        boolean validarFecha;
        
        LocalDate hoy=LocalDate.now();
        
        if (fecha.isAfter(hoy)){
            
            validarFecha=false;
        
            System.out.println("Fecha incorrecta");
        
        }else {
                validarFecha=true;     
        }
                      
        return validarFecha;
    }
    
//VALIDACIÓN DEL DNI:
    
    /**
     * Método que obtiene la letra del dni introducido
     * @return letra del dni
     */
    public static char getLetraDNI () {

        char letra=numDni.charAt(numDni.length()-1);

        return letra;
    }     
    
    // variable necesaria para calcular la letra del dni. Es de tipo private y final pues no debe de cambiar.
    private static final String LETRAS_DNI= "TRWAGMYFPDXBNJZSQVHLCKE";
    
    /**
     * Método que substrae los números del dni para calcular cual tiene que ser su letra válida.
     * @return letra válida del dni
     */
    private static char calcularLetraDNI () {

        char letra;

        int numsDni=Integer.parseInt(Vehiculo.numDni.substring(0, Vehiculo.numDni.length()-1));
       
        letra= LETRAS_DNI.charAt(numsDni % 23);   

        return letra;
    }

    /**
     * Método para validar el dni. Compara la letra substraida del dni, con la 
     * letra que se ha calculado que debe de ser la correcta en los métodos anteriores.
     * @param numDni: dni del propietario recibido para validarlo 
     * @return: <code> true</code> si el dni es válido; <code>false</code> si no lo es.  
     */    
    public static boolean validarDNI (String numDni){
        
        boolean valido=true;
        
        char letra_calculada;
        
        char letra_leida;
        
        if (Vehiculo.numDni == null) { //si no se introduce nada, no es válido
            
            valido=false;
            
        }
        
        else if(Vehiculo.numDni.length() !=9){//si el tamaño del dni es inferior a 9 carácteres, no es válido.
            
            valido=false;
            
            System.out.println("Error: no contiene 9 caracteres.");  
        }
            
        else {//si la letra obtenida es igual a la calculada, el dni es válido
            
            letra_leida=Validaciones.getLetraDNI();
            
            letra_calculada=Validaciones.calcularLetraDNI();
            
            if (letra_leida == letra_calculada) {
                
                valido=true;   
            }
            
            else {//si no coinciden las letras, no será válido el dni
                
                valido=false;
                
                System.out.println("Error: letra incorrecta.");
   
            }
            
        }return valido;    
    }
}