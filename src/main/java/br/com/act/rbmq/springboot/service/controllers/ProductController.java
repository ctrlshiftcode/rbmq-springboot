package br.com.act.rbmq.springboot.service.controllers;


import br.com.act.rbmq.springboot.service.dtos.ProductDTO;
import br.com.act.rbmq.springboot.service.services.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/product")
public class ProductController {

    private final MessageService service;

    @PostMapping
    public ResponseEntity<ProductDTO> producer(@RequestBody ProductDTO dto){
        service.produceProduct(dto);
        return ResponseEntity.status(CREATED).build();
    }


}
