package com.productiveAnalytics.springBoot.di;

import java.util.Map;
import java.util.Optional;

/**
 * Persistence layer
 * 
 * @author lchawathe
 */
public interface DatastoreService {
	Optional<Map<String, Object>> retrieve(String city);
}
