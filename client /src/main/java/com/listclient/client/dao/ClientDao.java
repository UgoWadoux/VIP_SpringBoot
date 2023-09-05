package com.listclient.client.dao;

import com.listclient.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {
    Client findById(int id);
    Client deleteById(int id );
//    Client save(Client client);
//    Client save (int id, Client client);

//    ArrayList<Client> findAll();
//    Client findById(int id);
//    Client add (Client client);
//    Client removeById(int id);
//    Client modify(int id, Client client);

}
