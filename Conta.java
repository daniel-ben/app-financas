import java.util.ArrayList;

final class Conta implements iConta {

//  ################ Variáveis ################
    private String nome;
    private float saldo;
    private float limite;
    private float limiteDisponivel;

    private Data diaPagamentoFatura;
    private Data diaFechamentoFatura;

    private float totalTransacaoAgendada;
    private String tipo;

    public static ArrayList<Conta> contas = new ArrayList<Conta>();
//  ################ Variáveis ################


//  ################ Construtor ################
    public Conta(String nome, float saldo, float limite) {
        try {
            this.setNome(nome);
            this.setSaldo(saldo);

            if (nome == "Banco Do Brasil") {
                this.setTipo("Debito");
            } else if (nome == "NuBank") {
                this.setTipo("Debito/Credito");
                this.setLimite(limite);
                this.setLimiteDisponivel(limite);
            }

            Conta.contas.add(this);
        } catch (Exception err) {
            System.out.println(err);
        }
    }
//  ################ Construtor ################


//  ################ Interface ################
    @Override
    public void debitar(float valor) {
        float novoSaldo = this.saldo + valor;
        try {
            this.setSaldo(novoSaldo);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    @Override
    public void depositar(float valor) {
        try {
            this.setSaldo(this.saldo + valor);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    @Override
    public void reterLimite(float valor) {
        float novoLimite = this.limiteDisponivel + valor;

        if (this.getTipo() == "Debito") {
            String err = "CONTA NAO REALIZA ESTA TRANSACAO";
            System.out.println(err);
            return;
        }

        try {
            setLimiteDisponivel(novoLimite);
        } catch (Exception err) {}
    }

    @Override
    public void retornarLimite(float valor) {

        if (this.getTipo() == "Debito") {
            String err = "CONTA NAO REALIZA ESTA TRANSACAO";
            System.out.println(err);
            return;
        }
        
        try {
            this.setLimiteDisponivel(this.getLimiteDisponivel() + valor);
        } catch (Exception err) {
            System.out.println(err);
        }
    }
//  ################ Interface ################


//  ################ Encapsulamento ################
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome == "") {
            throw new Exception("Nome não pode ser vazio");
        }
        this.nome = nome;
    }


    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) throws Exception {
        if (saldo < 0) { 
            throw new Exception("Saldo insuficiente");
        }
        this.saldo = saldo; 
    }


    public float getLimite() {
        return this.limite;
    }

    public void setLimite(float limite) throws Exception {
        if (limite < 0) {
            throw new Exception("limite não pode ser negativo");
        }
        this.limite = limite;
    }


    public float getLimiteDisponivel() {
        return this.limiteDisponivel;
    }

    public void setLimiteDisponivel(float limiteDisponivel) throws Exception {
         if (limiteDisponivel < 0) {
            String err = "SEM LIMITE PARA ESTA TRANSAÇÃO:";
            System.out.println(err);
            throw new Exception(err);
        } else if (limiteDisponivel > this.limite) {
            String err = "TRANSACAO NÃO PODE EXCEDER O LIMITE DA CONTA";
            System.out.println(err);
            throw new Exception(err);
        }

        this.limiteDisponivel = limiteDisponivel;
    }


    public Data getDataPagamentoFatura() {
        return this.diaPagamentoFatura;
    }

    public void setDataPagamentoFatura(Data dataPagamentoFatura) {
        this.diaPagamentoFatura = dataPagamentoFatura;
    }


    public Data getDataFechamentoFatura() {
        return this.diaFechamentoFatura;
    }

    public void setDataFechamentoFatura(Data dataFechamentoFatura) {
        this.diaFechamentoFatura = dataFechamentoFatura;
    }
  

    public float getTotalTransacaoAgendada() {
        return totalTransacaoAgendada;
    }

    public void setTotalTransacaoAgendada(float totalTransacaoAgendada) {
        this.totalTransacaoAgendada = totalTransacaoAgendada;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public static ArrayList<Conta> getContas() {
        return contas;
    }

    public static void setContas(ArrayList<Conta> contas) {
        Conta.contas = contas;
    }
//  ################ Encapsulamento ################


//  ################ Outras ################
    public static void statusContas() {
        for (Conta conta : Conta.contas) {
            System.out.println(conta);
        }
    }

    @Override
    public String toString() {
        return "Conta [nome=" + nome + ", saldo=" + saldo + ", limite=" + limite + ", limiteDisponivel="
                + limiteDisponivel + ", tipo=Conta " + tipo + ", Valor Agendado" + this.totalTransacaoAgendada + "]";
    }
//  ################ Outras ################

}
