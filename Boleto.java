abstract class Boleto extends TransacaoBancaria {
    
    public Boleto(Data data, String identificador, float valor, Conta conta) {
        super(data, identificador, valor, conta);
    }

    @Override
    public String toString() {
        return  this.getData() + "," + this.getIdentificador() + "," + this.getValor() + "," + "SAIDA," + this.getConta().getNome();
    }
}
