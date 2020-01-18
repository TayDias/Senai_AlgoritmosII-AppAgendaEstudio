/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.awt.List;
import java.util.ArrayList;
/**
 *
 * @author taynara_muren
 */
public class Cliente {
    protected int id;
    private String nome;
    private String CPF;
    private String RG;
    private String telResidencial;
    private String telCelular;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String CEP;

    private Gravacao gravacao;
    private Agenda agenda;

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Gravacao getGravacao() {
        return gravacao;
    }

    public void setGravacao(Gravacao gravacao) {
        this.gravacao = gravacao;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
    
    
    @Override
    public String toString() {
        return id + "  "+nome + " ("+CPF+") - "+telCelular;
       
    }
   
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getTelResidencial() {
        return telResidencial;
    }

    public void setTelResidencial(String telResidencial) {
        this.telResidencial = telResidencial;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String Rua) {
        this.rua = Rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String Estado) {
        this.estado = Estado;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    
}
