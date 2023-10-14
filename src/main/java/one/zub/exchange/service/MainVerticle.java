package one.zub.exchange.service;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainVerticle extends AbstractVerticle {

    private static final Logger LOG = LogManager.getLogger(MainVerticle.class);

    @Override
    public void start(Promise<Void> startPromise) {
        vertx.createHttpServer().requestHandler(req -> req
            .response()
            .putHeader("content-type", "text/plain")
            .end("Hello from Vert.x!")
        ).listen(8888, http -> {
            if (http.succeeded()) {
                startPromise.complete();
                LOG.info("HTTP server started on port 8888");
            } else {
                startPromise.fail(http.cause());
            }
        });
    }
}
