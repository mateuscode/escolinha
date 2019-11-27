/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author henri
 */
public class Curso {
    private String nome;
    private float valor;
    private String cargaHoraria;
    private int qntAlunos;
    private ArrayList<Aluno> alunos;
    private Professor professor;
    
    public void addAluno(Aluno aluno){
        this.alunos.add(aluno);
        
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getQntAlunos() {
        return qntAlunos;
    }

    public void setQntAlunos() {
        this.qntAlunos = alunos.size();
    }
    
    
}
