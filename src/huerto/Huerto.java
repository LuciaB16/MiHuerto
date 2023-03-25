package huerto;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Huerto implements IHuerto{
    private String nombre;
    private Set<IMaceta> macetas;

    public Huerto(String nombre){
        this.nombre = nombre;
        macetas = new HashSet<>();
    }

    @Override
    public void addMaceta(IMaceta maceta) {
        macetas.add(maceta);
    }

    @Override
    public IMaceta plantar(IPlanta planta) {
        for(IMaceta maceta : macetas){
            if(maceta.plantar(planta)) return maceta;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre + "\n");
        for(IMaceta maceta : macetas){
            sb.append("\t" + maceta + "\n");
        }
        return sb.toString();
    }


    public void escribir(File fichero){
        FileWriter ou = null;
        PrintWriter fich = null;
        try {
             ou = new FileWriter(fichero);
             fich =new PrintWriter(ou);
        }catch (Exception e){
            System.out.println("Error escr" + e.getMessage());
        }finally {
            fich.close();
        }
    }

}
