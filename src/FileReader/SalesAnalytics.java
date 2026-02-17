package FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SalesAnalytics {

    public static ArrayList<Sale> loadSalesData(String path){
        ArrayList<Sale> res = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))){
            String line;
            while((line= reader.readLine())!= null){
                String[] lineItems = line.split("\t");
                String id = lineItems[0];
                String name = lineItems[1];
                int price = Integer.parseInt(lineItems[2]);
                int quanity = Integer.parseInt(lineItems[3]);

                Sale item = new Sale(id,name,price,quanity);
                res.add(item);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        return res;

    }


    public static HashMap<String,Integer> calculateRevenueByProduct(ArrayList<Sale> sales){
        HashMap<String, Integer> res = new HashMap<>();
        if(sales==null||sales.isEmpty()){
            return res;
        }

        for(var s:sales){
            int exist = res.getOrDefault(s.getId(),0);
            res.put(s.getId(),exist+s.getTotalAmount());
        }


        return res;

    }
    public static void main(String[] args) {
        ArrayList<Sale> sales = loadSalesData("sales.tsv");
        HashMap<String, Integer> revenue = calculateRevenueByProduct(sales);

        // Print revenue per product
        for (String id : revenue.keySet()) {
            System.out.println("Product " + id + ": $" + revenue.get(id));
        }

        // Find best-selling product
        String bestId = null;
        for (String id : revenue.keySet()) {
            if (bestId == null || revenue.get(id) > revenue.get(bestId)) {
                bestId = id;
            }
        }

        if (bestId != null) {
            System.out.println("Best product: " + bestId + " with $" + revenue.get(bestId));
        }
    }



}
