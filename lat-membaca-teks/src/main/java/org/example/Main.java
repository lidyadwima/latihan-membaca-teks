package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        org.example.BacaReader reader = new org.example.BacaReader();
        List<String> bacaData = reader.readFromFile(
                "C:\\Users\\U S E R\\Documents\\GitHub\\latihan-membaca-teks\\lat-membaca-teks\\src\\main\\java\\baca.txt"
        );

        org.example.TransactionProcessor processor = new org.example.TransactionProcessor();
        List<org.example.Transaction> transactionData = processor.parseBacaData(bacaData);

        // Membuat objek report
        org.example.BacaReport report = new org.example.BacaReport();

        // Menampilkan ke console
        report.printReport(transactionData);

        // Menulis ke file jika mau
        report.writeReport("transaction-report.txt", transactionData);
    }
}
