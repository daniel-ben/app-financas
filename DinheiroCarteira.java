abstract class DinheiroCarteira {
    
    private static float quantia;

    static float getQuantia() {
        return DinheiroCarteira.quantia;
    }

    static void setQuantia(float quantia) throws Exception{
        if (DinheiroCarteira.quantia + quantia < 0) {
            throw new Exception("Não tem dinheiro suficiente na carteira");
        }
        DinheiroCarteira.quantia = quantia;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
