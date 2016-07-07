package io.vertx.web.vertx;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.templ.ThymeleafTemplateEngine;
import io.vertx.web.WebApplication;
import io.vertx.web.domain.TbIDAuth;
import io.vertx.web.mapper.TbIDAuthMapper;

@Component
public class IDAuthMonitor extends AbstractVerticle {
	private static final Logger LOG = Logger.getLogger(IDAuthMonitor.class);

	@Autowired
	private TbIDAuthMapper tbIDAuthMapper;

	@Override
	public void start() throws Exception {

		HttpServer server = vertx.createHttpServer();
		Router router = Router.router(vertx);

		ThymeleafTemplateEngine engine = ThymeleafTemplateEngine.create();

		router.route("/monitor").blockingHandler(req -> {
			LOG.info(req.request().params());
			HttpServerResponse response = req.response();

			List<TbIDAuth> data = tbIDAuthMapper.selectALL();

			req.put("monitors", data);

			engine.render(req, "template/monitor.html", handler -> {
				if (handler.succeeded()) {
					response.end(handler.result());
				} else {
					req.fail(handler.cause());
				}
			});
		});

		router.route("/monitor/search").blockingHandler(req -> {
			LOG.info(req.request().params());
			String phone_number = req.request().getParam("phone_number");
			List<TbIDAuth> data = new ArrayList<TbIDAuth>();
			if ("".equals(phone_number) || phone_number == null) {
				data = tbIDAuthMapper.selectALL();
			} else {
				TbIDAuth auth = new TbIDAuth();
				auth.setPhone_number(phone_number);
				data = tbIDAuthMapper.selectByPhone(auth);
			}

			HttpServerResponse response = req.response();

			req.put("monitors", data);

			engine.render(req, "template/monitor.html", handler -> {
				if (handler.succeeded()) {
					response.end(handler.result());
				} else {
					req.fail(handler.cause());
				}
			});
		});

		server.requestHandler(router::accept).listen(8090);
	}
}
