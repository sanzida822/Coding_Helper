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
        System.out.print("Enter a compressed filename:");
        String filename = sc.next();
        String compressFilepath = path + "\\" + filename;
        boolean exist = new mainEncode().checkFileExist(compressFilepath);
        if (!exist) {
            System.out.println("File not exist");
            new Command().command();

        }
        if (! filename.endsWith(".zip")) {
            System.out.println("Invalid filename");
            //   compressFile(p);
            new Command().command();

        }
        return compressFilepath;
    }

    public String decompressFile(String path) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Decompress file name: ");
        // exit();
        String decompressFileName = sc.next();

        if (!(decompressFileName.endsWith(".txt") | decompressFileName.endsWith(".java"))) {
            System.out.println("Invalid filename");
            //   compressFile(p);
            new Command().command();

        }
        String decompressfilePath = path + "\\" + decompressFileName;
        boolean exist = new mainEncode().checkFileExist(decompressfilePath);
        if (exist) {
            System.out.println("Same file already exist here");
            new Command().command();
        }
        return decompressfilePath;
    }
}
