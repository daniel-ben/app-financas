import java.util.ArrayList;

abstract class Relatorios {
    public static ArrayList<Object> somenteDebito(ArrayList<Transacao> arrayList) {
        ArrayList<Object> comprasDebito = new ArrayList<Object>();
        for (Transacao transacao : arrayList) {
            if (transacao instanceof CompraDebito) {
                comprasDebito.add(transacao);
            }
        }
        return comprasDebito;
    }

    public static ArrayList<Object> somenteCredito(ArrayList<Transacao> arrayList) {
        ArrayList<Object> comprasCredito = new ArrayList<Object>();
        for (Transacao transacao : arrayList) {
            if (transacao instanceof CompraCredito) {
                comprasCredito.add(transacao);
            }
        }
        return comprasCredito;
    }

    public static ArrayList<Transacao> somenteValorAbsolutoMaiorQue(ArrayList<Transacao> arrayList, float valor) {
        ArrayList<Transacao> comprasMaioresQue = new ArrayList<Transacao>();
        for (Transacao transacao : arrayList) {
            if (transacao.getValor() > valor || transacao.getValor() < -valor) {
                comprasMaioresQue.add(transacao);
            }
        }

        return comprasMaioresQue;
    }

    public static ArrayList<Transacao> somenteNoMes(ArrayList<Transacao> arrayList, int mes) {
        ArrayList<Transacao> comprasNoMes = new ArrayList<Transacao>();
        for (Transacao transacao : arrayList) {
            int transacaoMes = transacao.getData().getMes();
            if (transacaoMes == mes) {
                comprasNoMes.add(transacao);
            }
        }
        return comprasNoMes;
    }
}


