package huerto;

import huerto.macetas.MacetaRectangular;
import huerto.macetas.MacetaTubular;
import huerto.macetas.Maceta;
import huerto.plantas.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int NUM_ZANAHORIAS = 5;
    public static void main(String[] args) {
        Huerto miHuerto = new Huerto("Mi primer huerto");
        Maceta cuadrada = new MacetaRectangular("Cuadrada", 20, 20, 20);
        Maceta botella = new MacetaTubular("Botella", 25,15);
        Maceta maceton = new MacetaTubular("Maceton", 40, 40);
        miHuerto.addMaceta(cuadrada);
        miHuerto.addMaceta(botella);
        miHuerto.addMaceta(maceton);

        System.out.println("Mi huerto nuevito: " + miHuerto);

        IPlanta tomatitos = new Tomate("tomatitos");
        IPlanta acelga = new Lechuga("hojas verdes");
        IPlanta zanahoria = new Zanahoria("larguita");
        IPlanta perejil = new Perejil("verdito");
        IPlanta hinojo = new Hinojo("hijo sin ojo");
        List<Zanahoria> zanahorias = new ArrayList<>();
        for(int i=0; i<NUM_ZANAHORIAS;i++){
            Zanahoria z = new Zanahoria("z" + i);
            zanahorias.add(z);
        }

        IMaceta macetaTomatitos = miHuerto.plantar(tomatitos);
        //pintaResultadoPlantar(tomatitos,macetaTomatitos);
        IMaceta macetaAcelga = miHuerto.plantar(acelga);
        //pintaResultadoPlantar(acelga,macetaAcelga);
        IMaceta macetaZanahoria = miHuerto.plantar(zanahoria);
        //pintaResultadoPlantar(zanahoria,macetaZanahoria);
        IMaceta macetaPerejil = miHuerto.plantar(perejil);
        //pintaResultadoPlantar(perejil,macetaPerejil);
        IMaceta macetaHinojo = miHuerto.plantar(hinojo);
        //pintaResultadoPlantar(hinojo,macetaHinojo);
        for(Zanahoria z : zanahorias){
            IMaceta macetaZ = miHuerto.plantar(z);
            //pintaResultadoPlantar(z,macetaZ);
        }
        System.out.println("Mi huerto con muchas plantas: " + miHuerto);
    }

    private static void pintaResultadoPlantar(IPlanta planta, IMaceta maceta){
        if(maceta != null){
            System.out.println("He plantado " + planta.getNombre() + " en " + maceta.getNombre());
        }
        else{
            System.out.println("No he podido plantar " + planta.getNombre());
        }
    }
}