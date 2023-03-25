package huerto.plantas;

import huerto.IMaceta;
import huerto.enums.Familia;

public abstract class PlantaRaiz extends Planta{
    private int profundidadRequerida;

    protected PlantaRaiz(String nombre, int distancia, int litros, int profundidad){
        super(nombre, distancia, litros);
        profundidadRequerida = profundidad;
        familia = Familia.RAIZ;
    }

    public int getProfundidadRequerida(){
        return profundidadRequerida;
    }

    public void setProfundidadRequerida(int profundidadRequerida){
        this.profundidadRequerida = profundidadRequerida;
    }

    @Override
    public boolean tengoEspacio(IMaceta maceta) {
        boolean profundidadOk = maceta.getProfundidad() > profundidadRequerida;
        if(!profundidadOk){
            System.out.println("--- Profundidad insuficiente para " + getNombre() + " en " + maceta.getNombre());
        }
        return super.tengoEspacio(maceta) && profundidadOk;
    }
}
