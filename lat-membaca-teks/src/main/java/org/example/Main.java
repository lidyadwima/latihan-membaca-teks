package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> salesData = org.example.SalesReader.readFromFile("sales.txt");

        List<org.example.Transaction> transactionData = org.example.TransactionProcessor.parseSalesData(salesData);

        double total = org.example.TransactionProcessor.getTotalSales(transactionData);

        org.example.SalesReport.writeReport("report.txt", transactionData, total);

        System.out.println("Laporan berhasil dibuat, Cek report.txt");

        for(String data : salesData) {
            System.out.println(data);
        }
    }
}