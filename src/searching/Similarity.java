package searching;

import code_clone.CosineSimilarity;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static searching.TfIdfCalculate.queryTfIdfVector;

public class Similarity {

    public static HashMap<String, Double> SortDescending = new HashMap<>();

    public void getCosine() {

        double similarity = 0;
        for (int i = 0; i < Search.ProjectFileName.size(); i++) {
            int count = 0;
            double[] similar;
            similar = new double[TfIdfCalculate.queryTfIdfVector.size()];

            for (int j = 0; j < queryTfIdfVector.size(); j++) {
                similarity = new CosineSimilarity().cosineSimilarity(TfIdfCalculate.tfidfvectorProject.get(i), TfIdfCalculate.queryTfIdfVector.get(j));
                //  System.out.println(Search.ProjectFileName.get(i) + "=" + similarity);
                if (similarity > 0) {
                    SortDescending.put(Search.ProjectFileName.get(i), similarity);

                }

            }

        }
    }

    public void getResult() {
        if(SortDescending.isEmpty()){
            System.out.println("\tSearch query not found");
        }
        LinkedHashMap<String, Double> reverseSorted = new LinkedHashMap<>();
        SortDescending.entrySet()
                .stream()
                .sorted(HashMap.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSorted.put(x.getKey(), x.getValue()));

        //System.out.println("");
        // System.out.println("");
        for (Map.Entry<String, Double> pair : reverseSorted.entrySet()) {

            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        SortDescending.clear();

    }

}
