final class PagFaturaMesmaConta extends PagamentoDeFatura {
    
    public PagFaturaMesmaConta(Data data, float valor, Conta conta) {
        super(data, "Pagamento de fatura", valor, conta);

        this.getConta().debitar(valor);

        float limiteAtual = this.getConta().getLimiteDisponivel();
        try {
            this.getConta().setLimiteDisponivel(limiteAtual - valor);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
