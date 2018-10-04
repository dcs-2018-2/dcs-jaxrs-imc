package br.pro.ramon.dcs.jaxrs.imc;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class PessoaFormTest {

    @Test
    public void testImcAbaixoDoPeso() throws IOException {
        String nome = "João";
        String peso = "40";
        String altura = "2";

        RespostaImc resposta = usaFormQueFazChamadaAjax(nome, peso, altura);

        assertThat(resposta.imc, is("10"));
        assertThat(resposta.categoria, is("Abaixo do Peso"));
    }

    @Test
    public void testImcPesoNormal() throws IOException {
        String nome = "João";
        String peso = "80";
        String altura = "2";

        RespostaImc resposta = usaFormQueFazChamadaAjax(nome, peso, altura);

        assertThat(resposta.imc, is("20"));
        assertThat(resposta.categoria, is("Peso Normal"));
    }

    @Test
    public void testImcAcimaDoPeso() throws IOException {
        String nome = "João";
        String peso = "100";
        String altura = "2";

        RespostaImc resposta = usaFormQueFazChamadaAjax(nome, peso, altura);

        assertThat(resposta.imc, is("25"));
        assertThat(resposta.categoria, is("Acima do Peso"));
    }

    @Test
    public void testImcObesidade() throws IOException {
        String nome = "João";
        String peso = "120";
        String altura = "2";

        RespostaImc resposta = usaFormQueFazChamadaAjax(nome, peso, altura);

        assertThat(resposta.imc, is("30"));
        assertThat(resposta.categoria, is("Obesidade"));
    }

    private RespostaImc usaFormQueFazChamadaAjax(String nome, String peso, String altura) {
        JBrowserDriver driver = new JBrowserDriver();
        driver.get("http://localhost:8084/dcs-jaxrs-imc");

        WebElement nomeInput = driver.findElementById("nome");
        nomeInput.sendKeys(nome);

        WebElement pesoInput = driver.findElementById("peso");
        pesoInput.sendKeys(peso);

        WebElement alturaInput = driver.findElementById("altura");
        alturaInput.sendKeys(altura);

        WebElement calcularButton = driver.findElementById("calcular");
        calcularButton.click();

        WebElement imcInput = driver.findElementById("imc");
        String imc = imcInput.getAttribute("value");

        WebElement categoriaInput = driver.findElementById("categoria");
        String categoria = categoriaInput.getAttribute("value");

        return new RespostaImc(imc, categoria);
    }

}

class RespostaImc {

    public String imc;
    public String categoria;

    public RespostaImc(String imc, String categoria) {
        this.imc = imc;
        this.categoria = categoria;
    }

}
