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
        Feligres diezmo;
        try {
            if (!event.getActionCommand().contentEquals("Guardar")) {

                if (event.getActionCommand().contentEquals("Mostar Datos")) {
                } else if (event.getActionCommand().contentEquals("Pagar Diezmo")) {
                    
                    if (feligres.estado.equalsIgnoreCase("Deudor")) {
                        
                        diezmo =Feligres.class.cast(JOptionPane.showInputDialog("Monto a pagar $" + feligres.controlDiezmo() + "\nIngrese su monto a pagar: "));
                        
                        if (!diezmo.equals(feligres.estado)) {
                        } else {
                            feligres.setEstado("Cumplido");
                        }
                    }
                } else if (event.getActionCommand().contentEquals("Limpiar")) {
                    vistaFeligres.txtCedula.setText(" ");
                    vistaFeligres.txtNombre.setText(" ");
                    vistaFeligres.txtDireccion.setText(" ");
                    vistaFeligres.txtTelefono.setText(" ");
                    vistaFeligres.txtEstrato.setText(" ");
                    vistaFeligres.txtEstado.setText(" ");
                    vistaFeligres.txaResultado.setText("");
                } else {
                    this.vistaFeligres.txaResultado.setText("Cedula : " + vistaFeligres.txtCedula.getText() + "\nNombre: " + feligres.getNombre()
                            + "\nDireccion: " + feligres.getDirecion() + "\nTelefono: " + feligres.getTelefono() + "\nEstrato: " + feligres.getEstrato()
                            + "\nEstado: " + feligres.getEstado());
                }
            } else {
                int estrato = Integer.parseInt(this.vistaFeligres.txtEstrato.getText());

                feligres.setCedula(this.vistaFeligres.txtCedula.getText());
                feligres.setNombre(this.vistaFeligres.txtNombre.getText());
                feligres.setDirecion(this.vistaFeligres.txtDireccion.getText());
                feligres.setTelefono(this.vistaFeligres.txtTelefono.getText());
                feligres.setEstrato(estrato);
                feligres.setEstado(this.vistaFeligres.txtEstado.getText());
                System.out.println("Se guardaron los datos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salio mal");
        }
    }

}
