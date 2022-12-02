final class CompraDebito extends CompraCartao {

    public CompraDebito(Data data, String identificador, float valor, Conta conta) {
        super(data, identificador, valor, conta, true);
        this.getConta().debitar(valor);
    }

    @Override
    public String toString() {
        return "Debito," + super.toString();
    }

}