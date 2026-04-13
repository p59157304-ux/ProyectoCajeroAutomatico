import javax.swing.JOptionPane;

class Cuenta {
    private String titular;
    private String numeroCuenta;
    private String pin;
    private double saldo;

    public Cuenta() {}

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }

    public double getSaldo() { return saldo; }

    public void registrarCuenta() {
        this.titular = JOptionPane.showInputDialog("Ingrese nombre de usuario:");
        this.numeroCuenta = JOptionPane.showInputDialog("Ingrese número de cuenta:");
        this.pin = JOptionPane.showInputDialog("Cree su PIN de seguridad:");
        this.saldo = Double.parseDouble(JOptionPane.showInputDialog("Saldo inicial ($):"));
    }

    public void realizarDeposito(double monto) throws Exception {
        if (monto <= 0) throw new Exception("El monto debe ser mayor a cero.");
        this.saldo += monto;
    }

    public void realizarRetiro(double monto) throws Exception {
        if (monto > saldo) throw new Exception("Fondos insuficientes.");
        if (monto % 10 != 0 && monto % 20 != 0) {
            throw new Exception("El cajero solo entrega múltiplos de $10 o $20.");
        }
        this.saldo -= monto;
    }
}