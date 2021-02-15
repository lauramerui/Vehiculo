/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG05_Ejerc1;

import PROG05_Ejerc1_util.Validaciones;
import java.time.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *Clase principal del programa. Genera un menú que permite crear un vehículo 
 * añadiendo todos sus datos para posteriormente poder consultarlos.
 * Estos datos se validarán para que sean correctos en el momento de su entrada.
 * @author Laura
 */
public class Principal {
    
    public static void main(String[] args){
        
        //declaración de la variable menu para usarla en el posterior swith
        int menu;
        
        /*creación del objeto v1. Instancia de la clase Vehiculo. Se usa el constructor
        iniciando los parámetros a sus valores por defecto*/
        
        var v1= new Vehiculo(null, null, 0, 1, 1, 1, 0.0d, null, null, null);
        
        /*la estructura se inserta en un bucle do-while para volver al menú cada 
        vez que sea necesario*/
        do{
            
            /*Se muestra el menú para seleccionar lo que se desee, el valor se 
            introduce por teclado con la clase Scanner*/
            System.out.println("Menú \nSeleccione una opción: \n1.Nuevo Vehiculo. "
                + "\n2.Ver Matrícula. \n3.Ver Número de Kilómetros. \n4.Actualizar Kilómetros."
                + "\n5.Ver años de antigüedad. \n6.Mostrar propietario. \n7.Mostrar descripción."
                + "\n8.Mostrar Precio. \n9.Salir.");
    
            Scanner entrada=new Scanner(System.in);
        
            menu=entrada.nextInt();
        
            entrada.nextLine();
            
            
            switch(menu){//Comienzo de la estructura switch, con 9 posibilidades de ejecución
            
                case 1: //Se pedirá por pantalla cada atributo del vehículo mediante los métodos set
                    
                    System.out.println("Introduce la marca");
                
                    v1.setMarca(entrada.nextLine());
                    
                                
                    System.out.println("Introduce la matricula");
                
                    v1.setMatricula(entrada.nextLine());
                    
                    
                    System.out.println("Introduce número de kilómetros");                    
                                       
                    v1.setNumKilom(entrada.nextInt()); 
                
                    entrada.nextLine();
                    
                    if (Validaciones.validarKilom(v1.numKilom)==false){//si el valor no es válido (menor de 0) se vuelve al menú

                        break;
                    }
                
                    
                    System.out.println("Introduce fecha de matriculación");
                
                    System.out.println("Dia:");
                
                    v1.setDia(entrada.nextInt());
                
                    entrada.nextLine();
                
                    System.out.println("Mes:");
                
                    v1.setMes(entrada.nextInt());
                
                    entrada.nextLine();
                
                    System.out.println("Año:");
                
                    v1.setAnio(entrada.nextInt());
                
                    entrada.nextLine();
                
                    v1.fecha=LocalDate.of(v1.anio, v1.mes, v1.dia);//se guarda la fecha en LocalDate para poder usarla correctamente
                
                    if (Validaciones.validarFecha(v1.fecha)==false){ //si no es válida (fecha anterior a la actual) se vuelve al menú
                        
                        break;
                    }
                    
                    
                    System.out.println("Introduce la descripción del vehículo");
                
                    v1.setDescripcion(entrada.nextLine());
                
                    
                    System.out.println("Introduce el precio");
                    
                    //se captura la excepción generada si no se introducen números para que lance un mensaje en lugar de un error.
                    try{
                        
                        v1.setPrecio(entrada.nextDouble());
                    
                        entrada.nextLine();
                        
                    }catch(InputMismatchException e){
                    
                        System.out.println("Error: formato inválido.");
                    
                        break;
                    }
                     
                    
                    System.out.println("Introduce el nombre del propietario del vehículo:0");
                
                    v1.setNomPropietario(entrada.nextLine());
                      
                    
                    System.out.println("Introduce el DNI del propietario");
                   
                    v1.setNumDni(entrada.nextLine());
                   
                    Validaciones.validarDNI(Vehiculo.numDni);//si no es válido el DNI se vuelve al menú                             

                    break;
                      
                case 2: 
                /*en cada uno de los case se obtiene el valor correspondiente, además todos
                    incluyen una condicional if para que dé un mensaje de error y vuelva el menú
                    en el caso de que aún no se haya creado un vehículo (es decir sus valores sean
                    los que tienen por defecto)*/    
                    
                    if (v1.matricula==null){
                        
                        System.out.println("Error: Aún no ha creado un vehículo.");
                                
                        break;
                    }
                    
                    System.out.println("El número de matrícula es " + v1.getMatricula());
                
                    break;
            
                case 3:
                    
                    if (v1.numKilom==0){
                        
                        System.out.println("Error: Aún no ha creado un vehículo.");
                                
                        break;
                    }                    
                    
                    System.out.println("El número de kilómetros es " + v1.getNumKilom());
        
                    break;
                
                case 4: 
                
                    if (v1.numKilom==0){
                        
                        System.out.println("Error: Aún no ha creado un vehículo.");
                                
                        break;
                    }
                    
                    System.out.println("Introduzca los kilómetros actualizados de su coche");
                    
                    /*no se permitirá incluir un dato inferior al anterior, para ello 
                    se crea un nuevo atributo y con una condicional se le ordena que 
                    si es un valor menor lance un mensaje de error*/
                    int kilomAct;
                    
                    kilomAct=entrada.nextInt();
                        
                    if (kilomAct < v1.numKilom ){
                        
                        System.out.println("Valor incorrecto");
                        
                        break;
                        
                    }else{
                    
                        v1.setNumKilom(kilomAct);
                        
                    System.out.println("Actualizado con exito, el coche tiene " + v1.numKilom + " kilómetros.");
                    
                    break;}
                
                case 5:
                    
                    if (v1.dia==1 && v1.mes==1 && v1.anio==1){
                        
                        System.out.println("Error: Aún no ha creado un vehículo.");
                                
                        break;
                    }  
                    
                    System.out.println("La antigüedad del coche es de: " + v1.get_Anios() + " años.");
                
                    break;
                
                case 6:
                    
                    if (v1.nomPropietario==null){
                        
                        System.out.println("Error: Aún no ha creado un vehículo.");
                                
                        break;
                    }
                   
                    System.out.println("El propietario es " + v1.getNomPropietario() + " con DNI " + v1.getNumDni());
                
                    break;
                
                case 7:
                    
                     if (v1.descripcion==null){
                        
                        System.out.println("Error: Aún no ha creado un vehículo.");
                                
                        break;
                    }
                     
                    System.out.println("La descripción del vehículo es: " + v1.getDescripcion());
                        
                    break;
                
                case 8:
                    if (v1.matricula==null){
                        
                        System.out.println("Error: Aún no ha creado un vehículo.");
                                
                        break;
                    }                
                    System.out.println("El precio del coche es " + v1.getPrecio());
                
                    break;
            
                case 9:
                
                    System.out.println("Programa finalizado");        
            }
              
        }while(menu!=9);       
    }
}