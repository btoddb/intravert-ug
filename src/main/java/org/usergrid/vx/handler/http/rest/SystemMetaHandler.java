package org.usergrid.vx.handler.http.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usergrid.vx.experimental.IntraReq;
import org.usergrid.vx.experimental.Operations;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.http.HttpServerRequest;

/**
 * REST Handler for listing non-system keyspaces via
 * {@link org.apache.cassandra.config.Schema#getNonSystemTables()}
 * 
 * @author zznate
 */
public class SystemMetaHandler extends IntraHandlerRest {
  private Logger log = LoggerFactory.getLogger(SystemMetaHandler.class);

  public SystemMetaHandler(Vertx vertx) {
    super(vertx);
  }

  @Override
  public void handleGet(final HttpServerRequest request, Buffer buffer, IntraReq req) {
    req.add(Operations.listKeyspacesOp());
  }
}
