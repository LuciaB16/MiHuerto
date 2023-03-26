package huerto.plantas;

import huerto.IMaceta;
import huerto.IPlanta;
import huerto.enums.Especie;
import huerto.enums.Familia;

import java.util.HashSet;
import java.util.Set;

public abstract class Planta implements IPlanta {
    protected Especie especie;
    protected Familia familia;
    protected Set<Especie> incompatibles;
    protected Set<Especie> compatibles;

    private String nombre;
    private int superficieRequerida;
    private int volumenRequerido;
    private IMaceta maceta;

    protected Planta(String nombre, int distancia, int litros) {
        this.nombre = nombre;
        superficieRequerida = distancia^2;
        volumenRequerido = litros * 1000;
        incompatibles = new HashSet<>();
        compatibles = new HashSet<>();
    }

    @Override
    public boolean esCompatible(IPlanta planta) {
        boolean compatible = true;
        if(!especie.equals(planta.getEspecie())){ //comprueba que sean de la misma especie
            if(!compatibles.contains(planta.getEspecie())){ //
                compatible &= !familia.equals(planta.getFamilia()); //comprueba si las familias son diferentes
                compatible &= !incompatibles.contains(planta.getEspecie());
            }
        }
        return compatible;
    }

    @Override
    public boolean tengoEspacio(IMaceta maceta) {
        boolean superficieOk = maceta.superficieDisponible() > getSuperficieRequerida();
        if(!superficieOk){
            System.out.println("-- Superficie insuficiente para " + getNombre() + " en la maceta: " + maceta.getNombre());
        }
        boolean volumenOk = maceta.volumenDisponible() > getVolumenRequerido();
        if(!volumenOk){
            System.out.println("-- Volumen insuficiente para " + getNombre() + " en la maceta:" + maceta.getNombre());
        }
        return superficieOk && volumenOk;
    }

    @Override
    public void plantar(IMaceta maceta) {
        this.maceta = maceta;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getSuperficieRequerida(){
        return superficieRequerida;
    }

    public void setSuperficieRequerida(int superficieRequerida){
        this.superficieRequerida = superficieRequerida;
    }

    public int getVolumenRequerido(){
        return volumenRequerido;
    }

    public void setVolumenRequerido(int volumenRequerido){
        this.volumenRequerido = volumenRequerido;
    }

    public Especie getEspecie(){
        return especie;
    }

    public void setEspecie(Especie especie){
        this.especie = especie;
    }

    public Familia getFamilia(){
        return familia;
    }

    public void setFamilia(Familia familia){
        this.familia = familia;
    }

    @Override
    public String toString() {
        return "La planta " + nombre + " tiene las siguientes características:\n\t[especie=" + especie + ", familia=" + familia +
                ", superficieRequerida=" + superficieRequerida + ", volumenRequerido=" + volumenRequerido +
                ", incompatibles=" + incompatibles + (maceta != null ? ", maceta=" + maceta.getNombre() : "") + "]\n";
    }
}
