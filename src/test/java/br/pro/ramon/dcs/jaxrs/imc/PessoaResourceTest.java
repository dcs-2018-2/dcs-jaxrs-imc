package br.pro.ramon.dcs.jaxrs.imc;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaResourceTest {

    @Test
    public void testImcAbaixoDoPeso() throws IOException {
        String nome = "João";
        double peso = 40;
        double altura = 2;

        RespostaWs resposta = acessaWebService(nome, peso, altura);

        assertThat(resposta.tipo, is("application/json"));
        assertThat(resposta.saida, is("{\"imc\":10.0,\"categoria\":\"Abaixo do Peso\"}"));
        assertThat(resposta.statusCode, is(200));
    }

    @Test
    public void testImcPesoNormal() throws IOException {
        String nome = "João";
        double peso = 80;
        double altura = 2;

        RespostaWs resposta = acessaWebService(nome, peso, altura);

        assertThat(resposta.tipo, is("application/json"));
        assertThat(resposta.saida, is("{\"imc\":20.0,\"categoria\":\"Peso Normal\"}"));
        assertThat(resposta.statusCode, is(200));
    }

    @Test
    public void testImcAcimaDoPeso() throws IOException {
        String nome = "João";
        double peso = 100;
        double altura = 2;

        RespostaWs resposta = acessaWebService(nome, peso, altura);

        assertThat(resposta.tipo, is("application/json"));
        assertThat(resposta.saida, is("{\"imc\":25.0,\"categoria\":\"Acima do Peso\"}"));
        assertThat(resposta.statusCode, is(200));
    }

    @Test
    public void testImcObesidade() throws IOException {
        String nome = "João";
        double peso = 120;
        double altura = 2;

        RespostaWs resposta = acessaWebService(nome, peso, altura);

        assertThat(resposta.tipo, is("application/json"));
        assertThat(resposta.saida, is("{\"imc\":30.0,\"categoria\":\"Obesidade\"}"));
        assertThat(resposta.statusCode, is(200));
    }

    private RespostaWs acessaWebService(String nome, double peso, double altura) throws IOException {
        Response response = Jsoup.connect("http://localhost:8084/dcs-jaxrs-imc/webresources/pessoa/" + nome + "/" + peso + "/" + altura)
                .method(Method.GET)
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .execute();

        String tipo = response.contentType();
        String saida = response.body();
        int statusCode = response.statusCode();

        return new RespostaWs(tipo, saida, statusCode);
    }

}

class RespostaWs {

    public String tipo;
    public String saida;
    public int statusCode;

    public RespostaWs(String tipo, String saida, int statusCode) {
        this.tipo = tipo;
        this.saida = saida;
        this.statusCode = statusCode;
    }

}
