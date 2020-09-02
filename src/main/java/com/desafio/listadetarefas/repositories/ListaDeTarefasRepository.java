package com.desafio.listadetarefas.repositories;
import com.desafio.listadetarefas.models.ListaDeTarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDeTarefasRepository extends JpaRepository<ListaDeTarefas, Long> {

}