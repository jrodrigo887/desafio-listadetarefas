package com.desafio.listadetarefas;

import com.desafio.listadetarefas.models.ListaDeTarefas;
import com.desafio.listadetarefas.services.TarefasService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class ListTarefaControllerTest {

    static String LISTA_API = "/api/tarefas";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TarefasService tarefasService;

    @Test
    @DisplayName("Deve criar uma lista com sucesso!")
    public void criaUmaLIstaDeTarefas() throws Exception {

        ListaDeTarefas listJson = new ListaDeTarefas(3, "Minha Lista");
        BDDMockito
                .given(this.tarefasService
                .createTarefas(Mockito.any(ListaDeTarefas.class)))
                .willReturn(listJson);

        String json = new ObjectMapper().writeValueAsString(listJson);


        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(LISTA_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("Minha Lista").value(listJson.getTitulo()));

    }

    @Test
    @DisplayName("Deve lançar erro de validaç quando nao houver dados para criar a Lista!")
    public void criaUmaLIstaDeTarefasInvalida() {
    }
}
