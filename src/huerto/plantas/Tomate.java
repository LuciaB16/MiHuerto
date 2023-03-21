package huerto.plantas;

import huerto.enums.Especie;

public class Tomate extends PlantaFruto{

    public Tomate(String nombre){
        super(nombre, 30, 18);
        especie = Especie.TOMATE;
        incompatibles.add(Especie.HINOJO);
        compatibles.add(Especie.LECHUGA);
        compatibles.add(Especie.PEREJIL);
        compatibles.add(Especie.ZANAHORIA);
    }

    @Override
    public int getSuperficieRequerid() {
        return 0;
    }
}
