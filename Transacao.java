import java.util.ArrayList;

abstract class Transacao {
    
//  ################ Variáveis ################
    public static ArrayList<Transacao> listaTransacoes = new ArrayList<Transacao>();

    protected Data data;
    protected String identificador;
    protected float valor;
    private String tipo;
//  ################ Variáveis ################

//  ################ Construtor ################
    public Transacao() {}

    public Transacao(Data data, String identificador, float valor) {
        try {
            this.setData(data);
            this.setIdentificador(identificador);
            this.setValor(valor);
            Transacao.listaTransacoes.add(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//  ################ Construtor ################


//  ################ Encapsulamento ################
    public static ArrayList<Transacao> getListaTrasacao() {
        return listaTransacoes;
    }

    public static void setListaTransacoes(ArrayList<Transacao> listaTransacoes) {
        Transacao.listaTransacoes = listaTransacoes;
    }


    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data; 
    }


    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) throws Exception {
        if (identificador == "") { 
            throw new Exception("Identificador não pode ser vazio"); 
        }
        this.identificador = identificador; 
    }


    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor; 
    }


    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
//  ################ Encapsulamento ################


//  ################ Outras ################
    @Override
    public String toString() {
        return  this.data + "," + this.identificador + "," + this.valor  + "," + this.getTipo();
    }
//  ################ Outras ################
}
