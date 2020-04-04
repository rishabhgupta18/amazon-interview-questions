package arrays.and.string;

import java.util.Arrays;

public class ReorderLogFiles {

	public static void main(String[] args) {

		ReorderLogFiles rr = new ReorderLogFiles();
		String[] ss = rr.reorderLogFiles(
				new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" });
		System.out.println(Arrays.toString(ss));
	}

	public String[] reorderLogFiles(String[] logs) {

		Arrays.sort(logs, (String a, String b)->{
			boolean isCharA = Character.isLetter(a.charAt(a.length()-1));
            boolean isCharB = Character.isLetter(b.charAt(b.length()-1));
            if(!isCharA && !isCharB) return 0;//means both digits and continue
            if(isCharA && !isCharB) return -1;// mean A is letter so it comes before B
            if(!isCharA&& isCharB) return 1;//means B is letter so comes before A
            //Compare both Strings except identifier
            int compare = a.substring(a.indexOf(' ')).compareTo(b.substring(b.indexOf(' ')));
            //If both equals
            //compare the identifier
            return compare == 0? a.compareTo(b): compare;
        });
		return logs;
	}

}
