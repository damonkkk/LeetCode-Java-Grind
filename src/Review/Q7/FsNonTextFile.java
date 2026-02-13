package Review.Q7;

import java.io.File;
import java.util.List;
import java.util.Objects;

//FIXME adjust class definition
public class FsNonTextFile implements FsNode{
    public File file;
    public String name;

    public FsNonTextFile(File file) {
        this.file=file;
        this.name = file.getName();
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

    //FIXME add members
    @Override
    public boolean equals(Object other){
        if (other instanceof FsNonTextFile file){
            return this.name.equals(file.name);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
