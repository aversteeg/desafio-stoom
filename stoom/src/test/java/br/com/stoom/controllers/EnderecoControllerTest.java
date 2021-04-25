package br.com.stoom.controllers;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.stoom.model.Endereco;
import br.com.stoom.respositories.EnderecoRepository;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnderecoControllerTest {
 
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private EnderecoRepository enderecoRepository;
    
    @Test
    public void shouldSave() throws Exception {
    	Endereco endereco = new Endereco(1L,"Rua Rio das Velhas", "547", "CASA", "Novo Riacho", "Contagem", "Minas Gerais", 
    			"Brasil", "32280370", "no lat", "no long");
    	Mockito.when(this.enderecoRepository.save(Mockito.any(Endereco.class))).thenReturn(endereco);
    	
    	String URI = "/endereco";
        String inputJson = this.mapToJson(endereco);
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        		.post(URI, 1L)
        		.accept(MediaType.APPLICATION_JSON).content(inputJson)
        		.contentType(MediaType.APPLICATION_JSON);
        
        
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString();
        
        Assertions.assertEquals(inputJson, outputJson);
    }
    
    @Test
    public void shouldSaveAndReturnEndereco() throws Exception {
    	Endereco endereco = new Endereco(1L,"Rua Rio das Velhas", "547", "CASA", "Novo Riacho", "Contagem", "Minas Gerais", 
    			"Brasil", "32280-370", "no lat", "no long");
    	Endereco endereco2 = new Endereco(1L,"Rua Zuneide Aparecida Marin", "43", "PREDIO", "Jardim Santa Genebra II", "Campinas", "Sao Paulo", 
    			"Brasil", "13084-780", "no lat", "no long");
    	
        List<Endereco> userList = new ArrayList<>();
        userList.add(endereco);
        userList.add(endereco2);
    	
        Mockito.when(this.enderecoRepository.findAll()).thenReturn(userList);
        
        String URI = "/endereco";
        String inputJson = this.mapToJson(userList);
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        		.get(URI, 1L)
        		.accept(MediaType.APPLICATION_JSON).content(inputJson)
        		.contentType(MediaType.APPLICATION_JSON);
        
        
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString();
        
        Assertions.assertEquals(inputJson, outputJson);
    }
    
    private String mapToJson(Object object) throws JsonProcessingException {
    	ObjectMapper objectMapper = new ObjectMapper();
    	return objectMapper.writeValueAsString(object);
    }
    
}