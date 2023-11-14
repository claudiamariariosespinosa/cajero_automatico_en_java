import javax.swing.*;
import java.awt.*;

public class CajeroAutomatico {

    public static void main(String[] args) {
        double saldo = 1000;

        while (true) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("Bienvenido al Cajero Automático de claudia seleccione  una de las siguientes opciones =)))"));
            panel.add(new JLabel("Saldo actual: $" + saldo));

            String[] options = {"1. Abonar Dinero a la cuenta", "2. Retirar Dinero de la cuenta", "3. Salir"};
            int choice = JOptionPane.showOptionDialog(null,
                    panel,
                    "Cajero Automático",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);

            switch (choice) {
                case 0:
                    panel = new JPanel();
                    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                    panel.add(new JLabel("Ingrese la cantidad a abonar:"));
                    JTextField abonoField = new JTextField(10);
                    panel.add(abonoField);

                    int abonoResult = JOptionPane.showConfirmDialog(null, panel, "Abonar Dinero",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (abonoResult == JOptionPane.OK_OPTION) {
                        try {
                            double cantidadAbono = Double.parseDouble(abonoField.getText());
                            saldo += cantidadAbono;
                            JOptionPane.showMessageDialog(null, "Abono exitoso. Saldo actual: $" + saldo);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida.");
                        }
                    }
                    break;

                case 1:
                    panel = new JPanel();
                    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                    panel.add(new JLabel("Ingrese la cantidad a retirar:"));
                    JTextField retiroField = new JTextField(10);
                    panel.add(retiroField);

                    int retiroResult = JOptionPane.showConfirmDialog(null, panel, "Retirar Dinero",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (retiroResult == JOptionPane.OK_OPTION) {
                        try {
                            double cantidadRetiro = Double.parseDouble(retiroField.getText());
                            if (cantidadRetiro > saldo) {
                                JOptionPane.showMessageDialog(null, "Saldo insuficiente. Por favor, ingrese una cantidad válida.");
                            } else {
                                saldo -= cantidadRetiro;
                                JOptionPane.showMessageDialog(null, "Retiro exitoso. Saldo actual: $" + saldo);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida.");
                        }
                    }
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro cajero automatico =))))");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
            }

            if (choice != 2) {

                continue;
            }

            break;
        }
    }
}