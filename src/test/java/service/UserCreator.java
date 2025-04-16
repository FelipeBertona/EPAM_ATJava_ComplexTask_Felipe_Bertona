package service;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service for creating User objects.
 * Provides methods to create users with default or custom credentials.
 */
public class UserCreator {

    private static final Logger logger = LoggerFactory.getLogger(UserCreator.class);

    /**
     * Creates a User object with default credentials.
     *
     * @return a User object with default username and password
     */
    public static User createUser() {
        return new User("sampleUsername", "samplePassword");
    }

    /**
     * Creates a User object with custom credentials.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return a User object with the specified username and password
     */
    public static User createUser(String username, String password) {
        return new User(username, password);
    }
}