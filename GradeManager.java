public class GradeManager {

    // Reverse names
    public static String[] reverseNames(String[] names) {
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String rev = "";
            for (int j = name.length() - 1; j >= 0; j--) {
                rev += name.charAt(j);
            }
            result[i] = rev;
        }
        return result;
    }

    // Get grade from score
    public static char getGrade(int score) {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        return 'F';
    }

    // Find who failed
    public static String[] getFailing(String[] names, int[] scores) {
        int count = 0;
        for (int s : scores) {
            if (s < 60) count++;
        }

        String[] fail = new String[count];
        int idx = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                fail[idx] = names[i];
                idx++;
            }
        }
        return fail;
    }

    // Run the app
    public static void main(String[] args) {
        String[] names = {"Ali", "Sara", "Khalid", "Lama"};
        int[] scores = {95, 72, 58, 45};

        System.out.println("== Reversed Names ==");
        String[] rev = reverseNames(names);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " -> " + rev[i]);
        }

        System.out.println("\n== Grades ==");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + getGrade(scores[i]));
        }

        System.out.println("\n== Failed Students ==");
        String[] failed = getFailing(names, scores);
        for (String f : failed) {
            System.out.println(f + " failed.");
        }
    }
}
