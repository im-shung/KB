import java.util.*;

class City {
	int num;
	String name;
	boolean isVisit;

	public City(int num, String name, boolean isVisit) {
		this.num = num;
		this.name = name;
		this.isVisit = isVisit;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "[num=" + num + ", name=" + name + ", isVisit=" + isVisit + "]";
	}
	
}

class Solution {

	static int CITY_SIZE;
	static int PATH_SIZE;

	static HashMap<String, Integer> city = new HashMap<>();
	static List<List<City>> path = new ArrayList<>();
	static String[] answer;

	public String[] solution(String[][] tickets) {
		PATH_SIZE = tickets.length + 1;

		// 도시Map 생성
		int idx = 0;
		for (String[] ticket : tickets) {
			for (String s : ticket) {
				if (!city.containsKey(s)) {
					city.put(s, idx++);
				}
			}
		}
		
		System.out.println(city);
		
		CITY_SIZE = city.size();
		for (int i = 0; i < CITY_SIZE; i++) {
			path.add(new ArrayList<>());
		}

		for (String[] s : tickets) {
			int a = city.get(s[0]);
			int b = city.get(s[1]);
			// a -> b 경로가 존재한다.
			path.get(a).add(new City(b, s[1], false));
		}

		// 알파벳 순서로 정렬한다.
		for (List<City> p : path) {
			Collections.sort(p, Comparator.comparing(City::getName));
		}

		answer = new String[PATH_SIZE];
		answer[0] = tickets[0][0];
		dfs(0, 1);

		return answer;
	}

	public void dfs(int cur, int idx) {
		System.out.println(Arrays.toString(answer));
		// 1. 목적지인가? -> 항공권을 모두 사용
		if (idx == PATH_SIZE) {
			return;
		}
		// 2. 연결된 곳인가? -> 도시에서 다른 도시로 경로가 존재하는 경우
		System.out.println(cur + ":  " + path.get(cur));
		for (City city : path.get(cur)) {
			// 3. 갈 수 있는가? -> 방문하지 않은 도시
			if (!city.isVisit) {
				// 5. 간다
				city.isVisit = true;
				answer[idx] = city.name;
				dfs(city.num, idx + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(tickets)));
	}
}