package huffman;

import console.Command;
import java.io.IOException;
import java.util.Scanner;

public class mainDecode {

    public void Decompress(String path) throws IOException {
        Decompress de;
        String p = new Command().pathGenerate(path);
        String compressFile = compressFile(p);
        String decompressFile = decompressFile(p);

        de = new Decompress(compressFile, decompressFile);

        de.decompressFile();

    }

    public String compressFile(String path) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("\tEnter a compressed filename:");
        String filename = sc.nextLine().trim();
        String compressFilepath = path+"\\"+filename;
        boolean exist = new mainEncode().checkFileExist(compressFilepath);
       // if(filename.isEmpty()){
        //    System.out.println("\tInvalid filename");
            
     //   }

        try {
            if (filename.endsWith(".zip") && exist == true) {
                
                return compressFilepath;

            }

            else {
                System.out.println("\tInvalid filename");
                new Command().command();

            }
        } catch (Exception e) {
            System.out.println("\tInvalid filename");
        }
        System.out.println(compressFilepath);
        return compressFilepath;
    }

    public String decompressFile(String path) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("\tEnter Decompress file name: ");
        // exit();
        String decompressFileName = sc.nextLine();

        if (!(decompressFileName.endsWith(".txt") | decompressFileName.endsWith(".java"))) {
            System.out.println("\tInvalid filename");
            //   compressFile(p);
            new Command().command();

        }
        String decompressfilePath = path + "\\" + decompressFileName;
        boolean exist = new mainEncode().checkFileExist(decompressfilePath);
        if (exist) {
            System.out.println("\tSame file already exist here");
            new Command().command();
        }
        return decompressfilePath;
    }
}
