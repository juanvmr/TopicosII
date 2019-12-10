package models;

public class AnimalModel {

    private int clienteID;
    private String Nome;
    private String Raca;
    private String Sexo;
    private String Cor;
    private int Idade;
    private int Altura;
    private int Peso;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return clienteID;
    }

    public void setCliente(int clienteID) {
        this.clienteID = clienteID;
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

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public int getAltura() {
        return Altura;
    }

    public void setAltura(int Altura) {
        this.Altura = Altura;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int Peso) {
        this.Peso = Peso;
    }

    @Override
    public String toString() {
        return "\n Nome = " + Nome + "\n Raca = " + Raca + "\n Sexo = " + Sexo + "\n Cor = " + Cor + "\n Idade = " + getIdade() + " anos" + "\n Altura = " + getAltura() + "cm" + "\n Peso = " + getPeso() + "gr";
    }

}
