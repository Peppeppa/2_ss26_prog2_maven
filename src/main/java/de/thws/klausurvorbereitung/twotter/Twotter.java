package de.thws.klausurvorbereitung.twotter;

import java.util.ArrayList;
import java.util.List;

public class Twotter {
//    public static void main(String[] args) {
//        List<User> ul = new ArrayList<>();
//        User a = new User("1", "a");
//        User b = new User("2", "b");
//        User c = new User("3", "c");
//        User d = new User("4", "d");
//        ul.add(a);
//        ul.add(b);
//        ul.add(c);
//        ul.add(d);
//        UserManager manager = new UserManager();
//        manager.serialize(ul);
//
//        List<User> test2 = new ArrayList<>(manager.deserialize());
//        System.out.println(test2);
//    }


    public static void main(String[] args)
    {
        TwotterSystem system = new TwotterSystem();
        User u = new User("joe", "joeRus!");
        system.addMessage(u,
                new Message("Hello World!"));
        List<Message> a = system.getAllMessages();
//        List<Message> m =
//                system.getAllMessagesFromDate(
//                        "2019-05-31");
        List<Message> d =
                system.getAllMessagesFromUser(u);
    }
}
