package huerto.plantas;

import huerto.enums.Especie;

public class Tomate extends PlantaFruto{

    public Tomate(String nombre){
        super(nombre, 30, 18);
        especie = Especie.TOMATE;
        compatibles.add(Especie.MANGO);
        compatibles.add(Especie.LECHUGA);
        incompatibles.add(Especie.ZANAHORIA);
    }
}
