Squads of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on board cameras can get a complete view of the surrounding terrain to send back to Earth.  

A rover's position and location is represented by a combination of x and y coordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North. 
 
In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.  
 
Assume that the square directly North from (x, y) is (x, y+1).  

------------------------------------------------------------------------------------------

Assumption I made:
	If a rover hits the edge it will not cause an error.
		It will continue to run the rest of the instruction set.
		Designed it this way to give the rover some intelligence
			in reality it would be able to know there is an edge 
			and compensate for that obstacle regardless of operator's
			intentions.
	
		There are no checks for if the plateau is 0, 0 or 1, 1.
		
		There is code implemented for printing out the terrain. 
		It can be placed back in with the method:
			printTerrain(String[][]array, int numRovers)
			
		When I originally started the project I read in all of the
			rover coordinates first then I read in the instruction sets.
			The same results are achieved, but it is a different input method.
			
		The 3 3 E option goes to 4 1 E because 4 is the max of a 5 X 5 array.
		
			
			
To run this program 

$ cd ../MarsRover.java
$ javac MarsRover.java
$ javac Main.java
$ java Main

After performing those steps the program's prompts will display.
Follow those prompts for results.
		