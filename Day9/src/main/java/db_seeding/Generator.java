package db_seeding;

import org.apache.commons.lang3.RandomStringUtils;

public class Generator {
    public static String generateLogin(int loginInclusiveMinimum, int loginExclusiveMaximum) {
        return RandomStringUtils.randomAlphabetic(loginExclusiveMaximum);
    }

    public static String generatePassword(int passwordInclusiveMinimum, int passwordExclusiveMaximum) {
        return RandomStringUtils.randomAlphabetic(passwordExclusiveMaximum);
    }
}
