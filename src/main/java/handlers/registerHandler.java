package handlers;

import java.util.Map;

import static common.commonConstraints.*;

public class registerHandler implements requestHandler {

    @Override
    public boolean handleRequest(Map<String, String> details) {
        if (alreadyExist(details)) {
            return false;
        }
        createUser(details.get(USER_NAME), details.get(PASSWORD), details.get(EMAIL));
        return true;
    }

    private boolean alreadyExist(Map<String, String> details) {
        return false;
    }


    public void createUser(String userName, String password, String email) {

    }
}
