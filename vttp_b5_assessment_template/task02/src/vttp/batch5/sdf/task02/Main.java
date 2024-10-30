package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		String filename = args[0];
		TTT game = new TTT();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line = null;
			int i = 0;
			System.out.println("Board:");
			while ((line = br.readLine()) != null){
				System.out.println(line);
				game.board[i] = line.toCharArray();
				i++;
			}
			game.possibleMoves();

		} catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
	}
}
