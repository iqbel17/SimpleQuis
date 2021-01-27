/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Muhammad Iqbal Nur Yusuf
 */
public class Tes {

    public static int randomFunction() {
        int min = 10;
        int max = 20;
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void main(String[] args) {

        Random random = new Random();
        System.out.println("Pick number between 10 - 20");

        int ScoreUser = 0;
        int ScoreAI = 0;
        int panjang = 0;

        while (true) {
            Scanner input = new Scanner(System.in);
            panjang = input.nextInt();
            if (panjang % 2 == 0 && (panjang >= 10 && panjang <= 20)) {
                break;
            } else {
                System.out.println("input an even number & Pick number between 10 - 20");
            }

        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < panjang; i++) {

            result.add(randomFunction());
        }
        Scanner inputgame = new Scanner(System.in);
        while (true) {
            if (result.size() != 0) {
                System.out.print("List");
                for (int r = 0; r < result.size(); r++) {
                    System.out.print(" " + result.get(r));
                }
                System.out.println();
                System.out.println("Pick a number from most left or right");
                int getinput = inputgame.nextInt();
                for (int i = 0; i < result.size(); i++) {
                    if (getinput == result.get(i)) {
//                        System.out.println("ketemu index ke " + i);
                        result.remove(result.get(i));
                        System.out.println("User Pick " + getinput);
                        ScoreUser += getinput;
                        System.out.println("Sum User " + ScoreUser);
                        int randomvalue = random.nextInt(result.size());
                        int getAi;
                   
                        getAi = result.get(randomvalue);
                        result.remove(new Integer(getAi));
                        ScoreAI += getAi;
                        System.out.println("AI Pick " + getAi);
                        System.out.println("Sum AI " + ScoreAI);
                        System.out.println();
                        break;
                    }
                }
            } else {
                break;
            }
        }
        if(ScoreUser > ScoreAI){
            System.out.println("You Winner !!");
        }else if(ScoreUser == ScoreAI){
            System.out.println("Draw ");
        }else{
            System.out.println("Game Over, Your Lose !");
        }
    }
}
