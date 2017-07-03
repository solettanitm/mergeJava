package merge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class DateMergerTest {
	
	@Test
	public void testConsecutive(){
		Interval i1 = new Interval("2017-01-01", "2017-01-02");
		Interval i2 = new Interval("2017-01-02", "2017-01-04");
		Interval i3 = new Interval("2017-01-06", "2017-01-07");
		List<Interval> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		Map<String, String> map = DateMerger.merge(list);
		assertTrue(map.size() == 2);
		assertTrue(map.get("2017-01-01").equals("2017-01-04"));
		assertTrue(map.get("2017-01-02") == null);
		assertTrue(map.get("2017-01-06").equals("2017-01-07"));
	}

	@Test
	public void testOverlapping(){
		Interval i1 = new Interval("2017-01-01", "2017-01-04");
		Interval i2 = new Interval("2017-01-03", "2017-01-05");
		Interval i3 = new Interval("2017-01-05", "2017-01-07");
		List<Interval> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		Map<String, String> map = DateMerger.merge(list);
		assertTrue(map.size() == 1);
		assertTrue(map.get("2017-01-01").equals("2017-01-07"));
		assertTrue(map.get("2017-01-03") == null);
		assertTrue(map.get("2017-01-05") == null);
	}
	
	@Test
	public void testDisjunct(){
		Interval i1 = new Interval("2017-01-01", "2017-01-02");
		Interval i2 = new Interval("2017-01-03", "2017-01-04");
		Interval i3 = new Interval("2017-01-06", "2017-01-07");
		List<Interval> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		Map<String, String> map = DateMerger.merge(list);
		assertTrue(map.size() == 3);
		assertTrue(map.get("2017-01-01").equals("2017-01-02"));
		assertTrue(map.get("2017-01-03").equals("2017-01-04"));
		assertTrue(map.get("2017-01-06").equals("2017-01-07"));
	}
}
