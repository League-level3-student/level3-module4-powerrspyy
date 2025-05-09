package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack<Character> stack = new Stack<>();
    	for(int i = 0; i < b.length(); i++) {
    		if (b.charAt(i) == '{') {
    			stack.push('}');
    		}
    		else if (!stack.isEmpty() && b.charAt(i) == stack.peek()) {
    			stack.pop();
    		}
    		else {
    			return false;
    		}
    	}
    	if(stack.size() == 0)return true;
    	else return false;
    }
}