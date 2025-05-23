package _03_Hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener, ActionListener{
	public static String obscurify(String s, Set<Character> guesses2) {
		StringBuilder out = new StringBuilder("");
		for(int i = 0; i < s.length(); i ++) {
			if(guesses2.contains(s.charAt(i))){
				out.append(s.charAt(i));
			}
			else out.append('_');
		}
		return out.toString();
	}
	JPanel panel = new JPanel();
	
	JFrame frame = new JFrame("Hangman");
	
	JLabel text = new JLabel();
	
	int start_lives = 10;
	
	int lives = start_lives;
	
	String word;
	
	Set<Character> guesses = new HashSet<>();
	
	Stack<String> stack = new Stack<>();
	
	String obscText = "";
	
	public Hangman() {
		
		
		int rounds = Integer.valueOf(JOptionPane.showInputDialog("Enter the amount of rounds you would like to play (1-100):"));
		
		
		for(int i = 0; i < rounds; i ++) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if(!stack.contains(word))
				{stack.push(word);}
			else {
				i --;
			}
		}
		word = stack.pop();
		
				
		obscText = obscurify(word, guesses);
		text.setText(obscText + " lives: " + lives);
		panel.add(text);
		frame.addKeyListener(this);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args){
		Hangman man = new Hangman();
		String str;
		while(!man.stack.empty()) {
			
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
				
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
//	onDialog(Component parentComponent,
//            Object message,
//            String title,
//            int optionType,
//            int messageType,
//            Icon icon,
//            Object[] options,
//            Object initialValue)
//     throws HeadlessException
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		Character letter = arg0.getKeyChar();
		if(Character.isAlphabetic(Character.toLowerCase(letter))) {
		if(lives >= 1){
			if(guesses.add(Character.toLowerCase(letter))) {
				if(obscText.equals(obscurify(word, guesses)))lives --;
			}}
		obscText = obscurify(word, guesses);
		text.setText(obscText + " lives: " + lives);
		if (obscurify(word, guesses).indexOf('_') == -1) {
			int choice = JOptionPane.showOptionDialog(frame, "You guessed the word! Do you want to play again?", "Victory", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					new String[] {"no", "yes"}, "yes");
			if (choice == 1 && !stack.empty()) {
				
				word = stack.pop();
				guesses.clear();
				lives = start_lives;
				text.setText(obscurify(word, guesses) + " lives: " + lives);
			}
			else {
				System.exit(0);
			}
			
			
		}
		else if(lives <= 0) {
			int choice = JOptionPane.showOptionDialog(frame, "You lost, the word was " + word + "! Do you want to play again?", "Defeat", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					new String[] {"no", "yes"}, "yes");
			if (choice == 1 && !stack.empty()) {
				
				word = stack.pop();
				guesses.clear();
				lives = start_lives;
				text.setText(obscurify(word, guesses) + " lives: " + lives);
			}
			else {
				System.exit(0);
			}

		}
		}
	}
}
