package merge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateMerger {
	
	/**
	 * If the intervals are consecutive or overlapping, do the merge, otherwise remain it.
	 * @param list -- the intervals in the list has been sorted by data_until ASCENDING already.
	 * @return A map with data_since as the key and data_until as the value
	 */
	public static Map<String ,String> merge(List<Interval> list){
		Map<String, String> map = new HashMap<>();
		map.put(list.get(0).getSince(), list.get(0).getUntil());
		String begin = list.get(0).getSince();
		String end = list.get(0).getUntil();
		if(list.size() > 1){
			for (int i = 1; i < list.size() ; i++){
				if(list.get(i).getSince().compareTo(end) <= 0 && list.get(i).getUntil().compareTo(end) > 0){
					map.put(begin, list.get(i).getUntil());
					end = list.get(i).getUntil();
				}else if(list.get(i).getSince().compareTo(end) > 0){
					map.put(list.get(i).getSince(), list.get(i).getUntil());
					begin = list.get(i).getSince();
					end = list.get(i).getUntil();
				}
			}
		}
		return map;
	}

}
