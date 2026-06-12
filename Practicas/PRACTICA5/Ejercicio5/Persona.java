package Practicas.PRACTICA5.Ejercicio5;

public class Persona {
    private String categoria;
    private String nombre;
    private String domicilio;
    private boolean cobro;

    public boolean esEmpleado(){
        if (this.categoria == "Empleado"){
            return true;
        }else{
            return false;
        }
    }

    public boolean esJubilado(){
        if (this.categoria == "Jubilado"){
            return true;
        }else{
            return false;
        }
    }

    public boolean percibioPago(){
        return this.cobro;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDomicilio(){
        return this.domicilio;
    }
}
