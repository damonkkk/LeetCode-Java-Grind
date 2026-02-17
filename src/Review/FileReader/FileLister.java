package Review.FileReader;

import java.io.File;
import java.util.ArrayList;

public class FileLister {

    public static ArrayList<String> listFilesRecursively(File file){
        ArrayList<String> result = new ArrayList<>();
        if(file==null||!file.exists()){
            return result;
        }
        if(file.isFile()){
            result.add(file.getAbsolutePath());
            return result;
        }
        if(file.isDirectory()){
        File[] childern = file.listFiles();

        for(var c:childern){
            ArrayList<String> childFiles = listFilesRecursively(c);
            result.addAll(childFiles);
        }
        }
        return result;
    }
}
