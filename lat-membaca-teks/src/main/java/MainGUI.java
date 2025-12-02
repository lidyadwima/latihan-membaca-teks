package org.example;
import org.example.Transaction;
import org.example.SalesReader;
import org.example.SalesReport;
import org.example.TransactionProcessor;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainGUI {
    List<org.example.Transaction> transactions = new ArrayList<>();
    org.example.SalesReader reader = new org.example.SalesReader();
    org.example.TransactionProcessor processor = new org.example.TransactionProcessor();
    org.example.SalesReport report = new org.example.SalesReport();

    public void start() {
        JFrame frame = new JFrame("Sales Report");
        frame.setSize(700, 500);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());

        JButton loadButton = new JButton("Load Sales File");
        JButton generateButton = new JButton("Generate Report");
        topPanel.add(loadButton);
        topPanel.add(generateButton);

        String[] columns = new String[]{"ID", "Nama", "Qty", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JLabel label3 = new JLabel("Total : 0");

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(label3, BorderLayout.SOUTH);

        loadButton.addActionListener(e -> {
            List<String> salesData = reader.readFromFile("sales.txt");
            transactions = processor.parseSalesData(salesData);

            for(org.example.Transaction t : transactions) {
                tableModel.addRow(new Object[] {t.id, t.item, t.quantity, t.price});
            }
            double revenue = transactions.stream().mapToInt(t -> (int) (t.quantity * t.price)).sum();

            label3.setText("Total : " + revenue);
        });

        generateButton.addActionListener(e -> {
            double total = processor.getTotalSales(transactions);
            report.writeReport("report.txt", transactions, total);

            JOptionPane.showMessageDialog(frame, "Laporan Berhasil");
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI().start();
    }
}