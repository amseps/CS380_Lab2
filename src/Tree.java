import java.io.*;
import java.util.*;

public class Tree
{
    public int noOfVertices = - 1;

    // Adjacency list representing the graph.
    public int[][] edges = null;

    public int[] parentIds = null;
    public int rootId = -1;

    private Tree(int size)
    {
        edges = new int[size][];
        parentIds = new int[size];

        for (int i = 0; i < size; i++)
        {
            parentIds[i] = -1;
        }
    }

    /*
     * Creates a Tree-object based on the given undirected graph g.
     * The root of the created tree is vertex 0.
     * Returns null if g is not a tree.
     */
    public static Tree fromGraph(Graph g)
    {
        Tree toRet = new Tree(g.edges.length);

        Stack<Integer> toDo = new Stack<>();
        toRet.parentIds = new int[g.edges.length];
        for(int i = 1; i < toRet.parentIds.length; i++) toRet.parentIds[i] = -1;
        toRet.parentIds[0] = -2;
        toDo.push(0);
        int curr;
        while(!toDo.isEmpty()){
            curr = toDo.pop();
            for(int i = 0; i < g.edges[curr].length; i++){//go through all neighbors
                if(toRet.parentIds[g.edges[curr][i]] == -1) {//if I'm looking at an unfound piece
                    toRet.parentIds[g.edges[curr][i]] = curr;
                    toDo.push(g.edges[curr][i]);
                }else if(toRet.parentIds[curr] == g.edges[curr][i]) {//if I'm looking at my parent, do nothing.

                }else if(toRet.parentIds[g.edges[curr][i]] == -2){ //if I'm looking at the tree master, do nothing.

                }else{ //otherwise I must be looking at a cross edge. Fail.
                    return null;
                }
            }
    }
        toRet.rootId = 0;
        toRet.parentIds[0] = -1;
        toRet.edges = g.edges.clone();
        return toRet;
    }

    /*
     * Makes vId the new root of the tree.
     */
    public void makeRoot(int vId)
    {
        Stack<Integer> toDo = new Stack<>();
        int curr;
        toDo.push(vId);
        while(!toDo.isEmpty()){
            curr = toDo.pop();
            for(int i = 0; i < edges[curr].length; i++){//go through all current neighbors
                int thisneighbor = edges[curr][i];
                if(parentIds[thisneighbor] == curr){// if I am his parent, ignore.

                }else{//I am now his parent.
                    parentIds[thisneighbor] = curr;
                    toDo.push(thisneighbor);
                }
            }
        }
        rootId = vId;
        parentIds[vId] = -1;
    }
}


































