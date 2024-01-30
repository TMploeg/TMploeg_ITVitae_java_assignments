public class Encoder{
	private static final int CAESAR_OFFSET = 3;
	
	public static String caesarEncode(String str){
		String encodedStr = "";
		
		for(char c : str.toCharArray()){
			encodedStr += (char)(c + CAESAR_OFFSET);
		}
		
		return encodedStr;
	}
}