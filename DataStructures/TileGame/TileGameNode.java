//package project;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeffrey Faulkner
 */
public class TileGameNode {
    
    int [] state = new int[9];
    int depth;
    TileGameNode parent;
    TileGameNode next;
    char move;
    
    public TileGameNode(int a, int b, int c, int d, int e, int f, int g, int h, int i, 
            TileGameNode p, TileGameNode n, int dp, char m)
    {
        state[0] = a;
        state[1] = b;
        state[2] = c;
        state[3] = d;
        state[4] = e;
        state[5] = f;
        state[6] = g;
        state[7] = h;
        state[8] = i;
        parent = p;
        next = n;
        depth = dp;
        move = m;
    }
    
    public TileGameNode(int a, int b, int c, int d, int e, int f, int g, int h, int i, int dp, char m)
    {
        state[0] = a;
        state[1] = b;
        state[2] = c;
        state[3] = d;
        state[4] = e;
        state[5] = f;
        state[6] = g;
        state[7] = h;
        state[8] = i;
        parent = null;
        next = null;
        depth = dp;
        move = m;
    }
    
    public String toString()
    {
        String out = "";
        for(int i = 0; i < 9; ++i)
        {
            out += "[ " +state[i] + " ]";
        }
        out += "Move blank " + move;
        return out;
    }
    
    /**
     * Copies the information in the node.
     * @param replicate
     * @return 
     */
    public TileGameNode copy(TileGameNode replicate)
    {
        TileGameNode temp = new TileGameNode(0,0,0,0,0,0,0,0,0,replicate.depth, replicate.move);
        for(int i = 0; i < 9; ++i)
        {
            temp.state[i] = replicate.state[i];
        }
        temp.move = replicate.move;
        //temp.parent = replicate.parent;
        //temp.next = replicate.next;
        return temp;
                
    }
}
