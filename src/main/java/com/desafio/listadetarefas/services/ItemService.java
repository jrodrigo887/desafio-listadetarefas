package com.desafio.listadetarefas.services;

import java.util.List;

import com.desafio.listadetarefas.exception.RecursoNotFound;
import com.desafio.listadetarefas.models.Item;
import com.desafio.listadetarefas.repositories.ItemRepository;
import com.desafio.listadetarefas.repositories.ListaDeTarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

 @Autowired
 private ItemRepository itemRepository;

 @Autowired
 private ListaDeTarefasRepository listaTarefasRepository;

 public List<Item> getAllItemByListTarefaId(Long tarefaId) {
  return itemRepository.findByListaDeTarefasId(tarefaId);
 }


 public Item getItemByIdListTarefa(Long tarefaId, Long itemId) {
  if (!listaTarefasRepository.existsById(tarefaId)) {
   throw new RecursoNotFound("Tarefa Id " + tarefaId + " Não encontrado!");
  }
  return itemRepository.findByIdAndListaDeTarefasId(itemId, tarefaId)
    .orElseThrow(() -> new RecursoNotFound("Item Id " + itemId + " não Encontrado!"));
 }

 public Item createItem(Long tarefaId, Item item) {
  return listaTarefasRepository.findById(tarefaId).map(listTarefa -> {
   item.setListaDeTarefas(listTarefa);
   return itemRepository.save(item);
  }).orElseThrow(() -> new RecursoNotFound("Tarefa Id " + tarefaId + " Não Encontrado!"));
 }

 
 public Item updateItem(Long tarefaId, Long itemId, Item item) {
  if (!listaTarefasRepository.existsById(tarefaId)) {
   throw new RecursoNotFound("Tarefa Id " + tarefaId + " Não encontrado!");
  }

  return itemRepository.findById(itemId).map(itm -> {
   itm.setTitulo(item.getTitulo());
   itm.setConcluido(item.isConcluido());
   return itemRepository.save(itm);
  }).orElseThrow(() -> new RecursoNotFound("Tarefa Id " + tarefaId + " Não Encontrado!"));
 }

 
 public ResponseEntity<?> deleteItem(Long tarefaId, Long itemId) {
  return itemRepository.findByIdAndListaDeTarefasId(itemId, tarefaId).map(item -> {
   itemRepository.delete(item);
   return ResponseEntity.ok().build();
  }).orElseThrow(
    () -> new RecursoNotFound("Item com Id " + itemId + " e Lista com id " + tarefaId + " Não encontrados."));
 }


}