package FileReader;

import java.io.File;
import java.util.ArrayList;

public class FileSizeCalculator {


    public static long calculateFileSize(File file){
        long result = 0;
        if(file==null||!file.exists()){
            return 0;
        }
        if(file.isFile()){
            return file.length();
        }
        if(file.isDirectory()){
            File[] children = file.listFiles();
            if (children == null) {
                return 0;  // 或者 return result;
            }

            for(var c: children){
                result += calculateFileSize(c);

            }
        }

return result;

    }
}
