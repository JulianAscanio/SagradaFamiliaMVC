
package modelo;

import control.Controlador;
import vista.FormularioFeligres;

public class Principal {
    public static void main(String[] args) {
        FormularioFeligres formulario = new FormularioFeligres();
        Feligres feligres = new Feligres();
        Controlador control = new Controlador(feligres, formulario);
    }
}
