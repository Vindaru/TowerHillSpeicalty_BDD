package utilities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class THS_States_Utils {

	private static final Map<String, String> STATES_MAP = new HashMap<>();

	static {
		STATES_MAP.put("Alabama", "AL");
		STATES_MAP.put("Arizona", "AZ");
		STATES_MAP.put("Arkansas", "AR");
		STATES_MAP.put("Georgia", "GA");
		STATES_MAP.put("Illinois", "IL");
		STATES_MAP.put("Indiana", "IN");
		STATES_MAP.put("Louisiana", "LA");
		STATES_MAP.put("Michigan", "MI");
		STATES_MAP.put("Mississippi", "MS");
		STATES_MAP.put("Missouri", "MO");
		STATES_MAP.put("Ohio", "OH");
		STATES_MAP.put("South Carolina", "SC");
		STATES_MAP.put("Texas", "TX");
		STATES_MAP.put("North Carolina", "NC");
		STATES_MAP.put("Tennessee", "TN");
		STATES_MAP.put("Wisconsin", "WI");
	}

	public static String getShortForm(String stateName) {
		return STATES_MAP.getOrDefault(stateName, "Unknown");
	}

	public static String getFullName(String shortForm) {
		return STATES_MAP.entrySet().stream().filter(entry -> entry.getValue().equals(shortForm)).map(Map.Entry::getKey)
				.findFirst().orElse("Unknown");
	}

	// Optional: To get all state names
	public static Set<String> getAllStateNames() {
		return STATES_MAP.keySet();
	}

	// Optional: To get all short forms
	public static Collection<String> getAllShortForms() {
		return STATES_MAP.values();
	}

}
