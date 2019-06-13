package com.example.demo;

import org.junit.Test;
import com.example.SpringApp.SpringApp;
import com.example.SpringApp.entities.Pessoa;

public class PessoaTeste
{

	Pessoa pessoa = new Pessoa();
	SpringApp ta = new SpringApp();
	
	@Test
	public void testSeOSetPessoaFunciona()
	{
		pessoa.setNome("teste");
		pessoa.setId(1);
		pessoa.setSobrenome("testado");
	}

	@Test
	public void testSeOGetPessoaFunciona()
	{
		pessoa.getId();
		pessoa.getNome();
		pessoa.getSobrenome();
	}
	
	@Test
	public void testSeOToStringPessoaFunciona()
	{
		pessoa.toString();
		System.out.println("to String");
	}
	
	@Test
	public void testSeOHashCodePessoaFunciona()
	{
		pessoa.hashCode();
		System.out.println("HashCode");
	}
}
