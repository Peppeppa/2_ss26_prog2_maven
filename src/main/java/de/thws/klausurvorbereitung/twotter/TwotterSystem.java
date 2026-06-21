package de.thws.klausurvorbereitung.twotter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwotterSystem {

     Map<User, Message> umliste = new HashMap<>();

    public List<Message>getAllMessages(){

        List<Message> result = new ArrayList<>();
        umliste.values().stream()
                .forEach(s ->result.add(s));
        return result;

    }
//    public List<Message>getAllMessagesFromDate(String createionDate){
//
//        umliste.values().stream()
//                .map(s -> s.getCreationDate())
//
//        return null;
//    }
    public List<Message>getAllMessagesFromUser(User u){

        List<Message> result = new ArrayList<>();
        result.add(umliste.get(u));
        return result;
    }
    public void addMessage(User u, Message m){

        this.umliste.put(u, m);

    }
}
