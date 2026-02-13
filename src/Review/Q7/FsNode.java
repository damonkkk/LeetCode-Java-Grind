package Review.Q7;



import java.io.File;
import java.util.List;

public interface FsNode {

    static FsNode createNode(File file) {
        if(file.isDirectory()){
            return new FsDir(file);
        }

        if(file.getName().endsWith(".txt")){
            return new FsTextFile(file);
        }


        return new FsNonTextFile(file);
    }

    File getUnderlyingFile();

    List<FsNode> allNodes();

    String getName();
}