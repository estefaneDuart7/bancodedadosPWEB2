package com.algaworks.gestaofesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ConvidadosController {

    @Autowired
    private Convidados convidados;

    @GetMapping("/convidados")
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("ListaConvidados");
        modelAndView.addObject(new Convidado());
        modelAndView.addObject("convidados", convidados.findAll());
        return modelAndView;
    }
    @PostMapping("/convidados")
    public String salvar(Convidado convidado){
        this.convidados.save(convidado);
        return "redirect:/convidados";
    }
    @RequestMapping("/convidados/excluir/{id}")
    public String ExcluirConvidado(@PathVariable(value="id") long id){
        this.convidados.deleteById(id);
        return "redirect:/convidados";
    }
}