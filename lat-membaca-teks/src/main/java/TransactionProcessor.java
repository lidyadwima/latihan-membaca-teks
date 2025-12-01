package org.example;

import java.util.ArrayList;
import java.util.List;

public class TransactionProcessor {

    // Method untuk mengubah List<String> menjadi List<Transaction>
    public List<org.example.Transaction> parseBacaData(List<String> bacaData) {
        List<org.example.Transaction> transactions = new ArrayList<>();

        for (String line : bacaData) {
            try {
                // Misal format file: id,name,quantity,price
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());
                double price = Double.parseDouble(parts[3].trim());

                // Buat objek Transaction dan tambahkan ke list
                org.example.Transaction t = new org.example.Transaction(id, name, quantity, price);
                transactions.add(t);
            } catch (Exception e) {
                System.out.println("Baris tidak valid: " + line);
            }
        }

        return transactions;
    }
}
