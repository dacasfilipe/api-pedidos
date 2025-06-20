
package com.pedidos.api.services;
import org.springframework.stereotype.Service;
import java.util.List;
import com.pedidos.api.models.Client;
import com.pedidos.api.repositorys.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }
    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }
    @Transactional
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
        // Handle any additional logic if needed
    }
    @Transactional
    public Client update(Long id, Client client) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found with id: " + id);
        }
        client.setId(id);
        return clientRepository.save(client);
    }
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return clientRepository.existsById(id);
    }
    
    @Transactional(readOnly = true)
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    public Client getClientById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClientById'");
    }
    public Client createClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        return clientRepository.save(client);
    }
    public Client updateClient(Long id, Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateClient'");
    }
    public void deleteClient(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteClient'");
    }
}
