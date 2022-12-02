public class CompraCartao extends TransacaoBancaria {

    private String toStringMessage;

    // compra debito e credito chama esse construtor com super
    public CompraCartao(Data data, String identificador, float valor, Conta conta, Boolean chamadoPorFilho) {
        super(data, identificador, valor, conta);
    }

    // Construtor chamado quando se cria nova CompraCartao sem nvezes
    public CompraCartao(Data data, String identificador, float valor, Conta conta) {
        new CompraDebito(data, identificador, valor, conta);
        this.toStringMessage = "Debito," + data + "," + identificador + "," + valor  + "," + "SAIDA" + "," + conta.getNome();
    }

    // construtor chamado quando se cria nova CompraCartao com nvezes
    public CompraCartao(Data data, String identificador, float valor, Conta conta, int nVezes) {
        if (nVezes == 1) {
            new CompraCreditoAvista(data, identificador, valor, conta);
        } else {
            new CompraCreditoParcelada(data, identificador, valor, conta, nVezes);
        }
        this.toStringMessage = "Credito," + data + "," + identificador + "," + valor  + "," + "SAIDA" + "," + conta.getNome() + "," + nVezes + "x";
    }


    public String getToStringMessage() {
        return toStringMessage;
    }

    public void setToStringMessage(String toStringMessage) {
        this.toStringMessage = toStringMessage;
    }
    

    @Override
    public String toString() {
        if (this.toStringMessage != null) {
            return this.toStringMessage;
        }
        return super.toString();
    }
}
