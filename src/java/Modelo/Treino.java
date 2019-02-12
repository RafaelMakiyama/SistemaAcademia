package Modelo;


import java.sql.Date;

public class Treino {
    private int id;
    private String tipoTreinamento;
    private double tempo;
    private String exercicioNome;
    private String series;
    private Atleta atleta;
    private Date data;
    

//Construtor

  
// Gets e Sets.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public String getTipoTreinamento() {
        return tipoTreinamento;
    }

    public void setTipoTreinamento(String tipoTreinamento) {
        this.tipoTreinamento = tipoTreinamento;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public String getExercicioNome() {
        return exercicioNome;
    }

    public void setExercicioNome(String exercicioNome) {
        this.exercicioNome = exercicioNome;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

   

  

    



}
