package huerto.macetas;

import com.sun.security.jgss.GSSUtil;
import huerto.IMaceta;
import huerto.IPlanta;
import huerto.enums.FormaMaceta;

import java.util.HashSet;
import java.util.Set;

public abstract class Maceta implements IMaceta {
    private String nombre;
    private int alto;
    private Set<IPlanta> plantas;

    public Maceta(String nombre, int alto) {
        super();
        this.nombre = nombre;
        this.alto = alto;
        plantas = new HashSet<>();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getVolumen() {
        return alto * getSuperficie();
    }

    @Override
    public int volumenDisponible() {
        return 0;
    }

    @Override
    public int getSuperficie() {
        return 0;
    }

    @Override
    public int superficieDisponible() {
        return 0;
    }

    @Override
    public int getProfundidad() {
        return alto;
    }

    @Override
    public FormaMaceta getForma() {
        return null;
    }

    @Override
    public boolean plantar(IPlanta planta) {
        System.out.println("---PLANTANDO " + planta.getNombre() + " EN " + this.getNombre());

        boolean compatiblesOk = true;
        for(IPlanta p : plantas){
            boolean compatibleOk = planta.esCompatible(p);
            if (!compatiblesOk){
                System.out.println("--- " + p.getNombre() + " no es compatuble con " + planta.getNombre());
            }
            compatibleOk &= compatiblesOk;
        }
        boolean cabe = false;
        if(compatiblesOk){
            cabe = planta.tengoEspacio(this);
        }
        if(cabe){
            plantas.add(planta);
            planta.plantar(this);
        }
        return cabe;
    }

    @Override
    public Set<IPlanta> getPlantas() {
        return null;
    }
}
