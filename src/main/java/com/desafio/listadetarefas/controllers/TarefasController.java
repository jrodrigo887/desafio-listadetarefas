package com.desafio.listadetarefas.controllers;
import java.util.List;

import com.desafio.listadetarefas.models.ListaDeTarefas;
import com.desafio.listadetarefas.services.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class TarefasController {

 @Autowired
 private TarefasService tarefaService;

 @GetMapping("/tarefas")
 public List<ListaDeTarefas> getTarefas() {
  return tarefaService.getTarefas();
 }

 @GetMapping("/tarefas/{id}")
 public ResponseEntity<ListaDeTarefas> getTarefasById(@PathVariable Long id) {
  ListaDeTarefas obj = tarefaService.getTarefaById(id);
  return ResponseEntity.ok().body(obj);
 }

 @PostMapping("/tarefas")
 @ResponseStatus(HttpStatus.CREATED)
 public ListaDeTarefas createTarefas(@Validated @RequestBody ListaDeTarefas listTarefas) {
  return tarefaService.createTarefas(listTarefas);
 }

 @PutMapping("/tarefas/{id}")
 public ListaDeTarefas updateListaDeTarefas(@PathVariable Long listTarefaId, @Validated @RequestBody ListaDeTarefas listTarefas) {
  return tarefaService.updateListaDeTarefas(listTarefaId, listTarefas);
 }

 @DeleteMapping("/tarefas/{listaId}")
 public ResponseEntity<?> deleteListaDeTarefas(@PathVariable Long listaId) {
  return tarefaService.deleteListaDeTarefas(listaId);
 }


}