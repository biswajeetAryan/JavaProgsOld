package com.graphsAndTrees;

import java.util.Scanner;

public class MutantFlatworld {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        MoveRobot robot;
        String upperCoordinates = "5 3";//sc.nextLine();
        int [] upperCoordinatesArr = new int[2];
        String [] upperCoordinatesStrArr = upperCoordinates.split("\\s");
        upperCoordinatesArr[0]=Integer.parseInt(upperCoordinatesStrArr[0]);
        upperCoordinatesArr[1]=Integer.parseInt(upperCoordinatesStrArr[1]);

//        int n = sc.nextInt();

//        for (int i=0;i<n;i++){
            String initialPosition = "0 3 W";//sc.nextLine();
            String pathInstruction = "LLFFFLFLFL";//sc.nextLine();
            String [] initialPositionArr = initialPosition.split("\\s");
            int [] initialCoordinates = new int[2];
            initialCoordinates[0]=Integer.parseInt(initialPositionArr[0]);
            initialCoordinates[1]=Integer.parseInt(initialPositionArr[1]);
            String dir = initialPositionArr[2];
            robot = new MoveRobot(initialCoordinates, dir, upperCoordinatesArr);
            robot.initialiseRobot(pathInstruction);
//        }
   }
}
class MoveRobot {
    private int x, y;
    private int[] upperBoundR = new int[2];
    private String dirR;

    public String getDirR() {
        return dirR;
    }

    public void setDirR(String dirR) {
        this.dirR = dirR;
    }

    MoveRobot(int [] initialCoordinates, String dir, int [] upperBound){
        this.x = initialCoordinates[0];
        this.y = initialCoordinates[1];
        this.upperBoundR[0] = upperBound[0];
        this.upperBoundR[1] = upperBound[1];
        this.dirR = dir;
    }

    public void initialiseRobot(String instruction){
        char[] instArr = instruction.toCharArray();
        String dirArr [] = {"N","E","S","W"};
        int []dx={0,1,0,-1};
        int []dy={1,0,-1,0};
        for(int i=0;i<instArr.length;i++) {
            int d = this.robotMovment(instArr[i], dx, dy);
            dirR = dirArr[d];
        }
        System.out.print(x+" "+y+" "+dirR);
        if((x >= upperBoundR[0] || x < 0) || (y >= upperBoundR[1] || y < 0))
            System.out.print(" LOST");

    }
    private int robotMovment(char inst, int dx[], int dy[]){
        int orientation = 0;
        if(dirR.equals("E"))
            orientation=1;
        else if(dirR.equals("S"))
            orientation =2;
        else if(dirR.equals("W"))
            orientation = 3;

        if(inst == 'R') {
            orientation= (orientation+1 < 4)?(orientation+1)%4 : 0;
        }
        if(inst == 'L') {
            orientation=(orientation-1 > -1)?(orientation-1)%4 : 3;
        }
        else if(inst == 'F'){
            x+=dx[orientation];
            y+=dy[orientation];
        }
        return orientation;
    }
}
