package br.com.act.rbmq.springboot.service.controllers;

import br.com.act.rbmq.springboot.service.dtos.ProductDTO;
import br.com.act.rbmq.springboot.service.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.act.rbmq.springboot.service.constants.DefaultSystemMessages.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/queue")
public class QueuController {

    private final MessageService service;

    @GetMapping
    public ResponseEntity<String> produces(@RequestParam("message") String message){
        service.produceMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body(MSG_MESSAGE_SEND);
    }
}
