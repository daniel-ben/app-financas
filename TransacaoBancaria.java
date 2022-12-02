abstract class TransacaoBancaria extends Transacao {
    private Conta conta;

    public TransacaoBancaria() {}

    public TransacaoBancaria(Data data, String identificador, float valor, Conta conta) {
        super(data, identificador, valor);
        this.setTipo("SAIDA");
        try {
            this.setConta(conta);
        } 
        catch (Exception err) {
            System.out.println(err);
        }
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return super.toString() + "," + this.getConta().getNome();
    }
}
