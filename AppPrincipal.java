/**
 * Código que contém a main
 */
public class AppPrincipal {
    public static void main(String[] args) {

        Conta bb = new Conta("Banco Do Brasil", 1000, 0);
        Conta nb = new Conta("NuBank", 500, 500);

        Conta.statusContas();

        System.out.println("\n ***** Inicio Cadastros ***** \n");
        cadastrarTransacao(new CompraCartao(new Data(1, 11, 2022), "Posto de Gasolina", -150f, bb));
        cadastrarTransacao(new CompraCartao(new Data(1, 11, 2022), "Loja Roupas", -100f, nb));
        cadastrarTransacao(new CompraCartao(new Data(1, 10, 2022), "Mercado", -142.22f, nb, 1));
        cadastrarTransacao(new CompraCartao(new Data(1, 5, 12), "Compra online", -500, bb, 10));
        cadastrarTransacao(new CompraCartao(new Data(1, 5, 12), "Compra online", -500, nb, 10));
        cadastrarTransacao(new PagFaturaDeOutraConta(new Data(1, 5, 12), -142.22f, bb, nb));
        cadastrarTransacao(new CompraCartao(new Data(1, 5, 12), "Compra online", -500, nb, 10));
        cadastrarTransacao(new Deposito(new Data(5, 11, 2022), 500, bb));
        cadastrarTransacao(new Pix(new Data(6, 11, 2022), "para conta nubk ", -500f, bb, new Terceiro("meuemail@com")));
        cadastrarTransacao(new Pix(new Data(6, 11, 2022), "para conta nubk ", 500f, nb, new Terceiro("67 999991234")));
        cadastrarTransacao(new Saque(new Data(7, 11, 2022), -100, bb));
        cadastrarTransacao(new PagBoletoAgendados(new Data(15, 12, 2022), "boleto formatura", -200, bb));
        cadastrarTransacao(new PagBoleto(new Data(10, 12, 2022), "boleto formatura", -200, bb));
        cadastrarTransacao(new CompraDinheiro(new Data(11, 10, 2022), "feira", -15));
        cadastrarTransacao(new PagFaturaMesmaConta(new Data(11, 10, 2022), -50, nb));

        System.out.println();
        System.out.println("Somente compra Debito");
        for (Object item : Relatorios.somenteDebito(Transacao.getListaTrasacao())) {
            System.out.println("\t" + item);
        }

        System.out.println();
        System.out.println("Somente compra Credito");
        for (Object item : Relatorios.somenteCredito(Transacao.getListaTrasacao())) {
            System.out.println("\t" + item);
        }

        System.out.println();
        System.out.println("Somente transacoes acima de ...");
        for (Object item : Relatorios.somenteValorAbsolutoMaiorQue(Transacao.getListaTrasacao(), 100)) {
            System.out.println("\t" + item);
        }

        System.out.println();
        System.out.println("Somente transacoes no mes ...");
        for (Object item : Relatorios.somenteNoMes(Transacao.getListaTrasacao(), 11)) {
            System.out.println("\t" + item);
        }

    }

    private static void cadastrarTransacao(Transacao transacao) {
        System.out.println(transacao);
        Conta.statusContas();
        System.out.println("Dinheiro Carteira: " + DinheiroCarteira.getQuantia());
        System.out.println();

    }
}