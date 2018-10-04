package br.pro.ramon.dcs.jaxrs.imc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    br.pro.ramon.dcs.jaxrs.imc.PessoaTest.class,
    br.pro.ramon.dcs.jaxrs.imc.PessoaResourceTest.class,
    br.pro.ramon.dcs.jaxrs.imc.PessoaFormTest.class
})
public class AllTests {
}
