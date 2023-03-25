package huerto;


import com.Lucia.datos.PedirDatos;
import huerto.macetas.MacetaRectangular;
import huerto.macetas.MacetaTubular;
import huerto.macetas.Maceta;
import huerto.plantas.*;

import javax.crypto.Mac;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUM_ZANAHORIAS = 5;

    public static void main(String[] args) throws IOException {
        /*
        Huerto miHuerto = new Huerto(PedirDatos.pedirString("Nombre de tu huerto: "));
        File f = new File("huerto.txt");
        miHuerto.escribir(f);
        try {
            int numeroMacetas = PedirDatos.pedirInt("Cuantas macetas");
            for (int i = 0; i < numeroMacetas; i++) {
                int tipoMaceta = PedirDatos.pedirInt("Tipo de maceta: \n 1. Tubular\n 2. Rectangular");
                switch (tipoMaceta) {
                    case 1:
                        Maceta tubular = new MacetaTubular(PedirDatos.pedirString("Nombre de la maceta: "), PedirDatos.pedirInt("Alto: "), PedirDatos.pedirInt("Diametro: "));
                        miHuerto.addMaceta(tubular);
                        System.out.println(miHuerto);
                        int planta = PedirDatos.pedirInt("Planta que quieres en esta maceta\n1.tomate\n2.zanahoria\n3.lechuga\n4.mango");
                        switch (planta){
                            case 1:
                                IPlanta tomate = new Tomate(PedirDatos.pedirString("nombre tomate: "));
                                miHuerto.plantar(tomate);
                                break;
                            case 2:
                                IPlanta zanahoria = new Zanahoria(PedirDatos.pedirString("nombre zana: "));
                                miHuerto.plantar(zanahoria);
                                break;
                            case 3:
                                IPlanta lechuga = new Lechuga(PedirDatos.pedirString("nombre lechu: "));
                                miHuerto.plantar(lechuga);
                                break;
                            case 4:
                                IPlanta mango = new Mango(PedirDatos.pedirString("nombre mango: "));
                                miHuerto.plantar(mango);
                                break;
                            default:
                                System.out.println("error");
                                break;
                        }
                        break;
                    case 2:
                        Maceta rectangular = new MacetaRectangular(PedirDatos.pedirString("Nombre de la maceta: "), PedirDatos.pedirInt("Alto: "), PedirDatos.pedirInt("Ancho: "), PedirDatos.pedirInt("Largo: "));
                        miHuerto.addMaceta(rectangular);
                        int planta1 = PedirDatos.pedirInt("Planta que quieres en esta maceta:\n1.tomate\n2.zanahoria\n3.lechuga\n4.mango");
                        switch (planta1){
                            case 1:
                                IPlanta tomate = new Tomate(PedirDatos.pedirString("nombre tomate: "));
                                miHuerto.plantar(tomate);
                                break;
                            case 2:
                                IPlanta zanahoria = new Zanahoria(PedirDatos.pedirString("nombre zana: "));
                                miHuerto.plantar(zanahoria);
                                break;
                            case 3:
                                IPlanta lechuga = new Lechuga(PedirDatos.pedirString("nombre lechu: "));
                                miHuerto.plantar(lechuga);
                                break;
                            case 4:
                                IPlanta mango = new Mango(PedirDatos.pedirString("nombre mango: "));
                                miHuerto.plantar(mango);
                                break;
                            default:
                                System.out.println("error");
                                break;
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta, vuelva a intentarlo");
                        break;
                }
            }
            System.out.println(miHuerto);
        }catch (Exception ex){
            System.out.println("Caracter no valido" + ex.getMessage());
        }
        */
        /*
        IPlanta tomatitos = new Tomate("tomatitos");
        IPlanta zanahoria = new Zanahoria("larguita");
        List<Zanahoria> zanahorias = new ArrayList<>();
        for(int i=0; i<NUM_ZANAHORIAS;i++){
            Zanahoria z = new Zanahoria("z" + i);
            zanahorias.add(z);
        }

        IMaceta macetaTomatitos = miHuerto.plantar(tomatitos);
        pintaResultadoPlantar(tomatitos,macetaTomatitos);
        IMaceta macetaZanahoria = miHuerto.plantar(zanahoria);
        pintaResultadoPlantar(zanahoria,macetaZanahoria);

        for(Zanahoria z : zanahorias){
            IMaceta macetaZ = miHuerto.plantar(z);
            pintaResultadoPlantar(z,macetaZ);
        }
        */

        //System.out.println(miHuerto + " con muchas plantas");

        //Huerto miHuerto = new Huerto("Mi primer huerto: ");
        Huerto miHuerto = new Huerto(PedirDatos.pedirString("Dame un nombre para tu huerto: "));
        int numeroMacetas = PedirDatos.pedirInt("¿Cuántas macetas quieres tener en tu huerto?");

        for (int i = 0; i < numeroMacetas; i++) {
                int tipoMaceta = PedirDatos.pedirInt("¿De qué tipo quieres la maceta?\n1. Rectangular\n2. Tubular");
                String nombreMaceta = PedirDatos.pedirString("Nombre de la maceta: ");
                int altoMaceta = PedirDatos.pedirInt("Alto de la maceta: ");

                if (tipoMaceta == 1) {
                    int anchoMaceta = PedirDatos.pedirInt("Ancho de la maceta: ");
                    int largoMaceta = PedirDatos.pedirInt("Largo de la maceta: ");
                    Maceta maceta1 = new MacetaRectangular(nombreMaceta, altoMaceta, anchoMaceta, largoMaceta);
                    miHuerto.addMaceta(maceta1);

                    int tipoPlanta = PedirDatos.pedirInt("¿Qué tipo de planta quieres en esta maceta?" +
                            "\n1. Tomates\n2. Mangos\n3. Lechugas\n4. Zanahorias");

                    switch (tipoPlanta){
                        case 1:
                            int numTomates = PedirDatos.pedirInt("¿Cuántos tomates quieres?");
                            List<Tomate> tomates = new ArrayList<>();
                            for(int j=0; j<numTomates;j++){
                                Tomate tomate = new Tomate("Tomate" + j);
                                tomates.add(tomate);
                            }
                            for(Tomate t : tomates){
                                IMaceta macetaT = miHuerto.plantar(t);
                                amosar(t,macetaT);
                            }
                            break;

                        case 2:
                            int numMangos = PedirDatos.pedirInt("¿Cuántos mangos quieres?");
                            List<Mango> mangos = new ArrayList<>();
                            for(int j=0; j<numMangos;j++){
                                Mango mango = new Mango("Mango" + j);
                                mangos.add(mango);
                            }
                            for(Mango m : mangos){
                                IMaceta macetaM = miHuerto.plantar(m);
                                amosar(m,macetaM);
                            }
                            break;

                        case 3:
                            int numLechugas = PedirDatos.pedirInt("¿Cuántas lechugas quieres?");
                            List<Lechuga> lechugas = new ArrayList<>();
                            for(int j=0; j<numLechugas;j++){
                                Lechuga lechuga = new Lechuga("Lechuga" + j);
                                lechugas.add(lechuga);
                            }
                            for(Lechuga l : lechugas){
                                IMaceta macetaL = miHuerto.plantar(l);
                                amosar(l,macetaL);
                            }
                            break;

                        case 4:
                            int numZanahorias = PedirDatos.pedirInt("¿Cuántas zanahorias quieres?");
                            List<Zanahoria> zanahorias = new ArrayList<>();
                            for(int j=0; j<numZanahorias;j++){
                                Zanahoria zanahoria = new Zanahoria("Zanahoria" + j);
                                zanahorias.add(zanahoria);
                            }
                            for(Zanahoria z : zanahorias){
                                IMaceta macetaZ = miHuerto.plantar(z);
                                amosar(z,macetaZ);
                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null,"Opción incorrecta");
                            break;
                    }
                }
                if (tipoMaceta == 2) {
                    int diametroMaceta = PedirDatos.pedirInt("Diámetro de la maceta: ");
                    Maceta maceta2 = new MacetaTubular(nombreMaceta, altoMaceta, diametroMaceta);
                    miHuerto.addMaceta(maceta2);
                }
        }
        //System.out.println(miHuerto);

        System.out.println(miHuerto + " con muchas plantas");


        File f =new File("huerto.txt");
        FileWriter writer = new FileWriter(f);
        writer.write(String.valueOf(miHuerto));
        writer.close();
        //Maceta cuadrada = new MacetaRectangular("Cuadradita", 20, 20, 20);
        //Maceta botella = new MacetaTubular("Botella", 25, 15);
        //Maceta maceton = new MacetaTubular("Maceton", 40, 40);
        //miHuerto.addMaceta(cuadrada);
        //miHuerto.addMaceta(botella);
        //miHuerto.addMaceta(maceton);

        //System.out.println(miHuerto);
        /*
        IPlanta tomatitos = new Tomate("tomatitos");
        IPlanta zanahoria = new Zanahoria("larguita");
        List<Zanahoria> zanahorias = new ArrayList<>();
        for(int i=0; i<NUM_ZANAHORIAS;i++){
            Zanahoria z = new Zanahoria("z" + i);
            zanahorias.add(z);
        }

        IMaceta macetaTomatitos = miHuerto.plantar(tomatitos);
        amosar(tomatitos,macetaTomatitos);
        IMaceta macetaZanahoria = miHuerto.plantar(zanahoria);
        amosar(zanahoria,macetaZanahoria);

        for(Zanahoria z : zanahorias){
            IMaceta macetaZ = miHuerto.plantar(z);
            amosar(z,macetaZ);
        }
        System.out.println(miHuerto + " con muchas plantas");

        File file =new File("huerto.txt");
        FileWriter writer = new FileWriter(file);
        writer.write(String.valueOf(miHuerto));
        writer.close();

         */
    }

    private static void amosar(IPlanta planta, IMaceta maceta){
        if(maceta != null){
            System.out.println("He plantado " + planta.getNombre() + " en " + maceta.getNombre());
        }
        else{
            System.out.println("No he podido plantar " + planta.getNombre());
        }
    }
}