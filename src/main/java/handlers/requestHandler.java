package handlers;

import java.util.Map;

public interface requestHandler {
    boolean handleRequest(Map<String, String> details);
}
