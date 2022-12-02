final class CompraDinheiro extends Transacao {
    
    public CompraDinheiro(Data data, String identificador, float valor) {
        super(data, identificador, valor);
        this.setTipo("SAIDA");
        float dinheiroAtual = DinheiroCarteira.getQuantia();
        try {
            DinheiroCarteira.setQuantia(dinheiroAtual + valor);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    @Override
    public String toString() {
        return "Compra Dinheiro," + super.toString();
    }
}
