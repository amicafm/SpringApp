package com.example.demo;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.SpringApp.entities.Pessoa;
import com.example.SpringApp.usecases.PessoaController;
import com.example.SpringApp.viewmodels.PessoaService;
import static org.mockito.Mockito.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PessoaController.class)

public class ControllerTeste
{
	@Autowired
	private PessoaController controller;
	
	@MockBean
	private PessoaService service;
	
	@Test
	public void testSeCreatePessoaFunciona()
	{
		Pessoa pessoa = null;
		
		when(controller.findAllPessoas()).thenReturn((List<Pessoa>) pessoa);
		assertEquals(pessoa, controller.createPessoa(pessoa));
	}

	@Test
	public void testSeFindAllPessoasFunciona()
	{
		Pessoa pessoa = null;
		
		when(controller.findAllPessoas()).thenReturn((List<Pessoa>) pessoa);
		assertEquals(pessoa, controller.findAllPessoas());
	}
	
	@Test
	public void testSeFindPessoaByIdFunciona()
	{						
		Pessoa pessoa = controller.findPessoaById(0);
		
		when(controller.findPessoaById(0)).thenReturn(pessoa);
		assertEquals(null, pessoa);
	}
	
	@Test
	public void testSeUpdatePessoaFunciona()
	{
		Pessoa pessoa = null;
		
		when(controller.updatePessoa(pessoa)).thenReturn((List<Pessoa>) pessoa);
		assertEquals((List<Pessoa>) pessoa, controller.updatePessoa(pessoa));
	}

	@Test
	public void testSeDeletePessoaFunciona()
	{
		controller.deletePessoa(2);
		
		verify(service, times(1)).deletePessoaById(2);
	}
}