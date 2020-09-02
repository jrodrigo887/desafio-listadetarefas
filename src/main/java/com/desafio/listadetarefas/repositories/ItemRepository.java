package com.desafio.listadetarefas.repositories;

import java.util.List;
import java.util.Optional;

import com.desafio.listadetarefas.models.Item;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

 List<Item> findByListaDeTarefasId(Long id);
 Optional<Item> findByIdAndListaDeTarefasId(Long itemId, Long ListaDeTarefaId);

}