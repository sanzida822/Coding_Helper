package huffman;

import console.Command;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Mamun
 */
public class mainEncode {

    public boolean exist = false;

    public void Compress(String path) throws IOException {

        Compress encode;
        String filename = mainfile(path);
        // exit();
        exist = false;
        String compressFileName = compressFile(path);

        encode = new Compress(filename, compressFileName);
        encode.compressFile();

    }

    public String mainfile(String path) throws IOException {
        String p = new Command().pathGenerate(path);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a filename:");//("Enter Encoded file location : ");
        //   exit();
        String filename = sc.next();
        String mainFilePath = p + "\\" + filename;
        checkFileExist(mainFilePath);
        boolean fileEmpty = new IO.Filereader().fileEmpty(mainFilePath);
        if (!(filename.endsWith(".java") | filename.endsWith(".txt"))) {
            System.out.println("Invalid filename");
            new Command().command();
        }

        if (exist == false) {
            System.out.println("File not exist.");
             new Command().command();
        }

        if (fileEmpty) {
            System.out.println("File is empty");
            new Command().command();
        }
        return mainFilePath;
    }

    public String compressFile(String path) throws IOException {
        String p = new Command().pathGenerate(path);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter compress filename: ");
        // exit();
        String compressFileName = sc.next();
         String compressfilePath="";
        if (!compressFileName.endsWith(".zip")) {
            System.out.println("Invalid filename");
         //   compressFile(p);
          new Command().command();

        }else{
            
         compressfilePath = p + "\\" + compressFileName;
        checkFileExist(compressfilePath);
        if (true==exist) {
            System.out.println("Same file already in this location ");
            //System.out.println(p);
            new Command().command();
        }}
        return compressfilePath;

    }

    /*public void exit() throws IOException {
        if (sc.next().equals("break")) {
      new Command().command();
        }
    }
     */
    public boolean checkFileExist(String path) {
        Path p = Paths.get(path);
        File file = new File(path);
        if (!file.exists() || (Files.isDirectory(p))) {
            exist = false;
        } else {
            exist = true;
        }
        return exist;
    }

}
