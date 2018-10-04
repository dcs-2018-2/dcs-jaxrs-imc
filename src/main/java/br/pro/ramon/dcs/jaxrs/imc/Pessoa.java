package br.pro.ramon.dcs.jaxrs.imc;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Pessoa {

    private String nome;
    private double peso, altura;

    public Pessoa(String nome, double peso, double altura) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }

    public double getImc() {
        throw new UnsupportedOperationException("Você precisa implementar o método getImc.");
    }

    public String getCategoria() {
        throw new UnsupportedOperationException("Você precisa implementar o método getCategoria.");
    }

}
