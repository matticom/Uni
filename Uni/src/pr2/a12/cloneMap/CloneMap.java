package pr2.a12.cloneMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class CloneMap {
	protected Map<String, Boolean> cloneHashMap(Map<String, Boolean> map) {
		Map<String, Boolean> clonedMap = new HashMap<String, Boolean>();
		Set<Entry<String, Boolean>> entrySet = map.entrySet();
		for (Entry<String, Boolean> entry :entrySet){
			clonedMap.put(entry.getKey(), entry.getValue());
		}
		return clonedMap;
	}
}
