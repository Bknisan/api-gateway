package repository;

import handlers.loginHandler;
import handlers.registerHandler;
import handlers.requestHandler;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static common.commonConstraints.*;

@Repository
public class handlersRepository {
    private Map<String, requestHandler> handlers;

    public handlersRepository() {
        this.handlers = new HashMap<>();
        inIt();
    }

    private void inIt() {
        this.handlers.put(LOGIN, new loginHandler());
        this.handlers.put(REGISTER, new registerHandler());
    }

    public requestHandler getHandler(String request) {
        return this.handlers.get(request);
    }
}
