package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BacaReader {

    // Method untuk membaca file dan mengembalikan hasilnya sebagai List<String>
    public List<String> readFromFile(String filePath) {
        List<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("#")) continue;
                data.add(line);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }

        return data;
    }
}
