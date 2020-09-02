package com.desafio.listadetarefas.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.lang.NonNull;


@Entity
@Table(name = "ITEM")
public class Item extends ClasseModel {
 private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @NonNull
 private String titulo;

 @JsonBackReference
 @ManyToOne
 @JoinColumn(name = "tarefas_id", nullable = false)
 private ListaDeTarefas listaDeTarefas;

 private boolean concluido;

 public Item() {

 }

 public Item(Long id, String titulo, boolean concluido) {
  this.id = id;
  this.titulo = titulo;
  this.concluido = concluido;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getTitulo() {
  return titulo;
 }

 public void setTitulo(String titulo) {
  this.titulo = titulo;
 }

 public ListaDeTarefas getListaDeTarefas() {
  return listaDeTarefas;
 }

 public void setListaDeTarefas(ListaDeTarefas listaDeTarefas) {
  this.listaDeTarefas = listaDeTarefas;
 }

 public boolean isConcluido() {
  return concluido;
 }

 public void setConcluido(boolean concluido) {
  this.concluido = concluido;
 }
 
 



 @Override
 public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ((id == null) ? 0 : id.hashCode());
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
  Item other = (Item) obj;
  if (id == null) {
   if (other.id != null)
    return false;
  } else if (!id.equals(other.id))
   return false;
  return true;
 }


}