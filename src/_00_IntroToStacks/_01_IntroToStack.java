package _00_IntroToStacks;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
    	Stack<Double> doubles = new Stack<Double>();
    	Scanner scanner = new Scanner(System.in);

        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
    	Random random = new Random();
    	for(int i = 0; i < 100; i ++) {
    		doubles.push(random.nextDouble() * 100);
    	}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
    	System.out.println("Enter a number from 1 to 100: ");
    	int num1 = scanner.nextInt();
    	System.out.println("Enter a second number from 1 to 100");
    	int num2 = scanner.nextInt();
    	if(num2 < num1) {
    		int temp = num1;
    		num1 = num2;
    		num2 = temp;
    	}
    	int numsInRange = 0;
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
    	System.out.println("Popping elements off stack...\nElements between " + num1 + " and " + num2);
    	while(doubles.size() > 0) {
    		Double nextNum = doubles.pop();
    		if(nextNum < num2 && nextNum > num1) {
    			System.out.println(nextNum);
    			numsInRange ++;
    		}
    		
    	}
    	System.out.println("There were " + numsInRange + " nums in the specified range");

        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}
