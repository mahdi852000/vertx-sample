package org.example.vertex.connector;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;

public class DummyConnector extends AbstractVerticle implements Connector{
    @Override
    public Future<String> fetchData() {
        Promise<String> promise = Promise.promise();
        new Thread(() ->{
            try {
                Thread.sleep(1000);
                promise.complete("Dummy Data From My DummyConnector : ");
            }
            catch (InterruptedException e) {
                promise.fail(e);
            }
        }).start();
        return promise.future();
    }
}

// This approach is not optimal because Vert.x is designed based on event loops and
// non-blocking IO; therefore, it is not recommended to use new threads().
