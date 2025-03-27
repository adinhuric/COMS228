package hw4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 
 * @author Adin Huric
 *
 */
public class main {
	public static void main(String[] args) throws IOException {
		System.out.println("Please enter filename to decode:");
		Scanner sc = new Scanner(System.in);
		String file = sc.nextLine();
		String result = "";
		Path path = Paths.get(file);
		String str = Files.readString(path).trim();
		int index = str.lastIndexOf('\n');
		String character = str.substring(0, index);
		String code = str.substring(index).trim();
		
		for(int i = 0; i < character.length(); i++) {
			if(character.charAt(i) != '^') {
				result += character.charAt(i);
			}
		}
		MsgTree root = new MsgTree(character);
		System.out.println("character code");
		System.out.println("-------------------------");
		MsgTree.printCodes(root, result);
		System.out.println("MESSAGE:");
		root.decode(root, code);
		sc.close();
	}
}