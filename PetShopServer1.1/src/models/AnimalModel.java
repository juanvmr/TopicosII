package models;

public class AnimalModel {

    private String Nome;
    private String Raca;
    private String Sexo;
    private String Cor;
    private String Idade;
    private String Altura;
    private String Peso;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String Raca) {
        this.Raca = Raca;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public String getIdade() {
        return Idade;
    }

    public void setIdade(String Idade) {
        this.Idade = Idade;
    }

    public String getAltura() {
        return Altura;
    }

    public void setAltura(String Altura) {
        this.Altura = Altura;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String Peso) {
        this.Peso = Peso;
    }

    @Override
    public String toString() {
        return "\n Nome = " + Nome + "\n Raca = " + Raca + "\n Sexo = " + Sexo + "\n Cor = " + Cor + "\n Idade = " + getIdade() + " anos" + "\n Altura = " + getAltura() + "cm" + "\n Peso = " + getPeso() + "gr";
    }

}
