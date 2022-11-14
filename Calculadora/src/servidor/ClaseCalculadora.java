package servidor;

import java.rmi.RemoteException;

public class ClaseCalculadora implements InterfaceCalculadora {
    String expresionActual = "0";
    String expresionActuald = "0";
    int primeraExpresion = 0;
    int segundaExpresion = 0;
    int operacionPorRealizar = 0;
    int operacionPorRealizar2 =0;
    int popote =primeraExpresion;
    int gustia =0;

    @Override
    public void agregarNumero(int numero) {
        if (expresionActual == "0") {
            expresionActual = "";
        }
        if (expresionActual.length() < 10) {
            expresionActual = expresionActual + String.valueOf(numero);
        }
    }
    
    public void agregarNumm(int numero){
        if (expresionActuald == "0") {
            expresionActuald = "";
        }
        if (expresionActuald.length() < 10) {
            expresionActuald = expresionActuald + String.valueOf(numero);
        }
    }
    public void envi(int numero){
        segundaExpresion = Integer.valueOf(expresionActuald);
        expresionActuald="0";
        //operacionPorRealizar= operacion;
    }
    @Override
    public void agregarOperacion(int operacion) {
        primeraExpresion = Integer.valueOf(expresionActual);
        popote = primeraExpresion;
        expresionActual = "0";
        operacionPorRealizar = operacion;
    }

    @Override
    public void realizarOperacion() {
        segundaExpresion = Integer.valueOf(expresionActuald);
//        popote = segundaExpresion;
//        gustia = primeraExpresion;
        switch (operacionPorRealizar) {
            case 1:
                //expresionActual = String.valueOf(primeraExpresion + segundaExpresion);
                expresionActual = String.valueOf(popote+segundaExpresion);
                break;

            case 2:
                expresionActual = String.valueOf(primeraExpresion - segundaExpresion);
                break;
        
            case 3:
                expresionActual = String.valueOf(primeraExpresion * segundaExpresion);
                break;

            case 4:
                expresionActual = String.valueOf(primeraExpresion / segundaExpresion);
                break;

            default:
                break;
        }
    
        primeraExpresion = 0;
        segundaExpresion = 0;
        operacionPorRealizar = 0;
    }

    @Override
    public void limpiar() throws RemoteException {
        primeraExpresion = 0;
        segundaExpresion = 0;
        operacionPorRealizar = 0;
        expresionActual = "0";
        
    }

    @Override
    public String recuperarDatos() throws RemoteException {
        return expresionActual;
    }
    
    public String recp() throws RemoteException{
      return expresionActuald;
        
    }

    @Override
    public void clean() throws RemoteException {
        segundaExpresion = 0;
        operacionPorRealizar2 = 0;
        expresionActuald ="0";
    }

    @Override
    public void realizarOperacion2() throws RemoteException {
            // segundaExpresion=Integer.valueOf(primeraExpresion);
             primeraExpresion = Integer.valueOf(popote);
            // popote = segundaExpresion;
             //gustia = primeraExpresion;

        switch (operacionPorRealizar2) {
            case 1:
                expresionActuald = String.valueOf(primeraExpresion + segundaExpresion);
                break;

            case 2:
                expresionActuald = String.valueOf(primeraExpresion - segundaExpresion);
                break;
        
            case 3:
                expresionActuald = String.valueOf(primeraExpresion * segundaExpresion);
                break;

            case 4:
                expresionActuald = String.valueOf(primeraExpresion / segundaExpresion);
                break;

            default:
                break;
        }

        primeraExpresion = 0;
        segundaExpresion = 0;
        operacionPorRealizar2 = 0;
    }

    @Override
    public void agregarOperacion2(int operacionc) throws RemoteException {
        segundaExpresion = Integer.valueOf(expresionActuald);
        expresionActuald = "0";
        operacionPorRealizar2 = operacionc;
    }

 

}