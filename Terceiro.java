final class Terceiro {
    
    private String chavePIX;

    public Terceiro(String chavePIX) {
        try{
            this.setChavePIX(chavePIX);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public String getChavePIX() {
        return this.chavePIX;
    }

    public void setChavePIX(String chavePIX) {
        this.chavePIX = chavePIX;
    }

    @Override
    public String toString() {
        return this.chavePIX;
    }
}
