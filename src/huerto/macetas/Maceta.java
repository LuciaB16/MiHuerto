package huerto.macetas;

import huerto.IMaceta;
import huerto.IPlanta;

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
    public int superficieDisponible() {
        return getSuperficie() - superficieOcupada();
    }

    public int superficieOcupada() {
        int res = 0;
        for (IPlanta p : plantas) {
            res += p.getSuperficieRequerid();
        }
        return res;
    }

    @Override
    public int getProfundidad() {
        return alto;
    }

    @Override
    public int volumenDisponible() {
        return getVolumen() - volumenOcupado();
    }

    public int volumenOcupado() {
        int res = 0;
        for (IPlanta p : plantas) {
            res += p.getVolumenRequerido();
        }
        return res;
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
        return plantas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Maceta " + nombre + "{" + getForma() +
                "} (sup " + getSuperficie() + "cm2 - vo1 " + getVolumen() + "cm3).\n");
        if (plantas.isEmpty()) {
            sb.append("\t\tvacia\n");
        }
        for (IPlanta p : plantas) {
            sb.append("\t\t" + p + "\n");
        }
        sb.append("\t\t>> Disponible sup " + superficieDisponible() + "cm2 - vo1 " + volumenDisponible() + "cm3");
        return sb.toString();
    }
}