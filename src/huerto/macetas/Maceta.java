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
        this.nombre = nombre;
        this.alto = alto;
        plantas = new HashSet<>(); //inicializar conjunto de plantas
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getVolumen() {
        return alto * getSuperficie();
    }

    public int superficieOcupada() {
        int acu = 0;
        for (IPlanta p : plantas) {
            acu += p.getSuperficieRequerida();
        }
        return acu;
    }

    @Override
    public int superficieDisponible() {
        return getSuperficie() - superficieOcupada();
    }

   @Override
    public int getProfundidad() {
        return alto;
    }


    public int volumenOcupado() {
        int acu = 0;
        for (IPlanta p : plantas) {
            acu += p.getVolumenRequerido();
        }
        return acu;
    }

    @Override
    public int volumenDisponible() {
        return getVolumen() - volumenOcupado();
    }

    @Override
    public boolean plantar(IPlanta planta) {
        System.out.println("---Plantando " + planta.getNombre() + " en " + this.getNombre());

        boolean compatiblesOk = true;

        for(IPlanta p : plantas) {
            boolean compatibleOk = planta.esCompatible(p);
            if (!compatiblesOk) {
                System.out.println("-- " + p.getNombre() + " no es compatible con " + planta.getNombre());
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
        StringBuilder sb = new StringBuilder("Maceta: " + nombre + ", tipo: " + getForma() +
                " [superficie = " + getSuperficie() + " cm2 y volumen = " + getVolumen() + " cm3]\n");
        if (plantas.isEmpty()) {
            sb.append("\t\tEsta maceta está vacía -> ");
        }
        for (IPlanta p : plantas) {
            sb.append("\t\t" + p + "\n");
        }
        sb.append("Disponible: superficie " + superficieDisponible() + "cm2 y volumen " + volumenDisponible() + "cm3.\n");
        return sb.toString();
    }
}