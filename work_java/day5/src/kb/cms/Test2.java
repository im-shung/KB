package kb.cms;

import java.util.*;

public class Test2 {

	public static void main(String[] args) {
		
		List<String> ss = new ArrayList<>();
		ss.add("Kim");
		ss.add("Hong");
		ss.add("Bu");
		ss.add("Lee");
		
		Collections.sort(ss, Collections.reverseOrder());
		for (String s : ss) {
			System.out.println(s);
		}
		
		System.out.println("=====================");
		String[] s2 = {"Kim", "Hong", "Bu", "Lee"};
		Arrays.sort(s2);
		for (String s : s2) {
			System.out.println(s);
		}
		System.out.println(Arrays.toString(s2));
	}

}
