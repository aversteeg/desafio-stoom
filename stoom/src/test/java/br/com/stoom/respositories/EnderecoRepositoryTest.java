package br.com.stoom.respositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.stoom.model.Endereco;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EnderecoRepositoryTest {
 
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Test
    public void createShouldPersist() {
    	Endereco endereco = new Endereco(1L,"Rua Rio das Velhas", "547", "CASA", "Novo Riacho", "Contagem", "Minas Gerais", 
    			"Brasil", "32280370", "no lat", "no long");
    	this.enderecoRepository.save(endereco);
    	Assertions.assertThat(endereco.getId()).isNotNull();
    	Assertions.assertThat(endereco.getStreetName()).isEqualTo("Rua Rio das Velhas");
    	Assertions.assertThat(endereco.getNumber()).isEqualTo("547");
    	Assertions.assertThat(endereco.getComplement()).isEqualTo("CASA");
    	Assertions.assertThat(endereco.getNeighbourhood()).isEqualTo("Novo Riacho");
    	Assertions.assertThat(endereco.getCity()).isEqualTo("Contagem");
    	Assertions.assertThat(endereco.getState()).isEqualTo("Minas Gerais");
    	Assertions.assertThat(endereco.getCountry()).isEqualTo("Brasil");
    	Assertions.assertThat(endereco.getZipcode()).isEqualTo("32280370");
    	Assertions.assertThat(endereco.getLatitude()).isEqualTo("no lat");
    	Assertions.assertThat(endereco.getLongitude()).isEqualTo("no long");
    }
    
    @Test
    public void deleteShouldRemove() {
    	Endereco endereco = new Endereco("Rua Rio das Velhas", "547", "CASA", "Novo Riacho", "Contagem", "Minas Gerais", 
    			"Brasil", "32280370", "no lat", "no long");
    	this.enderecoRepository.save(endereco);
    	enderecoRepository.delete(endereco);
    	Assertions.assertThat(enderecoRepository.findAll().size()).isEqualTo(0);
    }
    
    @Test
    public void updateShouldChangeAndPersistData() {
    	Endereco endereco = new Endereco(1L,"Rua Rio das Velhas", "547", "CASA", "Novo Riacho", "Contagem", "Minas Gerais", 
    			"Brasil", "32280370", "no lat", "no long");
    	this.enderecoRepository.save(endereco);
    	endereco.setStreetName("Nova Rua");
    	endereco.setNumber("999");
    	this.enderecoRepository.saveAndFlush((endereco));
    	
    	//READ CASE TEST - Ao buscar do repositório o caso de teste de READ está sendo feito automaticamente.
    	endereco = this.enderecoRepository.findById(endereco.getId()).get();
    	
    	Assertions.assertThat(endereco.getStreetName()).isEqualTo("Nova Rua");
    	Assertions.assertThat(endereco.getNumber()).isEqualTo("999");
    }
    
}
