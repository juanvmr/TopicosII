package models;

public class ClienteModel {

    private String Nome;
    private String Endereco;
    private String Sexo;
    private String Email;
    private String CPF;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    private long Telefone;
    private int Idade;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }


    public long getTelefone() {
        return Telefone;
    }

    public void setTelefone(long Telefone) {
        this.Telefone = Telefone;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    @Override
    public String toString() {
        return "Nome = " + Nome + "\nEndereço = " + Endereco + "\nSexo = " + Sexo + "\nEmail = " + Email + "\nCPF = " + getCPF() + "\nTelefone = " + getTelefone() + "\nIdade = " + getIdade();
    }

}
