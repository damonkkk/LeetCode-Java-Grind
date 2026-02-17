package FileReader;

import java.util.ArrayList;
import java.util.Date;

public class Student {

    private final String name;
    private final Integer id;
    private final ArrayList<Double> results;

    public Student(String name, Integer id, ArrayList<Double> results) {
        this.name = name;
        this.id = id;
        this.results = results;
    }

    public String getName(){
        return name;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Double> getResults() {
        return this.results;
    }


    public double calculateAverage(Student a){
        int total = 0;
        for(double x: a.results){
            total+= x;
        }
        return total/a.results.size();
    }

    public void addGrade(Double grade){
        this.results.add(grade);
    }
}
