package com.example.SpringApp.usecases;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.SpringApp.entities.Pessoa;
import com.example.SpringApp.viewmodels.PessoaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pessoacontroller")
public class PessoaController
{
	Logger logger = LoggerFactory.getLogger(PessoaController.class);
	
    @Autowired
    private PessoaService service;

 	@PostMapping("/adicionaPessoa")
    public List<Pessoa> createPessoa(Pessoa pessoa)
    {	    
 		logger.info("Registro criado com sucesso!");
 		
     	service.createPessoa(pessoa);
     		
    	return service.findAllPessoas();
    }

    @GetMapping("/buscaPessoa")
    public List<Pessoa> findAllPessoas()
    {	        
    	return service.findAllPessoas();
    }
    
    @GetMapping("/buscaPessoaById/{id}")
    public Pessoa findPessoaById(@PathVariable("id") Integer id)
    {
    	return service.findPessoaById(id);
    }

    @PutMapping("/atualizaPessoa")
    public List<Pessoa> updatePessoa(@Valid Pessoa pessoa)
    {  
    	logger.info("Registro atualizado com sucesso!");
    	
        service.updatePessoa(pessoa);
        
        return service.findAllPessoas();
    }
    
    @DeleteMapping("/deletaPessoa/{id}")
    public List<Pessoa> deletePessoa(@PathVariable("id") Integer id)
    {
    	logger.info("Registro deletado com sucesso!");
    	
        service.deletePessoaById(id);
        
        return service.findAllPessoas();
    }
}