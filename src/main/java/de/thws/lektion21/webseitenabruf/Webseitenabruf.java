package de.thws.lektion21.webseitenabruf;

import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Webseitenabruf {
    public static void main(String[] args) {
        Response response = ClientBuilder.newBuilder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .build()
                .target("https://jsonplaceholder.typicode.com/")
                .path("posts/1")
                .request(MediaType.APPLICATION_JSON)
                .get();

        String s = response.readEntity(String.class);

        System.out.println("HTTP Status: " + response.getStatus());
        System.out.println(s);

        response.close();
    }
}