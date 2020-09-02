package com.desafio.listadetarefas.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "LISTA_DE_TAREFAS")
public class ListaDeTarefas extends ClasseModel {
 private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;

 private String titulo;

 @JsonManagedReference
 @OneToMany(mappedBy = "listaDeTarefas")
 private List<Item> items;


 public ListaDeTarefas() {
 }

 public ListaDeTarefas(long id, String nomeLista) {
  this.id = id;
  this.titulo = nomeLista;
 }
 
 public long getId() {
  return id;
 }

 public void setId(long id) {
  this.id = id;
 }

 public List<Item> getItems() {
  return items;
 }

 public void setItems(List<Item> items) {
  this.items = items;
 }

 public String getTitulo() {
  return titulo;
 }

 public void setTitulo(String titulo) {
  this.titulo = titulo;
 }

 @Override
 public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + (int) (id ^ (id >>> 32));
  return result;
 }

 @Override
 public boolean equals(Object obj) {
  if (this == obj)
   return true;
  if (obj == null)
   return false;
  if (getClass() != obj.getClass())
   return false;
  ListaDeTarefas other = (ListaDeTarefas) obj;
  if (id != other.id)
   return false;
  return true;
 }

}