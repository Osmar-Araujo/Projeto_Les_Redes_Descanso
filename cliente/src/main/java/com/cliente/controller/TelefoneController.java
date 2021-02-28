package com.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.services.TelefoneServices;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/telefone")
@Api(value = "API de cadastro de clientes")
public class TelefoneController {
	
	@Autowired
	private TelefoneServices telServ;
	
	
}
