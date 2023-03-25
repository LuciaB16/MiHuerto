package huerto;

import huerto.enums.Especie;
import huerto.enums.Familia;

public interface IPlanta {
    String getNombre();
    int getSuperficieRequerida();
    int getVolumenRequerido();

    Familia getFamilia();
    Especie getEspecie();

    boolean esCompatible(IPlanta planta);
    boolean tengoEspacio(IMaceta maceta);
    void plantar(IMaceta maceta);
}
