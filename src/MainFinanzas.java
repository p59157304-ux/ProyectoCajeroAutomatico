import javax.swing.JOptionPane;

public class MainFinanzas {
    public static void main(String[] args) {
        Cuenta miCuenta = new Cuenta();

        try {
            JOptionPane.showMessageDialog(null, "BIENVENIDO: Registre su cuenta");
            miCuenta.registrarCuenta();

            String cuentaAcceso = JOptionPane.showInputDialog("INICIO DE SESIÓN\nIngrese su número de cuenta:");
            String pinAcceso = JOptionPane.showInputDialog("Ingrese su PIN:");

            if (miCuenta.getNumeroCuenta().equals(cuentaAcceso) && miCuenta.getPin().equals(pinAcceso)) {
                menuOperaciones(miCuenta);
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas. El programa se cerrará.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro: " + e.getMessage());
        }
    }

    private static void menuOperaciones(Cuenta obj) {
        int op = 0;
        while (op != 4) {
            try {
                String menu = "SISTEMA FINANCIERO\n"
                        + "Usuario: " + obj.getTitular() + "\n\n"
                        + "1. Consultar Saldo\n"
                        + "2. Realizar Depósito\n"
                        + "3. Realizar Retiro\n"
                        + "4. Salir\n\n"
                        + "Seleccione una opción:";

                String input = JOptionPane.showInputDialog(null, menu);
                if (input == null) break;
                op = Integer.parseInt(input);

                switch (op) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Saldo actual: $" + obj.getSaldo());
                        break;
                    case 2:
                        double dep = Double.parseDouble(JOptionPane.showInputDialog("Monto a depositar:"));
                        obj.realizarDeposito(dep);
                        JOptionPane.showMessageDialog(null, "Depósito exitoso.");
                        break;
                    case 3:
                        double ret = Double.parseDouble(JOptionPane.showInputDialog("Monto a retirar ($10/$20):"));
                        obj.realizarRetiro(ret);
                        JOptionPane.showMessageDialog(null, "Retiro exitoso.");
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}