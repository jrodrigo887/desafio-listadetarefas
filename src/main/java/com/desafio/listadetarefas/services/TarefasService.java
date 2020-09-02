package com.desafio.listadetarefas.services;

import java.util.List;
import com.desafio.listadetarefas.exception.RecursoNotFound;
import com.desafio.listadetarefas.models.ListaDeTarefas;
import com.desafio.listadetarefas.repositories.ListaDeTarefasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TarefasService {

 @Autowired
 private ListaDeTarefasRepository tarefasRepository;


 public List<ListaDeTarefas> getTarefas() {
  return tarefasRepository.findAll();
 }

 public ListaDeTarefas getTarefaById(Long id) {
  
  return tarefasRepository.findById(id)
  .orElseThrow(() -> new RecursoNotFound("Não foi possível encontrar dados referente ao id " + id));
 }

 public ListaDeTarefas createTarefas(ListaDeTarefas listTarefas) {
  return tarefasRepository.save(listTarefas);
 }

 
 public ListaDeTarefas updateListaDeTarefas(Long listTarefaId, ListaDeTarefas listTarefas) {
  
  return tarefasRepository.findById(listTarefaId).map(lista -> {

   lista.setTitulo(listTarefas.getTitulo());
   lista.setItems(listTarefas.getItems());
   return tarefasRepository.save(lista);
  })
  .orElseThrow(() -> new RecursoNotFound("Não foi possível Atualizar")); 
 }


 public ResponseEntity<?> deleteListaDeTarefas(Long listaId) {
  
  return tarefasRepository.findById(listaId).map(lista -> {

   tarefasRepository.delete(lista);
   return ResponseEntity.status(200).build();
  })
  .orElseThrow(() -> new RecursoNotFound("Não foi encontrado o Id: "+ listaId +" da Lista de Tarefa")) ;
 }


}