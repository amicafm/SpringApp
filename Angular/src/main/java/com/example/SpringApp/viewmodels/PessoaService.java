package com.example.SpringApp.viewmodels;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.SpringApp.entities.Pessoa;

@Service
public interface PessoaService
{
    Pessoa createPessoa(Pessoa pessoa);
    Pessoa findPessoaById(Integer id);
    List<Pessoa> findAllPessoas();
    Pessoa updatePessoa(Pessoa pessoa);
    List<Pessoa> deletePessoaById(Integer id);
    List<Pessoa> deletePessoa(Pessoa pessoa);
}