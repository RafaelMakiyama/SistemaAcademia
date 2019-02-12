package Modelo;

public class ExameFisico {
    
    // atributos da classe
    private double altura,peso,peito,cintura,pantDireita,pantEsquerda,bracoDireito,bracoEsquerdo;
    private double antDireito,antEsquerdo,gluteo;
    private int idExame;    
    private Atleta atleta;
    
    //Construtores
    
    
    public ExameFisico() {
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    
    public ExameFisico(double altura, double peso, double peito, double cintura, double pantDireita, double pantEsquerda, double bracoDireito, double bracoEsquerdo, double antDireito, double antEsquerdo, double gluteo) {
        this.altura = altura;
        this.peso = peso;
        this.peito = peito;
        this.cintura = cintura;
        this.pantDireita = pantDireita;
        this.pantEsquerda = pantEsquerda;
        this.bracoDireito = bracoDireito;
        this.bracoEsquerdo = bracoEsquerdo;
        this.antDireito = antDireito;
        this.antEsquerdo = antEsquerdo;
        this.gluteo = gluteo;
    }
    
//Gets e Sets 

    public int getIdExame() {
        return idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPeito() {
        return peito;
    }

    public void setPeito(double peito) {
        this.peito = peito;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getPantDireita() {
        return pantDireita;
    }

    public void setPantDireita(double pantDireita) {
        this.pantDireita = pantDireita;
    }

    public double getPantEsquerda() {
        return pantEsquerda;
    }

    public void setPantEsquerda(double pantEsquerda) {
        this.pantEsquerda = pantEsquerda;
    }

    public double getBracoDireito() {
        return bracoDireito;
    }

    public void setBracoDireito(double bracoDireito) {
        this.bracoDireito = bracoDireito;
    }

    public double getBracoEsquerdo() {
        return bracoEsquerdo;
    }

    public void setBracoEsquerdo(double bracoEsquerdo) {
        this.bracoEsquerdo = bracoEsquerdo;
    }

    public double getAntDireito() {
        return antDireito;
    }

    public void setAntDireito(double antDireito) {
        this.antDireito = antDireito;
    }

    public double getAntEsquerdo() {
        return antEsquerdo;
    }

    public void setAntEsquerdo(double antEsquerdo) {
        this.antEsquerdo = antEsquerdo;
    }

    public double getGluteo() {
        return gluteo;
    }

    public void setGluteo(double gluteo) {
        this.gluteo = gluteo;
    }
    
    
    
    
    
}
