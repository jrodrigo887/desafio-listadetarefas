package com.desafio.listadetarefas.controllers;

import java.util.List;

import com.desafio.listadetarefas.models.Item;
import com.desafio.listadetarefas.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "/api")
@RestController
public class ItemController {

  @Autowired
  private ItemService itemService;

 @GetMapping("/tarefas/{tarefaId}/items")
 public List<Item> getAllItemByListTarefaId(@PathVariable(value = "tarefaId") Long tarefaId) {
  return itemService.getAllItemByListTarefaId(tarefaId);
 }

 @GetMapping("/tarefas/{tarefaId}/items/{itemId}")
 public Item getItemByIdListTarefa(@PathVariable(value = "tarefaId") Long tarefaId,
                                   @PathVariable(value = "itemId") Long itemId) {
  return itemService.getItemByIdListTarefa(tarefaId, itemId);
 }

 @PostMapping("/tarefas/{tarefaId}/items")
 public Item createItem(@PathVariable(value = "tarefaId") Long tarefaId, @Validated @RequestBody Item item) {
  return itemService.createItem(tarefaId, item);
 }

 @PutMapping("/tarefas/{tarefaId}/items/{itemId}")
 public Item updateItem(@PathVariable(value = "tarefaId") Long tarefaId,
                        @PathVariable(value = "itemId") Long itemId,
                        @Validated @RequestBody Item item) {
  return itemService.updateItem(tarefaId, itemId, item);
 }

 @DeleteMapping("/tarefas/{tarefaId}/items/{itemId}")
 public ResponseEntity<?> deleteItem(@PathVariable(value = "tarefaId") Long tarefaId,
                                     @PathVariable(value = "itemId") Long itemId) {
  return itemService.deleteItem(tarefaId, itemId);

 }

}