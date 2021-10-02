package code_clone;

import IO.Filewriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PreProcessing {
    //  String stemWord="";

    public String ProcessFile(String filename, String content,String p) throws IOException {
        String stemWord = "";
        String methodWithotPunctuation = removePunctuation(content);
        String methodWithoutKey = removeKeyword(methodWithotPunctuation);
        String methodWithoutSpace = removeSpace(methodWithoutKey);
        Porter_stemmer stemmer = new Porter_stemmer();
        String[] words = methodWithoutSpace.split(" ");
        for (String word : words) {
            String stem = stemmer.stemWord(word);
            stemWord = stemWord + " " + stem;
        }

        //  System.out.println("" + stemWord.trim());
        Filewriter writer = new Filewriter(); //fileWriter class objeect

        String path = writer.createProcessFile(filename, stemWord.trim(),p);  //filename-filename with package

        return path;
    }

    public String removePunctuation(String p) throws IOException {

        //    for (int i = 0; i < method.size(); i++) {
        //   System.out.println(""+method.get(i));
        String methodWithoutPunctuation = p.replaceAll("\\p{Punct}", " ");
        // System.out.println("" + removeMultipleSpaceAndLine(methodWithoutPunctuation));
        return methodWithoutPunctuation;
    }

   
    public String removeSpace(String fileAsString) {
        String newLineRemove = fileAsString.trim().replace("\n", " ").replace("\r", "");
        String spaceRemove = newLineRemove.replaceAll("\\s+", " ").trim();

        return spaceRemove;
    }

    public String removeKeyword(String fileAsString) throws FileNotFoundException, IOException {
        ArrayList<String> keyWordList = new ArrayList<>();
        ArrayList<String> methodContentList = new ArrayList<>();
        FileInputStream fis = new FileInputStream("H:\\2-1\\project\\Coding_Helper\\keyword.java"); //keyword.java is a file which contains all keyword
        byte[] b = new byte[fis.available()];
        fis.read(b);

        String[] keyword = new String(b).trim().split(" ");
        String newString = " ";
        for (int i = 0; i < keyword.length; i++) {
            keyWordList.add(keyword[i].trim());

        }
        String[] p = fileAsString.split(" ");
        for (int i = 0; i < p.length; i++) {
            if (!(keyWordList.contains(p[i].trim()))) {
                newString = newString + p[i] + " ";

            }
        }
        return newString;
    }
}
