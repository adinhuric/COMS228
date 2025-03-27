package hw4;

import java.util.Stack;
/**
 *  
 * @author Adin Huric
 *
 */
public class MsgTree {
	public char payloadChar;
	public MsgTree left;
	public MsgTree right;
	private static int staticCharIdx = 1;

	// Constructor building the tree from a string
	public MsgTree(String encodingString) {
		if (encodingString == null) {
			return;
		}
		Stack<MsgTree> stack = new Stack<>();
		payloadChar = encodingString.charAt(0);
		MsgTree current = this;
		boolean left = true;
		stack.push(this);

		while (staticCharIdx < encodingString.length()) {
			char ch = encodingString.charAt(staticCharIdx++);
			MsgTree next = new MsgTree(ch);

			if (left) {
				current.left = next;
				if (ch == '^') {
					current = stack.push(next);
				} else {
					if (!stack.isEmpty()) {
						current = stack.pop();
					}
					left = false;
				}
			} else {
				current.right = next;
				if (ch == '^') {
					current = stack.push(next);
					left = true;
				} else {
					if (!stack.isEmpty()) {
						current = stack.pop();
					}
					left = false;
				}
			}
		}
	}

	// Constructor for a single node with null children
	public MsgTree(char payloadChar) {
		this.payloadChar = payloadChar;
		left = null;
		right = null;
	}

	// method to print characters and their binary codes
	public static void printCodes(MsgTree root, String code) {
		
		if (code.length() > 0 && code.charAt(0) != '1' && code.charAt(0) != '0') {
			code = "";
		}

		if (root.left == null && root.right == null) {
			char ch = root.payloadChar;
			if (ch != '\n') {
				System.out.println(ch + "     	 " + code);
			} else if (ch == '\n'){
				System.out.println("\\n     	 " + code);
			}
		} else {
			if (root.left != null) {
				printCodes(root.left, code + "0");
			}
			if (root.right != null) {
				printCodes(root.right, code + "1");
			}
		}
	}

	public void decode(MsgTree codes, String msg) {

		MsgTree root = codes;
		MsgTree current = codes;
		String str = "";

		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == '0') {
				current = current.left;
			} else {
				current = current.right;
			}
			if (current.payloadChar != '^') {
				str += current.payloadChar;
				current = root;
			}
		}
		System.out.println(str);
	}
}
