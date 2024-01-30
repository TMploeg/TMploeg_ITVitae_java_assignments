public class Encoder{
	private static final int CAESAR_OFFSET = 3;
	
	public static String caesarEncode(String str){
		if(str == null){
			throw new NullPointerException("'str' is null");
		}
		
		String encodedStr = "";
		
		for(int i = 0; i < str.length(); i++){
			encodedStr += (char)(str[i] + CAESAR_OFFSET);
		}
		
		return encodedStr;
	}
}