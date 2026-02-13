package Review.Q7;

import Review.Q6.InsurancePremiumCalculator.IndividualPolicyholder;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    public static ArrayList<Integer> analyzeNumbers(List<List<Integer>> numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        if(numbers == null){
            return result;
        }
        for(List<Integer> list: numbers){
            if (list==null|| list.isEmpty()){
                continue;
            }
            int sum = 0;
            int max = list.get(0);
            for(int i =0; i<list.size();i++){
                sum+= list.get(i);
            }
            for(Integer i : list){
                if(i>= max){
                    max = i;
                }
            }
            if(max>sum){
                result.add(sum);
                result.add(max);
            } else {
                result.add(max);
                result.add(sum);
            }
        }

        return result;
    }
}