package org.example;
import java.util.ArrayList;
import java.util.List;

public class TransactionProcessor {

    public static List<Transaction> parseSalesData(List<String> data) {
        List<Transaction> list = new ArrayList<>();

        for (String line : data) {
            if (line.startsWith("#") || line.trim().isEmpty())
                continue;

            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0].trim());
            String item = parts[1].trim();
            int qty = Integer.parseInt(parts[2].trim());
            double price = Double.parseDouble(parts[3].trim());

            list.add(new Transaction(id, item, qty, price));
        }

        return list;
    }

    public static double getTotalSales(List<Transaction> list) {
        double total = 0;

        for (Transaction t : list) {
            total += t.getTotal();
        }

        return total;
    }
}