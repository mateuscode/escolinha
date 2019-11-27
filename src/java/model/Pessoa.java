/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *
 * @author henri
 */
public class Pessoa {
    private String nome;
    private String celular;
    private String email;
    public Endereco endereco = new Endereco();
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setCelular(String celular){
        this.celular = celular;
    }
    public String getCelular(){
        return celular;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    
}
