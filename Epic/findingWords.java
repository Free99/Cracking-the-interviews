/*
 * Write a program for a word search. If there is an NxN grid 
 * with one letter in each cell. Let the user enter a word and 
 * the letters of the word are said to be found in the grid either 
 * the letters match vertically, horizontally or diagonally in the grid.
 * If the word is found, print the coordinates of the letters as output.
 */

public class findingWords {
	public static void main(String[] args) {
		doTests();
	}
	
	public static boolean wordSearch(String word, char[][] board){  
        if (board == null || board.length == 0 || board[0].length == 0){  
            return false;  
        }  
        if (word.length() == 0){  
            return true;  
        }  
        for (int i = 0; i < board.length; i++){  
            for (int j = 0; j < board[0].length; j++){  
                if (board[i][j] == word.charAt(0)){  
                    boolean res = helperVertical(word, board, i, j, 0) 
                    	       || helperHorizontal(word, board, i, j, 0)
                    	       || helperDiagnal(word, board, i, j, 0);  
                    if (res){  
                        return true;  
                    }  
                }  
            }  
        }  
        return false;  
    }  
  
    public static boolean helperVertical(String word, char[][] board, int i, int j, int index){  
        if (index == word.length()){  
            return true;  
        }  
        if (i < 0 || i >= board.length 
         || j < 0 || j >= board[0].length 
         || board[i][j] != word.charAt(index)){  
            return false;  
        }  
        return helperVertical(word, board, i, j+1, index+1);
    }  
  
    public static boolean helperHorizontal(String word, char[][] board, int i, int j, int index){  
        if (index == word.length()){  
            return true;  
        }  
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){  
            return false;  
        }  
        return helperHorizontal(word, board, i+1, j, index+1);
    }  
  
    public static boolean helperDiagnal(String word, char[][] board, int i, int j, int index){  
        if (index == word.length()){  
            return true;  
        }  
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){  
            return false;  
        }  
        return helperDiagnal(word, board, i+1, j+1, index+1);
    }  
	
	public static void doTests() {
		char[][] board = {
			{ 'a', 'b', 'c', 'd' }, 
			{ 'e', 'f', 'g', 'h' },
			{ 'i', 'j', 'k', 'l' }, 
			{ 'm', 'n', 'o', 'p' } 
		};
		
		if (wordSearch("bgl", board)) {
			System.out.println("Found!");
		} else {
			System.out.println("Failed!");
		}
	}
}
