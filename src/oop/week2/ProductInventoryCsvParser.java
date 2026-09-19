package oop.week2;

public class ProductInventoryCsvParser {
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        String product = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();
        System.out.printf("Product: %s | SKU: %s | Qty: %s\n", product, sku, qty);
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse, WM-2201,150");
        parseInventoryRecord("Wireless Mouse, 150");
    }
}