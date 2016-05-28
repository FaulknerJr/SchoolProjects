import java.util.Scanner;
public class MarsRover{

	public void navigate() {
        Scanner in = new Scanner(System.in);
        String terrainSize = null;
        boolean valid = true;
        int num1 = -1, num2 = -1;
        while (valid) {
            System.out.println("Please enter the size of the plateau.");
            terrainSize = in.nextLine();
            String numCreation = "";
            num1 = 0;
            num2 = 0;
            for (int i = 0; i < terrainSize.length(); ++i) {
                if (Character.isDigit(terrainSize.charAt(i))) {
                    numCreation += terrainSize.charAt(i);
                    if (i == (terrainSize.length() - 1) && num2 == 0) {
                        try {
                            num2 = Integer.parseInt(numCreation);
                        } catch (Exception e) {
                            System.out.println("Number is too large");
                            break;
                        }
                    }
                } else if (terrainSize.charAt(i) == ' ') {
                    if (num1 > 0) {
                        try {
                            num2 = Integer.parseInt(numCreation);
                        } catch (Exception e) {
                            System.out.println("Number is too large");
                        }
                    } else {
                        try {
                            num1 = Integer.parseInt(numCreation);
                            numCreation = "";
                        } catch (Exception e) {
                            System.out.println("Number is too large");
                        }
                    }
                } else {
                    System.out.println("An invalid character was found.");
                    break;
                }
            }
            if (num2 > 0) {
                valid = false;
            }
        }

        String[][] terrain = new String[num1][num2];
        valid = true;
        char direction = ' ';
        String roverPosition = "";

        //Initializing array to avoid null pointers.
        for (int i = 0; i < terrain.length; ++i) {
            for (int j = 0; j < terrain[0].length; ++j) {
                terrain[i][j] = "";
            }
        }

        System.out.println("Number of rovers? ");
        int numRovers = -1;
        while (numRovers < 0 || numRovers >= 10) {
            try {
                numRovers = in.nextInt();
                in.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter number of rovers.");
                in.nextLine();
            }
        }

        int loop = 0;
        String[] instructions = new String[numRovers];
        while (valid && loop < numRovers) {
            System.out.println("Please enter the land rover's information ex: 3 2 E");
            roverPosition = in.nextLine().trim();
            String numCreation = "";
            num1 = 0;
            num2 = 0;
            for (int i = 0; i < roverPosition.length(); ++i) {
                if (Character.isDigit(roverPosition.charAt(i))) {
                    numCreation += roverPosition.charAt(i);
                    if (i == (roverPosition.length() - 1) && num2 == 0) {
                        try {
                            num2 = Integer.parseInt(numCreation);
                        } catch (Exception e) {
                            System.out.println("Number is too large");
                            break;
                        }
                    }
                } else if (roverPosition.charAt(i) == ' ') {
                    if (num1 > 0) {
                        try {
                            num2 = Integer.parseInt(numCreation);
                            if (num2 > terrain[0].length || num2 < 0) {
                                System.out.println("Those coordinates are out of bounds.");
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Number is too large");
                            break;
                        }
                    } else {
                        try {
                            num1 = Integer.parseInt(numCreation);
                            if (num1 > terrain.length || num1 < 0) {
                                System.out.println("Those coordinates are out of bounds.");
                                break;
                            } else {
                                numCreation = "";
                            }
                        } catch (Exception e) {
                            System.out.println("Number is too large");
                            break;
                        }
                    }
                }
            }
            if (num2 > 0) {
                if (num2 > terrain[0].length) {
                    System.out.println("Those coordinates are out of bounds.");
                    break;
                } else {
                    if (Character.isLetter(roverPosition.charAt(roverPosition.length() - 1))) {
                        direction = Character.toUpperCase(roverPosition.charAt(roverPosition.length() - 1));
                        switch (direction) {
                            case 'N':
                            case 'S':
                            case 'E':
                            case 'W':
                                ++loop;
                                terrain[num1][num2] = Integer.toString(loop) + direction;
                                if (loop == numRovers) {
                                    valid = false;
                                }
                                break;
                            default:
                                System.out.println("The rover can not face that direction.");
                        }
                    }
                }
            } else {
                System.out.println("X coordinate must be between 0 and " + terrain.length + ".");
                System.out.println("Y corrdinate must be between 0 and " + terrain[0].length + ".");
            }
        }
//
//        System.out.println("Would you like a print out of the terrain?");
//        System.out.println("Enter yes or no.");
//        terrainSize = in.nextLine();
//        System.out.println(terrainSize);
//        if (terrainSize.equalsIgnoreCase("yes")) {
//            printTerrain(terrain, numRovers);
//        }
//        
        int roverX = -1;
        int roverY = -1;
        
        valid = true;
        loop = 0;
        while (valid && loop < numRovers) {
            System.out.println("What are the rover's instructions?");
            int thisRover = loop + 1;
            String currNum = "";
            String roverLocation = findRover(terrain, thisRover);
            for (int i = 0; i < roverLocation.length(); ++i) {
                if (roverLocation.charAt(i) == ' ') {
                    roverX = Integer.parseInt(currNum);
                    currNum = "";
                } else {
                    currNum += roverLocation.charAt(i);
                }
                if (roverX >= 0 && !(currNum.equals(""))) {
                    roverY = Integer.parseInt(currNum);
                }
            }
            direction = terrain[roverX][roverY].charAt(terrain[roverX][roverY].length() - 1);
            num1 = roverX; num2 = roverY;
            instructions[loop] = in.nextLine().trim().toUpperCase();
            for (int i = 0; i < instructions[loop].length(); ++i) {
                if (instructions[loop].charAt(i) == 'L') {
                    if (direction == 'N') {
                        direction = 'W';
                    } else if (direction == 'S') {
                        direction = 'E';
                    } else if (direction == 'E') {
                        direction = 'N';
                    } else {
                        direction = 'S';
                    }
                } else if (instructions[loop].charAt(i) == 'R') {
                    if (direction == 'N') {
                        direction = 'E';
                    } else if (direction == 'S') {
                        direction = 'W';
                    } else if (direction == 'E') {
                        direction = 'S';
                    } else {
                        direction = 'N';
                    }
                } else if (instructions[loop].charAt(i) == 'M') {
                    String temp;
                    switch (direction) {
                        case 'N':
                            temp = terrain[roverX][roverY];
                            terrain[roverX][roverY] = "";
                            num2++;
                            if (num2 > terrain[0].length) {
                                num2--;
                            }
                            roverY = num2;
                            terrain[roverX][roverY] = temp;
                            break;
                        case 'S':
                            temp = terrain[roverX][roverY];
                            terrain[roverX][roverY] = ""; 
                            num2--;
                            if (num2 < 0) {
                                num2++;
                            }
                            roverY = num2;
                            terrain[roverX][roverY] = temp;
                            break;
                        case 'E':
                            temp = terrain[roverX][roverY];
                            terrain[roverX][roverY] = "";
                            num1++;
                            if (num1 >= terrain.length) {
                                num1--;
                            }
                            roverX = num1;
                            terrain[roverX][roverY] = temp;
                            break;
                        case 'W':
                            temp = terrain[roverX][roverY];
                            terrain[roverX][roverY] = "";
                            num1--;
                            if (num1 < 0) {
                                num1++;
                            }
                            roverX = num1;
                            terrain[roverX][roverY] = temp;
                            break;
                    }
                } else {
                    //Move to next letter in instruction chain.
                    // can add break here to exit this instruction chain as invalid.
                    // set a boolean here to prevent moving on to next instruction set.
                }
                
                //check that boolean here to get another instruction set for current rover.
            }
            System.out.println(roverX + " " + roverY + " " + direction);
            ++loop;
        }
    }

    public String findRover(String[][] mars, int rover) {
        String roverPosition = Integer.toString(rover);
        for (int i = 0; i < mars.length; ++i) {
            for (int j = 0; j < mars[0].length; ++j) {
                if (!mars[i][j].equals("")) {
                    if (roverPosition.charAt(0) == mars[i][j].charAt(0)) {
                        roverPosition = Integer.toString(i) + " " + Integer.toString(j);
                    }
                }
            }
        }
        return roverPosition;
    }

    public void printTerrain(String[][] mars, int rovers) {
        if (rovers > 1) {
            System.out.print("Rovers are landing");
        } else {
            System.out.print("Rover is landing");
        }
        for (int i = 0; i < 3; ++i) {
            try {
                Thread.sleep(2500);
                System.out.print(".");
            } catch (InterruptedException ex) {

            }
        }
        System.out.println();
        for (int i = 0; i < mars.length; ++i) {
            for (int j = 0; j < mars[0].length; ++j) {
                if (!mars[i][j].equals("")) {
                    System.out.print("|0|");
                } else {
                    System.out.print("|_|");
                }
            }
            System.out.println();
        }
    }

}