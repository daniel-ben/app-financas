final class CompraCreditoParcelada extends CompraCredito {
    
    public CompraCreditoParcelada(Data data, String identificador, float valor, Conta conta, int nVezes) {
        super(data, identificador, valor, conta, nVezes);
    }

    @Override 
    public String toString() {
        return super.toString() + "," + (this.getValor() / this.getNVezes());
    }
}
