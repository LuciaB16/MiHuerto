package huerto;

import com.sandra.datos.PedirDatos;
import huerto.macetas.MacetaRectangular;
import huerto.macetas.MacetaTubular;
import huerto.macetas.Maceta;
import huerto.plantas.*;

import javax.crypto.Mac;
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
            int tipoMaceta = PedirDatos.pedirInt("¿De qué tipo quieres la maceta?\n1.Rectangular\n2.Tubular");
            do {
                String nombreMaceta = PedirDatos.pedirString("Nombre de la maceta: ");
                int altoMaceta = PedirDatos.pedirInt("Alto de la maceta: ");
                if (tipoMaceta == 1) {
                    int anchoMaceta = PedirDatos.pedirInt("Ancho de la maceta: ");
                    int largoMaceta = PedirDatos.pedirInt("Alto de la maceta: ");
                    Maceta maceta1 = new MacetaRectangular(nombreMaceta, altoMaceta, anchoMaceta, altoMaceta);
                    miHuerto.addMaceta(maceta1);
                }
                if (tipoMaceta == 2) {
                    int diametroMaceta = PedirDatos.pedirInt("Diametro de la maceta: ");
                    Maceta maceta2 = new MacetaTubular(nombreMaceta, altoMaceta, diametroMaceta);
                    miHuerto.addMaceta(maceta2);
                }
            }while(tipoMaceta != 1 && tipoMaceta != 2);
        }

        //Maceta cuadrada = new MacetaRectangular("Cuadradita", 20, 20, 20);
        //Maceta botella = new MacetaTubular("Botella", 25, 15);
        //Maceta maceton = new MacetaTubular("Maceton", 40, 40);
        //miHuerto.addMaceta(cuadrada);
        //miHuerto.addMaceta(botella);
        //miHuerto.addMaceta(maceton);

        System.out.println(miHuerto);
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