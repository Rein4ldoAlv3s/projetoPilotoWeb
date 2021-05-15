/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.model;

import java.util.Date;


/**
 *
 * @author naldo
 */
public class Piloto {
    private int pilotoId;
    private int matricula;
    private String nome;
    private String pais;
    private Date dataNasc;
    private String equipe;
    private String fabricMotor;
    private int pontosTemp;

    public int getPilotoId() {
        return pilotoId;
    }

    public void setPilotoId(int pilotoId) {
        this.pilotoId = pilotoId;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getFabricMotor() {
        return fabricMotor;
    }

    public void setFabricMotor(String fabricMotor) {
        this.fabricMotor = fabricMotor;
    }

    public int getPontosTemp() {
        return pontosTemp;
    }

    public void setPontosTemp(int pontosTemp) {
        this.pontosTemp = pontosTemp;
    }


    @Override
    public String toString() {
        return "Piloto [matricula=" + matricula + ", nome=" + nome
                + ", pais=" + pais + ", data de nascimento=" + dataNasc + ", equipe="
                + equipe + ", fabricante do motor= " + fabricMotor + ", pontos da temporada=" + pontosTemp + "]";
    }
}
