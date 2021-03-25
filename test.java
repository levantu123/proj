package pre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

	List<Object> getList(Map<Integer, List<Common>> map) {

		Map<Integer, Map<String, List<Infor>>> extractedMap = new HashMap<>();
		for (Integer week : map.keySet()) {
			Map<String, List<Infor>> nameInforsIntheWeek = new HashMap<String, List<Infor>>();

			for (Common e : map.get(week)) {
				List<Infor> infors;
				if (nameInforsIntheWeek.containsKey(e.name)) {
					infors = nameInforsIntheWeek.get(e.name);
				} else {
					infors = new ArrayList<>();
				}

				infors.addAll(e.getInfors());
				nameInforsIntheWeek.put(e.name, infors);
			}
			extractedMap.put(week, nameInforsIntheWeek);

		}

		for (Integer we : extractedMap.keySet()) {
			Map<String, List<Infor>> oneperson = extractedMap.get(we);
			for (String name : oneperson.keySet()) {
				Weekly weekly = new Weekly();
				weekly.setName(name);
				List<Infor> ifs = oneperson.get(name);
				int sum = 0;
				for (Infor ifo : ifs) {
					sum+= ifo.getNum();
				}
				weekly.setSum(sum);
			}
		}

		return null;
	}

	class Common {

		private String name;

		private List<Infor> infors;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Infor> getInfors() {
			return infors;
		}

		public void setInfors(List<Infor> infors) {
			this.infors = infors;
		}

	}

	class Weekly {
		private String name;
		private int sum;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		}

	}

	class Infor {
		private int num;

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

	}

}
