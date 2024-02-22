package input;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class InputData {
	private static final char WORD_SEPERATOR = ' ';
	private static final String VOWEL_CHARS = "aeiouy";
	
	private String value;
	
	protected InputData(String input){
		if(input == null){
			throw new NullPointerException();
		}
		
		this.value = input.toLowerCase();
	}
	
	public void display(){
		System.out.println("Nr of characters: " + getTotalCharacterCount());
		System.out.println("Nr of words: " + getWordCount());
		System.out.println("Nr of vowels: " + getVowelCount());
		System.out.println("Is palindrome: " + isPalindrome());
		
		System.out.println();
		
		displayCharCountGraph();
	}
	
	private void displayCharCountGraph(){
		char[] allCharacters = getAllAlphaNumericCharactersIncludingSpace();
		int highestCount = getHighestCharacterCount();
		
		String[] countLines = initCountLines(highestCount);
		String allCharacterDisplayString = "";
		
		boolean first = true;
		
		for(char c : allCharacters){
			String newValue = " * ";
			
			String characterDisplayString = "'" + c + "'";
			
			if(!first){
				newValue = " " + newValue;
				characterDisplayString = " " + characterDisplayString;
			}
			
			appendToLines(countLines, newValue, getCharacterCount(c));
			allCharacterDisplayString += characterDisplayString;
			
			first = false;
		}
		
		for(String line : countLines){
			System.out.println(line);
		}
		
		System.out.println(allCharacterDisplayString);
	}
	
	private static char[] getAllAlphaNumericCharactersIncludingSpace(){
		int alphabetCharacterCount = 'z' - 'a' + 1;
		int numberCount = '9' - '0' + 1;
		char[] characters = new char[alphabetCharacterCount + numberCount + 1];
		
		int index = 0;
		
		for(char c = 'a'; c <= 'z'; c++){
			characters[index] = c;
			index++;
		}
		
		for(char c = '0'; c <= '9'; c++){
			characters[index] = c;
			index++;
		}
		
		characters[index] = InputData.WORD_SEPERATOR;
		
		return characters;
	}
	
	private static String[] initCountLines(int maxCount){
		String[] countLines = new String[maxCount];
		
		for(int i = 0; i < countLines.length; i++){
			countLines[i] = "";
		}
		
		return countLines;
	}
	
	private static void appendToLines(String[] lines, String appendValue, int count){
		int currentCount = 0;
		String emptyValue = "";
		
		for(int i = 0; i < appendValue.length(); i++){
			emptyValue += ' ';
		}
		
		for(int i = lines.length - 1; i >= 0; i--){
			lines[i] = lines[i] + (currentCount < count ? appendValue : emptyValue);
			currentCount++;
		}
	}
	
	private int getTotalCharacterCount(){
		return value.length();
	}
	
	private int getCharacterCount(char character){
		int count = 0;
		
		for(char c : value.toCharArray()){
			if(character == c){
				count++;
			}
		}
		
		return count;
	}
	
	private int getHighestCharacterCount(){
		Map<Character, Integer> countMap = new HashMap<>();
		
		int highestCount = 0;
		
		for(char c : value.toCharArray()){
			int count = 1;
			
			if(countMap.containsKey(c)){
				count += countMap.get(c);
			}
			
			if(highestCount < count){
				highestCount = count;
			}
			
			countMap.put(c, count);
		}
		
		return highestCount;
	}
	
	private int getWordCount(){
		int count = 0;
		int pos = -1;
		
		while(true){
			int newPos = value.indexOf(WORD_SEPERATOR, pos + 1);
			
			if(newPos == -1){
				if(pos + 1 < value.length()){
					count++;
				}
				
				break;
			}
			
			if(newPos - pos > 1){
				count++;
			}
			
			pos = newPos;
		}
		
		return count;
	}
	
	private int getVowelCount(){
		int count = 0;
		
		for(char c : value.toCharArray()){
			if(isVowel(c)){
				count++;
			}
		}
		
		return count;
	}
	
	private boolean isPalindrome(){
		String joinedValue = value.replace(" ", "");
		
		for(int i = 0; i < joinedValue.length() / 2; i++){
			char startChar = joinedValue.charAt(i);
			char endChar = joinedValue.charAt(joinedValue.length() - (i + 1));
			
			if(startChar != endChar){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean isVowel(char c){
		return VOWEL_CHARS.indexOf(c) > -1;
	}
}