package de.thws.klausurvorbereitung.twotter;

import java.io.*;
import java.util.List;

public class UserManager implements ObjectManager<User>{

    @Override
    public void serialize(List<User> object) throws RuntimeException{

        try(ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("user.dat"))){
            oos.writeObject(object);
        }catch (IOException e) {

            throw new RuntimeException("Fehler beim serialisieren", e);

        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> deserialize() throws RuntimeException{

        try(ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("user.dat"))){

            return (List<User>) ois.readObject();
        }catch(IOException | ClassNotFoundException e){
            throw new RuntimeException("Fehler beim Deserialisieren", e);
        }
    }
}
