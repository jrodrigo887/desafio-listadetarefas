package com.desafio.listadetarefas.exception;

import java.io.Serializable;

public class ErroPadrao implements Serializable{

 private static final long serialVersionUID = 1L;
 
 private String messagem;
 private Integer status;
 private Long timestamp;

 public ErroPadrao(String messagem, Integer status, Long timestamp) {
  this.messagem = messagem;
  this.status = status;
  this.timestamp = timestamp;
 }

 public String getMessagem() {
  return messagem;
 }

 public void setMessagem(String messagem) {
  this.messagem = messagem;
 }

 public Integer getStatus() {
  return status;
 }

 public void setStatus(Integer status) {
  this.status = status;
 }

 public Long getTimestamp() {
  return timestamp;
 }

 public void setTimestamp(Long timestamp) {
  this.timestamp = timestamp;
 }



}