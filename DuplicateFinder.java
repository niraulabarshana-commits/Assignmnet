import java.util.ArrayList;
import java.util.Arrays;

public class DuplicateFinder {
    public static void main(String[] args) {
        ArrayList<String> guests = new ArrayList<>(Arrays.asList(
                "Aarav", "Maya", "Sita", "Aarav", "Ram", "Maya", "Nabin", "Sita"
        ));

        System.out.println("Duplicate guest names:");

        for (int i = 0; i < guests.size(); i++) {
            boolean alreadyPrinted = false;

            for (int k = 0; k < i; k++) {
                if (guests.get(i).equals(guests.get(k))) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted) {
                continue;
            }

            for (int j = i + 1; j < guests.size(); j++) {
                if (guests.get(i).equals(guests.get(j))) {
                    System.out.println(guests.get(i));
                    break;
                }
            }
        }
    }
}

