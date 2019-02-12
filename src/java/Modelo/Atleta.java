package Modelo;
public class Atleta  extends Pessoa{
    
    //Atributos.
    private int id;
    private String objetivo;
    private String alimentacao;
    private boolean situacaoMatricula;
    
    //Gets e sets

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public boolean isSituacaoMatricula() {
        return situacaoMatricula;
    }

    public void setSituacaoMatricula(boolean situacaoMatricula) {
        this.situacaoMatricula = situacaoMatricula;
    }
    
}   