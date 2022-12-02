final class PagBoletoAgendados extends Boleto {
    
    private Data dataDeAgendamento;

    public PagBoletoAgendados(Data data, String identificador, float valor, Conta conta) {
        super(data, identificador, valor, conta);

        float totalAgendadoAtual = this.getConta().getTotalTransacaoAgendada();
        this.getConta().setTotalTransacaoAgendada(totalAgendadoAtual + valor);
    }

    public Data getDataDeAgendamento() {
        return this.dataDeAgendamento;
    }

    public void setDataDeAgendamento(Data dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }

    @Override
    public String toString() {
        // Boleto Agendado,null,boleto formatura,-200.0,SAIDA,Banco Do Brasil
        return "Boleto Agendado," + super.toString();
    }
}
