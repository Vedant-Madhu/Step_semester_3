package oop.week4;

class BusRoute implements Comparable<BusRoute> {
    private String routeCode;
    private String routeName;
    private int priority;

    public BusRoute(String routeCode, String routeName, int priority) {
        this.routeCode = routeCode;
        this.routeName = routeName;
        this.priority = priority;
    }

    public BusRoute(String routeCode, String routeName) {
        this(routeCode, routeName, 3);
    }

    @Override
    public int compareTo(BusRoute other) {
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        }
        int codeCmp = this.routeCode.compareToIgnoreCase(other.routeCode);
        if (codeCmp != 0) {
            return codeCmp;
        }
        return this.routeName.compareTo(other.routeName);
    }

    public static BusRoute[] rankRoutes(BusRoute[] routes) {
        if (routes == null)
            return new BusRoute[0];
        BusRoute[] sorted = routes.clone();
        for (int i = 0; i < sorted.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[j].compareTo(sorted[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                BusRoute temp = sorted[i];
                sorted[i] = sorted[min];
                sorted[min] = temp;
            }
        }
        return sorted;
    }

    public String getRouteCode() {
        return routeCode;
    }
}

public class PracticeP3_BusRoute {
    public static void main(String[] args) {
        BusRoute[] routes = {
                new BusRoute("RT205L", "Airport Express", 3),
                new BusRoute("rt201j", "City Central", 4),
                new BusRoute("RT299T", "Night Service")
        };
        BusRoute[] ranked = BusRoute.rankRoutes(routes);
        for (BusRoute r : ranked) {
            System.out.print(r.getRouteCode() + " ");
        }
    }
}