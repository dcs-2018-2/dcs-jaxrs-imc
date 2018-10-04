package br.pro.ramon.dcs.jaxrs.imc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class PessoaTest {

    @Test
    public void testImcAbaixoDoPeso() {
        String nome = "João";
        double peso = 40;
        double altura = 2;

        Pessoa pessoa = new Pessoa(nome, peso, altura);
        double imc = pessoa.getImc();
        String categoria = pessoa.getCategoria();

        assertThat(categoria, is("Abaixo do Peso"));
        assertThat(imc, is(10.0));
    }

    @Test
    public void testImcPesoNormal() {
        String nome = "João";
        double peso = 80;
        double altura = 2;

        Pessoa pessoa = new Pessoa(nome, peso, altura);
        double imc = pessoa.getImc();
        String categoria = pessoa.getCategoria();

        assertThat(categoria, is("Peso Normal"));
        assertThat(imc, is(20.0));
    }

    @Test
    public void testImcAcimaDoPeso() {
        String nome = "João";
        double peso = 100;
        double altura = 2;

        Pessoa pessoa = new Pessoa(nome, peso, altura);
        double imc = pessoa.getImc();
        String categoria = pessoa.getCategoria();

        assertThat(categoria, is("Acima do Peso"));
        assertThat(imc, is(25.0));
    }

    @Test
    public void testImcObesidade() {
        String nome = "João";
        double peso = 120;
        double altura = 2;

        Pessoa pessoa = new Pessoa(nome, peso, altura);
        double imc = pessoa.getImc();
        String categoria = pessoa.getCategoria();

        assertThat(categoria, is("Obesidade"));
        assertThat(imc, is(30.0));
    }

}
