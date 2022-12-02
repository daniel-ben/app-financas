final class Saque extends TransacaoBancaria {
 
    public Saque(Data data, float valor, Conta conta) {
        super(data, "Saque", valor, conta);
        this.getConta().debitar(valor);

        try {
            DinheiroCarteira.setQuantia(DinheiroCarteira.getQuantia() - valor);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    @Override
    public String toString() {
        return "Saque," + super.toString();
    }
}
