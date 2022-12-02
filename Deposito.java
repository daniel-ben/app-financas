final class Deposito extends TransacaoBancaria {

    public Deposito(Data data, float valor, Conta conta) {
        super(data, "Deposito", valor, conta);
        this.setTipo("ENTRADA");
        this.getConta().depositar(valor);
    }

    @Override
    public String toString() {
        return "Deposito," + super.toString();
    }
}
