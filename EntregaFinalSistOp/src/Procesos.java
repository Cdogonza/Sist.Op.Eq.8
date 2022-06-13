
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gpaz1
 */
public class Procesos {
    
    static int numeroProceso= 0;
    
    int rafagaDeCpu =0;
    boolean bloqueoPorEntradaSalida=false;
    
    static ArrayList<String> listaProcesos = new ArrayList<String>();
    
    public Procesos(int RafagaDeCpu,int tipoBloqueo){
        numeroProceso++;
        listaProcesos.add(String.valueOf(numeroProceso));
        this.rafagaDeCpu = RafagaDeCpu;       
         if(tipoBloqueo ==1){
            bloqueoPorEntradaSalida = true;
        }
    } 
    public void setRafagaDeCpu(int rafagaDeCpu) {
        this.rafagaDeCpu = rafagaDeCpu;
    }

    public void setBloqueoPorEntradaSalida(boolean bloqueoPorEntradaSalida) {
        this.bloqueoPorEntradaSalida = bloqueoPorEntradaSalida;
    }

    public int getNumeroProceso() {
        return numeroProceso;
    }

    public int getRafagaDeCpu() {
        return rafagaDeCpu;
    }

    public boolean isBloqueoPorEntradaSalida() {
        return bloqueoPorEntradaSalida;
    }

    public ArrayList<String> getListaProcesos() {
        return listaProcesos;
    }

    

    
    
}
