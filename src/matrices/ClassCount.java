package matrices;

import IO.ProjectReader;

public class ClassCount {

    public int classCount(String path) {
        int totalClass=0;

        try {
            ProjectReader.fileRead(path, 0);
            totalClass = ProjectReader.classCount;
            System.out.println("\tTotal number of class:" + totalClass);
            ProjectReader.classCount = 0;
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
        return totalClass;
    }
}
