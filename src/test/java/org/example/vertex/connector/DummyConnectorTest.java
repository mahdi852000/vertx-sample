package org.example.vertex.connector;

import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(VertxExtension.class)
public class DummyConnectorTest {

    @Test
    void testVerticleDeployment(Vertx vertx, VertxTestContext testContext) {
        vertx.deployVerticle((Verticle) new DummyConnector(), testContext.succeeding(id -> {
            System.out.println("Verticle deployed with Id : " + id);
         testContext.completeNow();}));
    }
    @Test
    void testFetchData(Vertx vertx, VertxTestContext testContext) {
        DummyConnector connector = new DummyConnector();

        connector.fetchData().onComplete(ar -> {
            if (ar.succeeded()) {
                System.out.println("Received: " + ar.result());
                testContext.completeNow();
            } else {
                testContext.failNow(ar.cause());
            }
        });
    }

}
