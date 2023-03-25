package huerto.plantas;

import huerto.enums.Especie;

public class Mango extends PlantaFruto{

    public Mango(String nombre){
        super(nombre, 30, 18);
        especie = Especie.MANGO;
        compatibles.add(Especie.TOMATE);
        incompatibles.add(Especie.LECHUGA);
        incompatibles.add(Especie.ZANAHORIA);
    }

}
