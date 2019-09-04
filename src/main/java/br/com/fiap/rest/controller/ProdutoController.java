package br.com.fiap.rest.controller;

import br.com.fiap.rest.entity.Produto;
import br.com.fiap.rest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/pesquisar3")
    public String abrirPesquisar3(){
        return "pesquisa3";
    }
    @PostMapping("/pesquisar3")
    public String processarPesquisar3(String nome, Model model){
        List<Produto> produtos = repository.findByNomeIgnoreCaseOrderByPrecoAsc(nome);
        model.addAttribute("produtos",produtos);
        return "sucesso";
    }

    @GetMapping("/pesquisar2")
    public String abrirPesquisar2(){
        return "pesquisa2";
    }
    @PostMapping("/pesquisar2")
    public String processarPesquisar2(double preco, Model model){
        List<Produto> produtos = repository.findByPrecoGreaterThan(preco);
        model.addAttribute("produtos",produtos);
        return "sucesso";
    }

    @GetMapping("/pesquisar")
    public String abrirPesquisarP(){
        return "pesquisa";
    }
    @PostMapping("/pesquisar")
    public String processarPesquisar(String nome, Model model){
        List<Produto> produtos = repository.findByNome(nome);
        model.addAttribute("produtos",produtos);
        return "sucesso";
    }

    @GetMapping("/produto/cadastrar")
    public String abrirCadastro(){
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String processarCadastro(Produto produto, Model model){
        repository.save(produto);
        model.addAttribute("produtos",produto);
        return "sucesso";
    }

}
