package br.com.besistemagif.domains.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientsController {

    @Autowired
    ClientsRepository clientsRepository;

    @GetMapping
    public List<ClientsEntity> get() {
        return clientsRepository.findAll();
    }

    @PostMapping
    public ClientsEntity save(@RequestBody ClientsEntity client){
        return clientsRepository.save(client);
    }
}
