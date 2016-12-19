package com.example.alunos.aulalistviewbaseadapterpicasso;

import java.io.Serializable;

/**
 * Created by Alunos on 19/12/2016.
 */

public class Pessoa implements Serializable{

    private String nome;
    private int idade;
    private String sexo;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nIdade: " + idade +
                " \nSexo: " + sexo ;

    }
}
