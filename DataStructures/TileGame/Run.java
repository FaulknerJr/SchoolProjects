/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package project;
import java.util.Scanner;
/**
 *
 * @author Faulkner
 */
public class Run {
    
    public static void Run()
    {
        int [] temp = new int [9];
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 9; ++i)
        {
            temp[i] = 15;
        }
        String out = "Numbers used: ";
        System.out.println("Enter the start state.");
        System.out.println("Please enter 9 numbers 0 - 8.(Inclusive) ");
        System.out.println("Enter numbers one by one. Without repeating.");
        for(int i = 0; i < 9; ++i)
        {           
            int s = in.nextInt();
            boolean duplicate = false;
            if(s < 9 && s >= 0)
            {
                for(int j = 0; j < temp.length; ++j)
                {
                    if(s == temp[j])
                    {
                        System.out.println("Duplicate numbers aren't allowed.");
                        duplicate = true; —-i;
                    }    
                }
                if(!duplicate){
                   temp[i] = s;
                }
                out += s + " ";
                System.out.println(out);
            }
            else
            {
                System.out.println("Number out of bounds");
                —-i;
            }
        }
        char d = 0;
        TileGameNode startState = new TileGameNode(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], null, null, 0, d);
    
    
        for(int i = 0; i < 9; ++i)
        {
            temp[i] = 15;
        }
        out = "Numbers used: ";
        System.out.println("Enter the goal state.");
        System.out.println("Please enter 9 numbers 0 - 8.(Inclusive) ");
        System.out.println("Enter numbers one by one. Without repeating.");
        for(int i = 0; i < 9; ++i)
        {           
            int s = in.nextInt();
            if(s < 9 && s >= 0)
            {
                for(int j = 0; j < temp.length; ++j)
                {
                    if(s == temp[j])
                    {
                        System.out.println("Duplicate numbers aren't allowed.");
                        return;
                    }    
                }
                temp[i] = s;
                out += s + " ";
                System.out.println(out);
            }
            else
            {
                System.out.println("Number out of bounds");
                return;
            }
        }
        TileGameNode goalState = new TileGameNode(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], null, null, 0, d);
        if(Solving.check(startState, goalState))
        {
            System.out.println("The puzzle is in order already.");
            return;
        }
        TGQueue line = new TGQueue();
        line.insertBack(startState);
        startState.depth = 1;
        while(line.front.depth < 11) 
        {
            Solving.move(line);
            if(Solving.check(line.front(), goalState))
            {
                break;
            }
            if(line.front.depth == 10)
            {
                while(line.front.parent.parent != null)
                {
                    line.front = line.front.parent;
                    line.front.depth = line.front.depth - 1;
                }
            }
        }
        out = "";
        if(line.front().parent == null)
        {
            out += line.removeFront().toString();
        }
        while(line.front().parent != null)
        {
            out += line.removeFront().toString();
        }
        System.out.println("To get to the goal state perform these steps: ");
        System.out.println(out);
    }
}
