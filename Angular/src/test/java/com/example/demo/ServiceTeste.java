package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.SpringApp.entities.Pessoa;
import com.example.SpringApp.usecases.PessoaServiceImpl;
import com.example.SpringApp.viewmodels.PessoaRepository;
import com.example.SpringApp.viewmodels.PessoaService;
import static org.mockito.Mockito.*;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PessoaServiceImpl.class)
public class ServiceTeste
{
	@Autowired
	private PessoaService service;
	
	@MockBean
	private PessoaRepository rep;
	
	@Test
	public void testSeCreatePessoaFunciona()
	{
		Pessoa pessoa = new Pessoa();
		
		when(rep.save(pessoa)).thenReturn(pessoa);
		assertEquals(pessoa, service.createPessoa(pessoa));
	}
	
	@Test
	public void testSeFindAllPessoasFunciona()
	{
		when(rep.findAll()).thenReturn(Stream.of(new Pessoa()).collect(Collectors.toList()));
		assertEquals(1, service.findAllPessoas().size());
	}
	
	@Test
	public void testSeFindPessoaByIdFunciona()
	{
		Pessoa pessoa = new Pessoa();
		
		Integer id = 1;
		when(rep.getOne(id)).thenReturn(pessoa);
		assertEquals(pessoa, service.findPessoaById(id));
	}
	
	@Test
	public void testSeUpdatePessoaFunciona()
	{
		Pessoa pessoa = new Pessoa();
		when(rep.findById(pessoa.getId())).thenReturn(Optional.of(pessoa));
		assertEquals(pessoa, service.updatePessoa(pessoa));
	}
	
	@Test
	public void testSeDeletePessoaFunciona()
	{
		Pessoa pessoa = new Pessoa();
		service.deletePessoa(pessoa);
		verify(rep, times(1)).delete(pessoa);
	}
	
	@Test
	public void testSeDeletePessoaByIdFunciona()
	{
		Integer id = 2;
		Pessoa pessoa = new Pessoa();
		
		Pessoa spy = spy(pessoa);
		spy.setId(id);
		service.deletePessoaById(id);
		verify(rep, times(1)).deleteById(id);
	}
}