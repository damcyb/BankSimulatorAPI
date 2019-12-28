package BankSimulatorAPI.shared;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPRSTUVWXYZabcdefghijklmnoprstuvwxyz";

    public String generatePublicUserId(int length) {
        String userId = generateUserId(length);
        return userId;
    }

    private String generateUserId(int length) {
        StringBuilder userId = new StringBuilder();
        for(int i = 0; i < length; i++) {
            userId.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(userId);
    }

}
