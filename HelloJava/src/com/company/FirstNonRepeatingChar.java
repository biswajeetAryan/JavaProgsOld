ackage com.company;

public class FirstNonRepeatingChar {
	private static int findIt(String str) {
		char[] count = new char[256];
		for(int i=0;i<str.length();i++) {
			count[str.charAt(i)]++;
		}
		
		for(int i=0;i<str.length();i++) {
			if(count[str.charAt(i)] == 1)
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		String str = "abbccssddart";
		int ind = findIt(str);
		if(ind != -1)
			System.out.println(str.charAt(ind));
	}	
}
