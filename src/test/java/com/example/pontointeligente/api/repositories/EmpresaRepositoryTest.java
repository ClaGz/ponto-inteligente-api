package com.example.pontointeligente.api.repositories;

import com.example.pontointeligente.api.entities.Empresa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class EmpresaRepositoryTest {

    //TODO: Corrigir isso. Injetar pelo construtor
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private static final String CNPJ = "51463645000100";

    @Before
    public void setUp() {
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Empresa exemplo");
        empresa.setCnpj(CNPJ);
        this.empresaRepository.save(empresa);
    }

    @After
    public final void tearDown() {
        this.empresaRepository.deleteAll();
    }

    @Test
    public void testBuscarPorCnpj() {
        Empresa empresa = this.empresaRepository.findByCnpj(CNPJ);

        assertEquals(CNPJ, empresa.getCnpj());
    }
}
