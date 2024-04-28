package com.clientms.client.controllers;

import com.clientms.client.dtos.ClientDto;
import com.clientms.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/id")
    public ResponseEntity<ClientDto> getClientById(@RequestParam long id){
        return this.clientService.getClientById(id);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClients(){
        return this.clientService.getAllClients();
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto){
        return this.clientService.createClient(clientDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable long id,
                                                  @RequestBody ClientDto clientDto){
        return this.clientService.updateClient(id, clientDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDto> deleteClient(@PathVariable long id){
        return this.clientService.deleteClient(id);
    }
}
