package Review.Q7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//FIXME adjust class definition
public class FsDir implements FsNode{
    public File dir;
    public String name;
    public List<FsNode> nodes;

    public FsDir(File dir) {
        // FIXME complete constructor
        this.dir = dir;
        this.name=dir.getName();
        this.nodes = new ArrayList<>();
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file:files){
                nodes.add(FsNode.createNode(file));
            }
        }


    }

    @Override
    public File getUnderlyingFile() {
        return this.dir;
    }

    @Override
    public List<FsNode> allNodes() {
        List<FsNode> result = new ArrayList<>();

        result.add(this);
        List<FsNode> sorted = sortByName(this.nodes);
        for(FsNode node: sorted){
            if(node instanceof FsDir){
                result.addAll(node.allNodes());
            } else {
                result.add(node);
            }
        }
        return result;
    }

    public List<FsNode> sortByName(List<FsNode> nodes){
        List<FsNode> copy = new ArrayList<>(nodes);
        List<FsNode> result = new ArrayList<>();

        while(!copy.isEmpty()){
            FsNode min = copy.get(0);
            for(FsNode node: copy){
                if(node.getName().compareTo(min.getName())<0){
                    min = node;
                }
            }
            result.add(min);
            copy.remove(min);
        }
        return result;
    }

    @Override
    public String getName() {
        return this.name;
    }

    //FIXME add members
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other ==null || this.getClass() != other.getClass()){
            return false;
        }
        FsDir fsDir = (FsDir) other;
        return this.name.equals(fsDir.name) && sortByName(this.nodes).equals(sortByName(fsDir.nodes));
    }


    @Override
    public int hashCode(){
        int res = 13;
        res = 13*res+ this.name.hashCode();
        for (var nodes: sortByName(this.nodes)){
            res += nodes.hashCode() * 13;
        }
        return res;
    }

}
