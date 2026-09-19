package oop.week4;

class Canteen implements Comparable<Canteen> {
    private String canteenCode;
    private String canteenName;
    private int trustScore;

    public Canteen(String canteenCode, String canteenName, int trustScore) {
        this.canteenCode = canteenCode;
        this.canteenName = canteenName;
        this.trustScore = trustScore;
    }

    public Canteen(String canteenCode, String canteenName) {
        this(canteenCode, canteenName, 3);
    }

    @Override
    public int compareTo(Canteen other) {
        if (this.trustScore != other.trustScore) {
            return Integer.compare(other.trustScore, this.trustScore);
        }
        int codeCmp = this.canteenCode.compareToIgnoreCase(other.canteenCode);
        if (codeCmp != 0)
            return codeCmp;
        return this.canteenName.compareTo(other.canteenName);
    }

    public static Canteen[] rankCanteens(Canteen[] canteens) {
        if (canteens == null)
            return new Canteen[0];
        Canteen[] sorted = canteens.clone();
        for (int i = 0; i < sorted.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[j].compareTo(sorted[min]) < 0)
                    min = j;
            }
            if (min != i) {
                Canteen t = sorted[i];
                sorted[i] = sorted[min];
                sorted[min] = t;
            }
        }
        return sorted;
    }

    public String getCanteenCode() {
        return canteenCode;
    }
}

public class AssignmentP3_Canteen {
    public static void main(String[] args) {
        Canteen[] c = { new Canteen("HB3-C", "Spice Junction", 3), new Canteen("hb1-c", "Grand Mess", 5),
                new Canteen("HB2-C", "Southern Treats") };
        Canteen[] ranked = Canteen.rankCanteens(c);
        System.out.print("[");
        for (int i = 0; i < ranked.length; i++)
            System.out.print("\"" + ranked[i].getCanteenCode() + "\"" + (i < ranked.length - 1 ? ", " : ""));
        System.out.println("]");
    }
}