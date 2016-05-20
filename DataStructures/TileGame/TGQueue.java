//package project;


//import TileGameNode;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeffrey Faulkner
 */
public class TGQueue {

    public TileGameNode front;
    public TileGameNode back;
    
    public TGQueue()
    {
        front = back = null;
    }
    
    /**
     * Adds new nodes to the queue.
     * @param thisState 
     */
    public void insertBack(TileGameNode thisState)
    {
        if(front == null)
        {
            front = back = thisState;
            return;
        }
        back.next = thisState; 
        back = back.next;
    }
    
    /**
     * Removes the front node and returns it.
     * @return 
     */
    public TileGameNode removeFront()
    {
        TileGameNode temp = front;
        if(front == null)
        {
            return null;
        }
        if(front == back)
        {
            front = back = null;
            return temp;
        }        
        front = front.next;
        return temp;
    }
    
    /**
     * Returns information in the front of the queue.
     * @return 
     */
    public TileGameNode front()
    {
        return front.copy(front);
    }
}
