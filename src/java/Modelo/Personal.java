package Modelo;

public class Personal  extends Pessoa{
    private int matricula ;
    private String instituicao;
    private String curso;
    private String metodos;

    //Gets e Sets 
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMetodos() {
        return metodos;
    }

    public void setMetodos(String metodos) {
        this.metodos = metodos;
    }
}