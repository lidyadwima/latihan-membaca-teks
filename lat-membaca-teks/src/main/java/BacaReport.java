package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class BacaReport {

    // Menampilkan laporan ke console
    public void printReport(List<org.example.Transaction> transactions) {

        System.out.println("Transaction Report");
        System.out.println("Generated at: " + LocalDateTime.now());
        System.out.println("------------------------------------------------------");
        System.out.println(String.format("%-5s %-15s %5s %12s %12s",
                "ID", "Item", "Qty", "Price", "Total"));
        System.out.println("------------------------------------------------------");

        double grandTotal = 0;

        for (org.example.Transaction t : transactions) {
            double total = t.getTotal();
            grandTotal += total;

            System.out.println(String.format(
                    "%-5d %-15s %5d %,12.0f %,12.0f",
                    t.getId(),
                    t.getName(),
                    t.getQuantity(),
                    t.getPrice(),
                    total
            ));
        }

        System.out.println("------------------------------------------------------");
        System.out.println(String.format("Grand Total: Rp %, .0f", grandTotal));
        System.out.println("------------------------------------------------------");
    }

    // Menyimpan laporan ke file teks
    public void writeReport(String filename, List<org.example.Transaction> transactions) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            writer.write("Transaction Report\n");
            writer.write("Generated at: " + LocalDateTime.now() + "\n");
            writer.write("------------------------------------------------------\n");
            writer.write(String.format("%-5s %-15s %5s %12s %12s\n",
                    "ID", "Item", "Qty", "Price", "Total"));
            writer.write("------------------------------------------------------\n");

            double grandTotal = 0;

            for (org.example.Transaction t : transactions) {
                double total = t.getTotal();
                grandTotal += total;

                writer.write(String.format(
                        "%-5d %-15s %5d %,12.0f %,12.0f\n",
                        t.getId(),
                        t.getName(),
                        t.getQuantity(),
                        t.getPrice(),
                        total
                ));
            }

            writer.write("------------------------------------------------------\n");
            writer.write(String.format("Grand Total: Rp %, .0f\n", grandTotal));
            writer.write("------------------------------------------------------\n");

            System.out.println("Report berhasil disimpan ke: " + filename);

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis file: " + e.getMessage());
        }
    }
}
