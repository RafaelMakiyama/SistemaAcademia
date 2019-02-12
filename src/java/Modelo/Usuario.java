package Modelo;
public class Usuario {
    
    private String email;
    private String login;
    private String senha;
    private String perfilAcesso;
    private boolean primeiroAcesso;
    private int idUsuario;

    
    //Construtores
    
    public Usuario() {

    }

    public Usuario(String email, String login, String senha, String perfilAcesso) {
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.perfilAcesso = perfilAcesso;
        this.primeiroAcesso = primeiroAcesso;
    }

    //Gets e sets

    public boolean isPrimeiroAcesso() {
        return primeiroAcesso;
    }

    public void setPrimeiroAcesso(boolean primeiroAcesso) {
        this.primeiroAcesso = primeiroAcesso;
    }   
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(String perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
