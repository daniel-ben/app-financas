final class Data {
    
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
            this.setDia(dia);
            this.setMes(mes);
            this.setAno(ano);
    }

// ############ Encapsulamento #############
    public int getDia() {
        return this.dia;
    }

    private void setDia(int dia) {
        this.dia = dia; 
    }

    public int getMes() {
        return mes;
    }

    private void setMes(int mes) {
        this.mes = mes; 
    }

    public int getAno() {
        return this.ano;
    }

    private void setAno(int ano) {
        this.ano = ano; 
    }
// ############ Encapsulamento #############

// ############ Outras ############
    public static Data convData(String data)  {
        String[] strArray = data.split("/");
        int dia = Integer.parseInt(strArray[0]);
        int mes = Integer.parseInt(strArray[1]);
        int ano = Integer.parseInt(strArray[2]);
        return new Data(dia, mes, ano);
    }

    @Override
    public String toString() {
        String dia = String.format("%02d", this.dia);
        String mes = String.format("%02d", this.mes);
        String ano = String.format("%04d", this.ano);

        return dia + "/" + mes + "/" + ano;
    }
// ############ Outras ############

}
