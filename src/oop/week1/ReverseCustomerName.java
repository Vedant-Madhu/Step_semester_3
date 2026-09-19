package oop.week1;

public class ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        if (customerName == null)
            return null;
        char[] arr = customerName.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String name = "Sunil";
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reverseCustomerName(name));
    }
}