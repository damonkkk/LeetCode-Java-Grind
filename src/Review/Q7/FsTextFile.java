package Review.Q7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//FIXME adjust class definition
public class FsTextFile implements FsNode {
    public File file;
    public String name;
    public List<String> data;


    public FsTextFile(File file) {
        this.file=file;
        this.name=file.getName();
        this.data=readFromFile(file);
    }

    public List<String> readFromFile(File file){
        List<String> data = new ArrayList<>();
        try(var reader = new BufferedReader(new FileReader(file))){
            for(var line = reader.readLine();line != null; line= reader.readLine()){
                data.add(line);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public File getUnderlyingFile() {
        return this.file;
    }

    @Override
    public List<FsNode> allNodes() {
        return List.of(this);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object other) {
        if(this ==other){
            return true;
        }
        if(other == null|| getClass() != other.getClass()){
            return false;
        }
        FsTextFile file1 = (FsTextFile) other;
        return this.name.equals(file1.name) && this.data.equals(file1.data);
    }

    @Override
    public int hashCode(){
        int result = 7;
        result = result*17 + this.name.hashCode();
        result = result*17+ (this.data != null ? this.data.hashCode():0);
        return result;
    }


}