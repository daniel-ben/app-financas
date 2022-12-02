final class Pix extends TransacaoBancaria {

    private Terceiro terceiro;

    public Pix(Data data, String identificador, float valor, Conta conta, Terceiro terceiro) {
        super(data, identificador, valor, conta);
        try {
            this.setTerceiro(terceiro);
        } catch (Exception err) {
            System.out.println(err);
        }

        if (this.getValor() > 0 ) {
            this.setTipo("ENTRADA");
            this.getConta().depositar(valor);
        } else {
            this.setTipo("SAIDA");
            this.getConta().debitar(valor);
        }
        
    }

    public Terceiro getTerceiro() {
        return this.terceiro;
    }

    public void setTerceiro(Terceiro terceiro) {
        this.terceiro = terceiro;
    }

    @Override
    public String toString() {
        String sinal;
        if (this.getValor() > 0) {
            sinal = "(+)";
        } else {
            sinal = "(-)";
        }
        return sinal + "PIX," + super.toString();
    }
}
