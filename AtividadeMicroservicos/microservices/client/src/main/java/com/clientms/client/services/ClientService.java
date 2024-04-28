package com.clientms.client.services;

import com.clientms.client.dtos.ClientDto;
import com.clientms.client.entities.Client;
import com.clientms.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<ClientDto> getClientById(Long id) {
        Optional<Client> clientOp =  this.clientRepository.findById(id);
        return clientOp.map((client) -> new ResponseEntity<>( new ClientDto(client), HttpStatus.OK))
                        .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientDto> clientList = this.clientRepository.findAll().stream()
                                                                    .map(ClientDto::new).toList();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    public ResponseEntity<ClientDto> createClient(ClientDto clientDto) {
        Client newClient = this.clientRepository.save(new Client(clientDto));
        return ResponseEntity.ok(new ClientDto(newClient));
    }

    public ResponseEntity<ClientDto> updateClient(long id, ClientDto clientDto) {
        if( !this.clientRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Client newClient = new Client(clientDto);
        newClient.setId(id);
        newClient = this.clientRepository.save(newClient);
        return ResponseEntity.ok(new ClientDto(newClient));
    }

    public ResponseEntity<ClientDto> deleteClient(long id) {
        if( !this.clientRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        this.clientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
