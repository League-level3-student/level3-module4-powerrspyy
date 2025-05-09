package _00_IntroToStacks;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener{
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */

	JFrame frame = new JFrame("Text Editor");
	
	JPanel panel = new JPanel();
	
	JLabel label = new JLabel();
	
	StringBuilder sb = new StringBuilder("");
	
	Stack<Character> stack = new Stack<>();
	
	public static void main(String[] array) {
		new _02_TextUndoRedo();
		
		
	}
	public _02_TextUndoRedo()  {
		label.setText(sb.toString());
		panel.add(label);
		frame.add(panel);
		frame.addKeyListener(this);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if(sb.toString() != "") {
				stack.push(sb.charAt(sb.length() - 1));
				sb.deleteCharAt(sb.length()-1);
				label.setText(sb.toString());
				System.out.println("Removed a char, new string: " + sb.toString());}
		}
		if(arg0.getKeyCode() == KeyEvent.VK_UP) {
			if(stack.size() > 0) {
				sb.append(stack.pop());
				label.setText(sb.toString());
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {

		// TODO Auto-generated method stub
		if(e.getExtendedKeyCode() != KeyEvent.VK_BACK_SPACE && e.getExtendedKeyCode() != KeyEvent.VK_UP) {
			char key = e.getKeyChar();
			sb.append(key);
			label.setText(sb.toString());
			System.out.println("Added: " + key);
		}
		
		
		
		
		
	}


}
