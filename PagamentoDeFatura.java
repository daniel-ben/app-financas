abstract class PagamentoDeFatura extends TransacaoBancaria {
    
    public PagamentoDeFatura(Data data, String identificador, float valor, Conta conta) {
        super(data, identificador, valor, conta);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
