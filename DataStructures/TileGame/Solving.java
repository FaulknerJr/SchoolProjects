//package project;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//import project.TileGameNode;
import java.util.Scanner;
/**
 *
 * @author Jeffrey Faulkner
 */
public class Solving {
    
    /**
     * Checks whether the two nodes are equal to each other.
     * @param currentState
     * @param endState
     * @return 
     */
    public static boolean check(TileGameNode currentState, TileGameNode endState)
    {
        boolean check = true;
        while(check)
        {
            for(int i = 0; i < 9; ++i)
            {
                if(currentState.state[i] == endState.state[i])
                {
                    check = true;
                }
                else
                {
                    return false;
                }
            }
            return check;
        }
        return false;
    }
    
    /**
     * Makes all possible moves that the blank can perform.
     * @param childState 
     */
    public static void move(TGQueue line)
    {
        TileGameNode parent = line.front();
        TileGameNode holder = line.removeFront();
        TileGameNode testNode = holder.copy(holder);
        TileGameNode childState = holder.copy(holder);
        TileGameNode newNode = null;
        int j = 0;
        for(int i = 0; i < 9; ++i)
        {
            if(childState.state[i] == 0)
            {
                break;
            }
            ++j;
        }
        if(j < 3)
        {
            if(j == 0)
            {
                if(childState.parent == null)
                {    
                    newNode = mDown(parent, childState, j);
                    line.insertBack(newNode);
                    childState = holder.copy(holder);
                    newNode = mRight(parent, childState, j);
                    line.insertBack(newNode);
                    return;
                }
                testNode = parent.copy(parent).copy(parent);
                if(check(mDown(parent,testNode, j), childState.parent))
                {
                    childState = holder.copy(holder);
                    line.insertBack(mRight(parent, childState,j));
                    return;
                }
                else
                {
                    childState = holder.copy(holder);
                    line.insertBack(mDown(parent, childState, j));
                }
//                return childState;
            }
            else if(j == 1)
            {
                if(childState.parent == null)
                {
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mLeft(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mRight(parent, childState, j));
                    return;
                }
                //testNode = parent.copy(parent);
                else if(check(mDown(parent, testNode, j), childState.parent) && line.front().depth < 11)
                {
                    //This case shouldn't be possible.
                    testNode = parent.copy(parent);
                    if(check(mLeft(parent, testNode, j), childState.parent) && line.front().depth < 11)
                    {
                        line.insertBack(mRight(parent, childState, j));
                    }
                    line.insertBack(mLeft(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mRight(parent, childState, j));
                    return;
                }
                testNode = holder.copy(holder);
                if(check(mLeft(parent, testNode, j), childState.parent) && line.front().depth < 11)
                {
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mRight(parent, childState, j));
                    return;
                }
                testNode = parent.copy(parent);
                if(check(mRight(parent, testNode, j), childState.parent) && line.front().depth < 11)
                {
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mLeft(parent, childState,j));  
                    return;
                }
            }
            else
            {
                if(childState.parent == null)
                {
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mLeft(parent, childState, j));
                }
                testNode = parent.copy(parent);
                if(check(mDown(parent, testNode, j), childState.parent) && line.front().depth < 11)
                {
                    line.insertBack(mLeft(parent, childState, j));
                }
                else
                {
                    line.insertBack(mLeft(parent, childState, j));
                }
            }
        }
        if(j > 2 && j < 6)
        {
            if(j == 3)
            {
                if(childState.parent == null)
                {
                    line.insertBack(mUp(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mRight(parent, childState, j));
                }
                testNode = parent.copy(parent);
                if(check(mUp(parent, testNode, j), childState.parent) && line.front().depth < 11)
                {
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mRight(parent, childState, j));
                }
                testNode = parent.copy(parent);
                if(check(mDown(parent, testNode, j), childState.parent) && line.front().depth < 11)
                {
                    line.insertBack(mUp(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mRight(parent, childState, j));
                }
            }
            if(j == 4)
            {
                if(childState.parent == null)
                {
                    line.insertBack(mUp(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mLeft(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mRight(parent, childState, j));
                    return;
                }
                testNode = parent.copy(parent);
                if(check(mUp(parent, testNode, j), childState.parent) && line.front().depth < 11)
                {
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mLeft(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mRight(parent, childState, j));
                }
                testNode = parent.copy(parent);
                if(check(mDown(parent, testNode, j), childState.parent) && line.front().depth < 11)
                {
                    line.insertBack(mUp(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mLeft(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mRight(parent, childState, j));
                }
                testNode = parent.copy(parent);
                if(check(mLeft(parent, testNode, j), childState.parent) && line.front().depth < 11)
                {
                    line.insertBack(mUp(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mRight(parent, childState, j));
                }
                testNode = parent.copy(parent);
                if(check(mRight(parent, testNode, j), childState.parent) && line.front().depth < 11)
                {
                    line.insertBack(mUp(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mLeft(parent, childState, j));
                }
            }
            if(j == 5)
            {
                if(childState.parent == null)
                {
                    line.insertBack(mUp(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mLeft(parent, childState, j));
                    return;
                }
                testNode = parent.copy(parent);
                if(check(mUp(parent, testNode, j), childState.parent))
                {
                    line.insertBack(mDown(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mLeft(parent, childState, j));
                }
                testNode = parent.copy(parent);
                if(check(mDown(parent, testNode, j),childState.parent))
                {
                    line.insertBack(mUp(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mLeft(parent, childState, j));
                    return;
                }
                testNode = parent.copy(parent);
                if(check(mLeft(parent, testNode, j),childState.parent))
                {
                    line.insertBack(mUp(parent, childState, j));
                    childState = holder.copy(holder);
                    line.insertBack(mDown(parent, childState, j));
                    return;
                }
            }
        }
        
        else
        {
            if(j == 6)
                {
                    if(childState.parent == null)
                    {
                        line.insertBack(mUp(parent, childState, j));
                        childState = holder.copy(holder);
                        line.insertBack(mRight(parent, childState, j));
                        return;
                    }
                    testNode = parent.copy(parent);
                    if(check(mUp(parent, testNode, j), childState.parent) && line.front().depth < 11)
                    {
                        line.insertBack(mRight(parent, childState, j));
                        return;
                    }
                    else if(line.front().depth < 11)
                    {
                        line.insertBack(mUp(parent, testNode, j));
                    }
                }
                if(j == 7)
                {
                    if(childState.parent == null)
                    {
                        line.insertBack(mUp(parent, childState, j));
                        childState = holder.copy(holder);
                        line.insertBack(mLeft(parent, childState, j));
                        childState = holder.copy(holder);
                        line.insertBack(mRight(parent, childState, j));
                        return;
                    }
                    testNode = parent.copy(parent);
                    if(check(mUp(parent, testNode, j), childState.parent))
                    {
                        line.insertBack(mLeft(parent, childState, j));
                        childState = holder.copy(holder);
                        line.insertBack(mRight(parent, childState, j));
                        return;
                    }
                    testNode = parent.copy(parent);
                    if(check(mLeft(parent, testNode, j), childState.parent))
                    {
                        line.insertBack(mUp(parent, childState, j));
                        childState = holder.copy(holder);
                        line.insertBack(mRight(parent, childState, j));
                        return;
                    }
                    testNode = parent.copy(parent); 
                    if(check(mRight(parent, testNode, j), childState.parent))
                    {
                        line.insertBack(mUp(parent, childState, j));
                        childState = holder.copy(holder);
                        line.insertBack(mLeft(parent, childState, j));
                        return;
                    }
                }
                if(j == 8)
                {
                    if(childState.parent == null)
                    {
                        line.insertBack(mUp(parent, childState, j));
                        childState = holder.copy(holder);
                        line.insertBack(mLeft(parent, childState, j));
                        return;
                    }
                    testNode = parent.copy(parent);
                    if(check(mUp(parent, testNode, j), childState) && line.front().depth < 11)
                    {
                        mLeft(parent, childState, j);
                    }
                    else
                    {
                        if(line.front().depth < 11)
                        {
                            return;
                        }
                        line.insertBack(mUp(parent, childState, j));
                    }
                }
            }
        }
    
    /**
     * Moves the blank up.
     * @param uParent
     * @param uCState
     * @param pos
     * @return 
     */
    private static TileGameNode mUp(TileGameNode uParent,TileGameNode uCState, int pos)
    {
        int tempVal = uCState.state[pos-3];
        uCState.state[pos] = tempVal;
        uCState.state[pos-3] = 0;
        uCState.move = 'u';
        uCState.parent = uParent;
        uCState.depth = uParent.depth + 1;
        return uCState;
    }
    
    /**
     * Moves the blank down.
     * @param dParent
     * @param dCState
     * @param pos
     * @return 
     */
    private static TileGameNode mDown(TileGameNode dParent, TileGameNode dCState, int pos)
    {
        int tempVal = dCState.state[pos+3];
        dCState.state[pos] = tempVal;
        dCState.state[pos+3] = 0;
        dCState.move = 'd';
        dCState.parent = dParent;
        dCState.depth = dParent.depth + 1;
        return dCState;
    }
    
    /**
     * Moves the blank left.
     * @param lParent
     * @param lCState
     * @param pos
     * @return 
     */
    private static TileGameNode mLeft(TileGameNode lParent, TileGameNode lCState, int pos)
    {
        int tempVal = lCState.state[pos-1];
        lCState.state[pos] = tempVal;
        lCState.state[pos-1] = 0;
        lCState.move = 'l';
        lCState.parent = lParent;
        lCState.depth = lParent.depth + 1;
        return lCState;
    }
    
    /**
     * Moves the blank right.
     * @param rParent
     * @param rCState
     * @param pos
     * @return 
     */
    private static TileGameNode mRight(TileGameNode rParent, TileGameNode rCState, int pos)
    {
        int tempVal = rCState.state[pos+1];
        rCState.state[pos] = tempVal;
        rCState.state[pos+1] = 0;
        rCState.move = 'r';
        rCState.parent = rParent;
        rCState.depth = rParent.depth + 1;
        return rCState;
    }
}
