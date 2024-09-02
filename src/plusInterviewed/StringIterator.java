package plusInterviewed;

public class StringIterator {
	public StringBuilder sb = new StringBuilder();
	int ptr = 0;
	
    public StringIterator(String compressedString) {
    	int n = compressedString.length();
    	int i = 0;
    	while (i< n-1) {
			char ch = compressedString.charAt(i++);
			int cnt = 0;
            while (i <n && Character.isDigit(compressedString.charAt(i))) {
                cnt = cnt * 10 + compressedString.charAt(i) - '0';
                i++;
            }
			for (int j= 0; j<cnt; j++) {
				sb.append(ch);
			}
		}
    }
    
    public char next() {
    	if(!hasNext()) {
    		return ' ';
    	}
    	return sb.charAt(ptr++);
    }
    
    public boolean hasNext() {
    	return ptr != sb.length();
    }
}
