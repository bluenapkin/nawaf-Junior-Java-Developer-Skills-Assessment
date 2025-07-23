public class PayrollCalculator {

    // Find weekly pay
    public static double getPay(String type, double hours, double rate) {
        if (hours < 0 || rate < 0) {
            System.out.println("Wrong input: negative number.");
            return 0;
        }

        switch (type) {
            case "FULL_TIME":
                if (hours <= 40) {
                    return hours * rate;
                } else {
                    double extra = (hours - 40) * (rate * 1.5);
                    return (40 * rate) + extra;
                }

            case "PART_TIME":
                return Math.min(hours, 25) * rate;

            case "CONTRACTOR":
                return hours * rate;

            case "INTERN":
                return Math.min(hours, 20) * (rate * 0.8);

            default:
                System.out.println("Type not found: " + type);
                return 0;
        }
    }

    // Find tax amount
    public static double getTax(double pay, boolean health) {
        double tax;

        if (pay <= 500) {
            tax = pay * 0.10;
        } else if (pay <= 1000) {
            tax = pay * 0.15;
        } else if (pay <= 2000) {
            tax = pay * 0.20;
        } else {
            tax = pay * 0.25;
        }

        if (health) {
            tax -= 50;
        }

        return Math.max(0, tax);
    }

    // Do pay for many users
    public static void doAllPay(String[] types, double[] hours, double[] rates, String[] names) {
        int size = Math.min(Math.min(types.length, hours.length), Math.min(rates.length, names.length));

        double total = 0;
        double high = Double.MIN_VALUE;
        double low = Double.MAX_VALUE;
        String highName = "";
        String lowName = "";
        int countOver = 0;

        System.out.printf("%-10s %-12s %-8s %-8s %-10s%n", "Name", "Type", "Hours", "Rate", "Pay");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < size; i++) {
            double pay = getPay(types[i], hours[i], rates[i]);
            total += pay;

            if (pay > high) {
                high = pay;
                highName = names[i];
            }

            if (pay < low) {
                low = pay;
                lowName = names[i];
            }

            if (hours[i] > 40) {
                countOver++;
            }

            System.out.println("%-10s %-12s %-8.1f %-8.2f $%-10.2f%n"+ names[i]+ types[i]+ hours[i]+ rates[i]+ pay);
        }

        double avg = total / size;

        System.out.println("Pay Info");
        System.out.println("Total People: " + size);
        System.out.println("Avg Pay:"+ avg);
        System.out.println("Most Pay:"+ highName+ high);
        System.out.println("Least Pay:"+ lowName+ low);
        System.out.println("With Extra Hours: " + countOver);
    }

    // Start point
    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"nawaf", "nawal", "nouf", "reem", "abdullah"};

        System.out.println("One Person Example ");
        double pay = getPay("FULL_TIME", 45, 25.0);
        double tax = getTax(pay, true);
        System.out.print("Pay:"+ pay);
        System.out.println("Tax"+ tax);

        System.out.println("--- All People Pay ---");
        doAllPay(types, hours, rates, names);
    }
}
