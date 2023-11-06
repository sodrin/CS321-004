package group28;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class Faker {

    private static Random random = new Random();

    // Randomly selects a form inside the database
    // Returns that random form
    public static FinancialSupportForm getRandomRealFinancialSupportForm() {
        Integer[] keys = Database.masterDatabase.getKeys();
        int key = getRandomItem(keys);
        return Database.masterDatabase.getForm(key);
    }

    // Generates fake data and puts them in a new form
    // Returns the fake form
    public static FinancialSupportForm getFakeFinancialSupportForm() {
        return new FinancialSupportForm(
            getRandomFirstName(),
            getRandomLastName(),
            getRandomSSN(),
            getRandomEmail(),
            getRandomFirstName(),
            getRandomLastName(),
            getRandomDateOfBirth(),
            getRandomAlienNumber(),
            getRandomEmail()
        );
    }

    public static String getRandomFirstName() {
        return getRandomItem(new String[] {
            "John", "Jane", "Derek", "Diana",
            "George", "Donald", "Georgina", "Travis",
            "Luther", "Mark", "Shane", "Prince",
            "Fredrick", "Price", "Daniel", "Raul",
            "Selena", "James", "Lucas", "Ethan"
        });
    }

    public static String getRandomLastName() {
        return getRandomItem(new String[] {
            "Smith", "Doe", "Flanders", "Rockwell",
            "Tiny", "Jackson", "Tynell", "Rich",
            "Ahab", "Newman", "Brighton", "Wallace",
            "Kensington", "Dames", "Shagatov",
            "Kissinger", "Reston", "Murtons", "Neptar",
            "Nguyen", "Vasilovich", "Guy", "Merchant"
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
            "Guitar", "Tooter", "Salmon", "Quake", "Roblox", "Monster",
            "Tuber", "Fantasy", "Lawyer", "BBQ", "Fantastic", "Jupiter",
            "Loyal", "Gravel", "Druid", "Rain", "Flash", "Swivel"
        };
        String[] domains = {
            "gmail.com", "hotmail.com", "outlook.com", "gmu.edu",
            "aol.com", "yahoo.co.uk", "msn.com",
            "mail.biz", "free-email-now.xyz"
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
