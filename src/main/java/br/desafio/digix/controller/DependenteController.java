package br.desafio.digix.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = {"/api/v1/dependente"}, produces = {"application/json"})
public class DependenteController {
    
}
