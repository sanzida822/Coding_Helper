package code_clone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TfIdfCalculate {

    ArrayList<String[]> FileWordProject1 = new ArrayList<>();
    ArrayList<String[]> FileWordProject2 = new ArrayList<>();
    static ArrayList<double[]> tfidfvectorProject1 = new ArrayList<>();
    static ArrayList<double[]> tfidfvectorProject2 = new ArrayList<>();
    ArrayList<String> processProjectFile = new ArrayList<>();
    ArrayList<String> combineTerms = new ArrayList<>();
    HashMap<String, Double> idfmap = new HashMap<>();
    ArrayList<String> allterms1 = new ArrayList<>();
    ArrayList<String> allterms2 = new ArrayList<>();

    public String[] fileRead(String path) throws FileNotFoundException, IOException {
        File directoryPath = new File(path);
        StringBuilder sb1 = new StringBuilder();
        File fileList[] = directoryPath.listFiles();
        BufferedReader in = null;

        for (File file : fileList) {
            if (file.getName().endsWith(".txt")) {
                StringBuilder sb = new StringBuilder();
                in = new BufferedReader(new FileReader(file));
                String s = null;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                }
                // System.out.println("sb=" + sb);
                if (path.equals(CloneCheck.path1)) {
                 //  System.out.println("="+path);
                    FileWordProject1.add(sb.toString().trim().split(" "));

                }
                if (path.equals(CloneCheck.path2)) {
                  //  System.out.println("2="+path);
                    FileWordProject2.add(sb.toString().trim().split(" "));
                }
               // System.out.println("" + sb1);
                sb1.append(" ").append(sb);
                processProjectFile.add(sb.toString().trim());//contains two project file one by one 
            }
        }

        String allterm[] = sb1.toString().trim().split(" ");
        return allterm;
    }

    public void getUniqueWordProject1(String path1) throws IOException {
        String[] allterm = fileRead(path1);

        for (String term : allterm) {
            if (!allterms1.contains(term)) {
                allterms1.add(term); //project1 unique word
            }
        }

    }

    public void getUniqueWordProject2(String path2) throws IOException {
        String[] allterm = fileRead(path2);
        for (String term : allterm) {
            if (!allterms2.contains(term)) {
                allterms2.add(term);//project2 unique word
            }
        }
        //    System.out.println("" + allterms2);
        //   allterms3.addAll(allterms1);
        //  allterms3.addAll(allterms2);
    }

    public void IdfCal() {
        double idf;
        //ArrayList<String> combine = new ArrayList<>();//combine project1 and project2 arrayList
        combineTerms.addAll(allterms1);
        combineTerms.addAll(allterms2);
        // System.out.println("p=" + processProjectFile);
        // System.out.println("combine="+combine);
        for (String term : combineTerms) {
            idf = new getTfIdf().getIdf(processProjectFile, term);
            idfmap.put(term, idf);
        }
       // System.out.println("" + idfmap);
    }

    public void tfIdfVectorProject1() {
        double tf;
        double idf;
        double tfidf;
        for (String[] fileword : FileWordProject1) {
            int count = 0;
            double[] tfidfvector;
            tfidfvector = new double[combineTerms.size()];
            for (String term : combineTerms) {
                tf = new code_clone.getTfIdf().getTf(fileword, term);
                if (idfmap.containsKey(term)) {
                    idf = idfmap.get(term);
                    //   System.out.println(term+" "+idf);
                } else {
                    idf = 0;
                }
                tfidf = tf * idf;
                //  System.out.println(term+" 1="+tfidf);
                tfidfvector[count] = tfidf;
                count++;
                //  System.out.println(term+" tfidf="+tfidf);
            }
            tfidfvectorProject1.add(tfidfvector);
        }
       // System.out.println(""+CloneCheck.ProjectFileName1.size());
       // System.out.println("f="+FileWordProject1.size());
      //  System.out.println("t="+tfidfvectorProject1.size());
    }

    public void tfIdfVectorProject2() {
        double tf;
        double idf;
        double tfidf;
        for (String[] fileword : FileWordProject2) {
            int count = 0;
            double[] tfidfvector;
            tfidfvector = new double[combineTerms.size()];
            for (String term : combineTerms) {
                tf = new getTfIdf().getTf(fileword, term);
                if (idfmap.containsKey(term)) {
                    idf = idfmap.get(term);
                    //   System.out.println(term+" "+idf);
                } else {
                    idf = 0;
                }
                tfidf = tf * idf;
                // System.out.println(term+" 2="+tfidf);
                tfidfvector[count] = tfidf;
                count++;
                //  System.out.println(term+" tfidf="+tfidf);
            }
            tfidfvectorProject2.add(tfidfvector);
            
        }
    }
}
