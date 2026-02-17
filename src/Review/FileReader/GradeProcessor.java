package Review.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class GradeProcessor {


public static ArrayList<Student> readStudentsFromFile(String path){
    ArrayList<Student> res = new ArrayList<>();

   try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))){
       String line;

       while((line= reader.readLine()) != null){
           String[] parts = line.split(",");
           int id = Integer.parseInt(parts[0]);
           String name = parts[1];

           ArrayList<Double> grades = new ArrayList<>();
           for(int i = 2; i < parts.length;i++){
               grades.add(Double.parseDouble(parts[i]));
           }
           res.add(new Student(name,id,grades));
       }
   }

     catch (Exception e) {
        throw new RuntimeException(e);
    }


    return res;

}

}
