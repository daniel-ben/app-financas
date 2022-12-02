final class PagBoleto extends Boleto {
    
    public PagBoleto(Data data, String identificador, float valor, Conta conta) {
        super(data, identificador, valor, conta);

        this.getConta().debitar(valor);
    }

    @Override
    public String toString() {
        return "Boleto pago," + super.toString();
    }
}
