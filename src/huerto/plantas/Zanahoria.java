package huerto.plantas;

import huerto.enums.Especie;

public class Zanahoria extends PlantaRaiz{

    public Zanahoria(String nombre){
        super(nombre, 20, 3, 25);
        especie = Especie.ZANAHORIA;
        incompatibles.add(Especie.TOMATE);
        incompatibles.add(Especie.LECHUGA);
    }
}
