package group28;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class Faker {

    private static Random random = new Random();

    public static FinancialSupportForm getFakeFinancialSupportForm() {
        return new FinancialSupportForm(0,
            getRandomFirstName(),
            getRandomLastName(),
            getRandomSSN(),
            getRandomEmail(),
            getRandomFirstName(),
            getRandomLastName(),
            getRandomDateOfBirth(),
            getRandomAlienNumber(),
            getRandomEmail());
    }

    public static String getRandomFirstName() {
        return getRandomItem(new String[] {
            "John", "Jane", "Derek", "Diana",
            "George", "Donald", "Georgina", "Travis",
            "Luther", "Mark", "Shane", "Prince"
        });
    }

    public static String getRandomLastName() {
        return getRandomItem(new String[] {
            "Smith", "Doe", "Flanders", "Rockwell",
            "Tiny", "Jackson", "Tynell", "Rich",
            "Ahab", "Newman", "Brighton", "Wallace"
        });
    }

    // All SSNs that begin with 000 are invalid.
    // We will generate invalid SSNs only, to avoid weird situations.
    public static String getRandomSSN() {
        String result = "000-";
        result += random.nextInt(10);
        result += random.nextInt(10);
        result += "-";
        result += random.nextInt(10);
        result += random.nextInt(10);
        result += random.nextInt(10);
        result += random.nextInt(10);
        return result;
    }

    public static String getRandomEmail() {
        String[] words = {
            "Fish", "Fruit", "Waffle", "Pancake", "Garage", "Music",
            "Dusty", "Adventure", "Joy", "Long", "Cool", "Panda",
            "Guitar", "Tooter", "Salmon", "Quake", "Roblox"
        };
        String[] domains = {
            "gmail.com", "hotmail.com", "outlook.com", "gmu.edu",
            "aol.com", "yahoo.co.uk", "msn.com"
        };

        String result = "";
        result += getRandomItem(words);
        result += getRandomItem(words);
        result += random.nextInt(10);
        result += random.nextInt(10);
        result += "@";
        result += getRandomItem(domains);
        return result;
    }

    public static String getRandomAlienNumber() {
        String result = "";
        int hyphenChance = 0;
        int hyphenFrequency = 1;
        int length = getRandomBoundedInt(8, 13);
        for (int i=0; i<length; i ++) {
            if (random.nextInt(10) <= hyphenChance) {
                result += "-";
                hyphenChance = 0;
            } else {
                result += random.nextInt(10);
                hyphenChance += hyphenFrequency;
            }
        }
        return result;
    }

    public static Date getRandomDateOfBirth(int minYearsOld, int maxYearsOld) {
        long epochMs = Instant.now().toEpochMilli();
        long yearInMs = 1000 * 60 * 60 * 24 * 365;
        int age = getRandomBoundedInt(minYearsOld, maxYearsOld);
        Date dob = new Date(epochMs - (yearInMs * age));
        return dob;
    }

    public static Date getRandomDateOfBirth() {
        return getRandomDateOfBirth(18, 111);
    }

    public static <T> T getRandomItem(T[] array) {
        return array[random.nextInt(array.length)];
    }

    // inclusive
    public static int getRandomBoundedInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}