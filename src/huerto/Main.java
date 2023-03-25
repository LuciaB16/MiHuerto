package huerto;


import com.sandra.datos.PedirDatos;
import huerto.macetas.MacetaRectangular;
import huerto.macetas.MacetaTubular;
import huerto.macetas.Maceta;
import huerto.plantas.*;

import javax.crypto.Mac;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

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
                    switch (tipoMaceta){
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
        }
        System.out.println(miHuerto + " con muchas plantas");

        File f =new File("huerto.txt");
        FileWriter writer = new FileWriter(f);
        try {
            writer.write(String.valueOf(miHuerto));
        }catch (ExportException e){
            System.out.println("Error al escribir fichero" + e.getMessage());
        }
        finally {
            writer.close();
        }
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