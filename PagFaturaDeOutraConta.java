final class PagFaturaDeOutraConta extends PagamentoDeFatura {

    private Conta contaPaga;

    public PagFaturaDeOutraConta(Data data, float valor, Conta contaPagadora, Conta contaPaga) {
        super(data, "Pagamento de fatura", valor, contaPagadora);
        this.setContaPaga(contaPaga);

        this.getConta().debitar(valor);
        this.getContaPaga().retornarLimite(-valor);
    }


    public Conta getContaPaga() {
        return this.contaPaga;
    }

    public void setContaPaga(Conta contaPaga) {
        this.contaPaga = contaPaga;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
