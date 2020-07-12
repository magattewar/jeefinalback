package com.magattewar.projetniassback.controller;


import com.magattewar.projetniassback.model.Client;
import com.magattewar.projetniassback.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController

@CrossOrigin(origins = {"http://localhost:4200", "https://localhost:4200"})
@RequestMapping("/api")
@Transactional
public class ClientResource {

    private final Logger log = LoggerFactory.getLogger(ClientResource.class);



    @Autowired
    private final ClientRepository clientRepository;

    public ClientResource(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @PostMapping("/clients/add")
    public List<Client> createClient(@RequestBody Client client) throws URISyntaxException {
        log.debug("REST request to save Client : {}", client);
        clientRepository.save(client);
        return clientRepository.findAll();
    }

    @GetMapping("/clients/all")
    public List<Client> getAll(){
        return clientRepository.findAll();
    }


    @PutMapping("/clients")
    public List<Client> updateClient(@RequestBody Client client) throws URISyntaxException {
        log.debug("REST request to update Client : {}", client);
        if (client.getId() == null) {

            return clientRepository.findAll();
        }
        Client result = clientRepository.save(client);
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public Optional<Client> getClient(@PathVariable Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client;
    }

    @DeleteMapping("/clients/{id}")
    public List<Client> deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return clientRepository.findAll();
    }
}
