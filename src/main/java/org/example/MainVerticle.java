package org.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import org.example.vertex.connector.Connector;
import org.example.vertex.connector.DummyConnector;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        Connector connector = new DummyConnector();
        connector.fetchData().onSuccess(data -> {
            System.out.println("Received Data : " + data);
        }).onFailure(err -> {
            System.out.println("Failed to fetch Data :" + err.getMessage());
        });
    }

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MainVerticle());
    }
}