abstract class CompraCredito extends CompraCartao {
    
    private int nVezes;

//  ################ Construtor ################
    public CompraCredito(Data data, String identificador, float valor, Conta conta) {
        super(data, identificador, valor, conta, true);
        this.setNVezes(1); 
        this.getConta().reterLimite(valor);

        if (this.getConta().getTipo() == "Debito") {
            setTipo(null);
        }
    }

    public CompraCredito(Data data, String identificador, float valor, Conta conta, int nVezes) {
        super(data, identificador, valor, conta, true);
        this.setNVezes(nVezes);
        this.getConta().reterLimite(valor);

        if (this.getConta().getTipo() == "Debito") {
            this.setTipo(null);
        }
    }
//  ################ Construtor ################


    public int getNVezes() {
        return this.nVezes;
    }

    public void setNVezes(int nVezes) {
        this.nVezes = nVezes;
    } 

    @Override
    public String toString() {
        return "Credito," + super.toString() + "," + nVezes + "x";
    }
}
