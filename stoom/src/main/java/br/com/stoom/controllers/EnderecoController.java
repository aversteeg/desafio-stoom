package br.com.stoom.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.stoom.exception.ResourceNotFoundException;
import br.com.stoom.model.Endereco;
import br.com.stoom.respositories.EnderecoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
     
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @ApiOperation(value = "FindAll Enderecos",
    		notes="Busca todos endereços cadastrados no banco",
    		response = Endereco.class)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }
    
    @ApiOperation(value = "Cria Endereço",
    		notes="Persiste no banco de dados um Endereço",
    		response = Endereco.class)
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Endereco createEndereco(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @ApiOperation(value = "Update Endereço",
    		notes="Atualiza os dados de um endereço no banco através de seu ID",
    		response = Endereco.class)
    @PutMapping(path="/{enderecoId}")
    @ResponseStatus(HttpStatus.OK)
    public Endereco updateEndereco(@ApiParam(value = "ID do endereço", required = true)
    		@PathVariable Long enderecoId, @RequestBody Endereco enderecoRequest) {
        return enderecoRepository.findById(enderecoId).map(endereco -> {
        	endereco.setStreetName(enderecoRequest.getStreetName());
        	endereco.setNumber(enderecoRequest.getNumber());
        	endereco.setComplement(enderecoRequest.getComplement());
        	endereco.setNeighbourhood(enderecoRequest.getNeighbourhood());
        	endereco.setCity(enderecoRequest.getCity());
        	endereco.setState(enderecoRequest.getState());
        	endereco.setCountry(enderecoRequest.getCountry());
        	endereco.setZipcode(enderecoRequest.getZipcode());
        	endereco.setLatitude(enderecoRequest.getLatitude());
        	endereco.setLongitude(enderecoRequest.getLongitude());
            return enderecoRepository.save(endereco);
        }).orElseThrow(() -> new ResourceNotFoundException("EnderecoId " + enderecoId + " not found"));
    }

    @ApiOperation(value = "Delete Endereço",
    		notes="Deleta um endereço no banco através de seu ID",
    		response = Endereco.class)
    @DeleteMapping(path="/{enderecoId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteEndereco(@ApiParam(value = "ID do endereço", required = true)
    		@PathVariable Long enderecoId) {
        return enderecoRepository.findById(enderecoId).map(endereco -> {
        	enderecoRepository.delete(endereco);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("EnderecoId " + enderecoId + " not found"));
    }
    
    @ApiOperation(value = "Busca Endereço",
    		notes="Busca um Endereço no banco através de seu ID",
    		response = Endereco.class)
    @GetMapping(path="/{enderecoId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Endereco> getUser(@ApiParam(value = "ID do endereço", required = true)
    		@PathVariable Long enderecoId) {
        return enderecoRepository.findById(enderecoId);
    }
    
}
