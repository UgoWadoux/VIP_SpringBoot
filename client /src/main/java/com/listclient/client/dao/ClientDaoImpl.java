//package com.listclient.client.dao;
//
//import com.listclient.client.model.Client;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.client.RestTemplate;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//@Repository
//public class ClientDaoImpl implements ClientDao{
//    ArrayList<Client> clientListing = new ArrayList<Client>() {
//        {
//            try {
//                add(new Client(1, "Trop de miel", "Kylian", new SimpleDateFormat("yyyy-MM-dd XXX").parse("2004-05-19 +00:00"), "kykstop12"));
//                add(new Client(2, "Degouilles", "Math", new SimpleDateFormat("yyyy-MM-dd XXX").parse("1999-05-11 +00:00"), "DSLPASID"));
//                add(new Client(3, "Pelleteuse", "Bastien",new SimpleDateFormat("yyyy-MM-dd XXX").parse("1998-06-04 +00:00"), "bastosid74"));
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    };
//    @Override
//    public ArrayList<Client> findAll() {
//        return clientListing;
//    }
//
//    @Override
//    public Client findById(int id) {
//        for (Client client : clientListing){
//            if (client.getId()==id){
//                return client;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Client add(Client client) {
//        clientListing.add(client);
//        return client;
//    }
//
//    @Override
//    public Client removeById(int id) {
//        Client clientRemoved = null;
//        for (Client client : clientListing){
//            if (client.getId()==id){
//                clientRemoved = client;
//                clientListing.remove(clientRemoved);
//                return clientRemoved;
//            }
//        }
//        return clientRemoved ;
//    }
//
//    @Override
//    public Client modify(int id, Client client) {
//        Client modifyClient = findById(id);
//        modifyClient.setFirstNam(client.getFirstNam());
//        modifyClient.setLastName(client.getLastName());
//        modifyClient.setAnniversary(client.getAnniversary());
//        modifyClient.setLicenseNumber(client.getLicenseNumber());
//        return modifyClient;
//    }
//
//
//}
