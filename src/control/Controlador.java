package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Feligres;
import vista.FormularioFeligres;

public class Controlador implements ActionListener {

    private Feligres feligres = null;
    private FormularioFeligres vistaFeligres = null;

    public Controlador(Feligres feligres, FormularioFeligres vistaFeligres) {
        super();
        this.feligres = feligres;
        this.vistaFeligres = vistaFeligres;
        actionListener(this);
    }

    private void actionListener(ActionListener controlador) {
        this.vistaFeligres.btnGuardar.addActionListener(controlador);
        this.vistaFeligres.btnMostrar.addActionListener(controlador);
        this.vistaFeligres.btnPagar.addActionListener(controlador);
        this.vistaFeligres.btnLimpiar.addActionListener(controlador);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        double diezmo;
        try {
            switch (event.getActionCommand()) {
                case "Guardar":
                    String cedula = this.vistaFeligres.txtCedula.getText();
                    String Nombre = this.vistaFeligres.txtNombre.getText();
                    String Direcion = this.vistaFeligres.txtDireccion.getText();
                    String Telefono = this.vistaFeligres.txtTelefono.getText();
                    int estrato = Integer.parseInt(this.vistaFeligres.txtEstrato.getText());
                    String estado = this.vistaFeligres.txtEstado.getText();

                    System.out.println("Se guardaron los datos");

                    feligres.setCedula(cedula);
                    feligres.setNombre(Nombre);
                    feligres.setDirecion(Direcion);
                    feligres.setTelefono(Telefono);
                    feligres.setEstrato(estrato);
                    feligres.setEstado(estado);
                    break;
                case "Pagar Diezmo":

                    if (feligres.getEstado().equalsIgnoreCase("Cumplido")) {
                        JOptionPane.showMessageDialog(null, "Cumple con su Diezmo");
                    } else {

                        diezmo = Double.parseDouble(JOptionPane.showInputDialog("Monto a pagar $" + feligres.controlDiezmo() + "\nIngrese su monto a pagar: "));

                        if (diezmo == feligres.controlDiezmo()) {

                            vistaFeligres.txtEstado.setText("Cumplido");
                        }
                    }
                    break;
                case "Limpiar":
                    vistaFeligres.txtCedula.setText(" ");
                    vistaFeligres.txtNombre.setText(" ");
                    vistaFeligres.txtDireccion.setText(" ");
                    vistaFeligres.txtTelefono.setText(" ");
                    vistaFeligres.txtEstrato.setText(" ");
                    vistaFeligres.txtEstado.setText(" ");
                    vistaFeligres.txaResultado.setText("");
                    break;
                default:
                    if (event.getActionCommand().contentEquals("Mostrar Datos")) {

                        this.vistaFeligres.txaResultado.setText("Cedula : " + feligres.getCedula() + "\nNombre: " + feligres.getNombre()
                                + "\nDireccion: " + feligres.getDirecion() + "\nTelefono: " + feligres.getTelefono() + "\nEstrato: " + feligres.getEstrato()
                                + "\nEstado: " + feligres.getEstado());

                    }
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salio mal");
        }
    }

}
