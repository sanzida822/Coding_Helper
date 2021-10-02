package IO;

import code_clone.CloneCheck;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Filereader {


/*public static ArrayList<String> processProjectFile = new ArrayList<>();
    public static ArrayList<String[]> FileWordProject1 = new ArrayList<>();
    public static ArrayList<String[]> FileWordProject2 = new ArrayList<>();

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
*/

    public boolean fileEmpty(String path) {
        boolean empty = false;
        File file = new File(path);
        if (file.length() == 0) {
            empty = true;
        } else {
            empty = false;

        }
        return empty;
    }

}
