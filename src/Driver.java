import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Driver {
    public static void main(String args[]){
        try {
            FileReader fr = new FileReader("graph.txt");
            BufferedReader bf = new BufferedReader(fr);
            Graph g = new Graph(bf);
            Tree t = Tree.fromGraph(g);
            t.makeRoot(3);
            System.out.println("Cool, thumbs man.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
