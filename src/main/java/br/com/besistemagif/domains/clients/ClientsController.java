package br.com.besistemagif.domains.clients;

import br.com.besistemagif.infrastructure.response.ResponseRequest;
import br.com.besistemagif.utils.ValidateAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseRequest save(@RequestBody ClientsEntity newClient) {
        ResponseRequest response = new ResponseRequest();
        try {
            if(!ValidateAge.toValid(newClient)) {
                throw new Exception("Data de Nascimento inválida");
            }
            ClientsEntity clients = clientsRepository.save(newClient);
            response.setData(clients);
            response.setError(null);
        } catch (Exception error) {
            response.setData(null);
            response.setError(error.getMessage());
        }
        return response;
    }

    @PatchMapping
    public ResponseRequest update(@RequestBody ClientsEntity updateClient) {
        ResponseRequest response = new ResponseRequest();
        try {
            if(!ValidateAge.toValid(updateClient)) {
                throw new Exception("Data de Nascimento inválida");
            }
            ClientsEntity clients = clientsRepository.findById(updateClient.getId()).get();
            clients.setBirthDate(updateClient.getBirthDate());
            clients.setEmail(updateClient.getEmail());
            clients.setName(updateClient.getName());
            clients.setGender(updateClient.getGender());

            clients = clientsRepository.save(clients);

            response.setData(clients);
            response.setError(null);
        } catch (Exception error) {
            response.setData(null);
            response.setError(error.getMessage());
        }
        return response;
    }

    @DeleteMapping
    public ResponseRequest delete(@RequestBody ClientsEntity deleteClient) {
        ResponseRequest response = new ResponseRequest();
        try {
            clientsRepository.deleteById(deleteClient.getId());
            response.setData(deleteClient);
            response.setError(null);
        } catch (Exception error) {
            response.setData(null);
            response.setError(error.getMessage());
        }
        return response;
    }
}
