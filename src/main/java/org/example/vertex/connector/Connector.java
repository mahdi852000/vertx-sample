package org.example.vertex.connector;

import io.vertx.core.Future;

public interface Connector {
    Future<String> fetchData();
}

