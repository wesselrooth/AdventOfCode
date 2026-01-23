import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.StoneChecker;

class CacheTests {

    @Test
    void testBaseCase(){
        // Arrange
        StoneChecker checker = new StoneChecker(new HashMap<>());
        Long expected = 1L;
        checker.blinker(List.of(1L,1L), 1L);
        Map<String,Long> cache = checker.getCache();
        
        // Act
        long cacheValue  = cache.get("1::1");
        
        // Assert
        assertEquals(expected, cacheValue);
    }

    @Test
    void testTwoBlinksInCache(){
        // Arrange    
        StoneChecker checker = new StoneChecker(new HashMap<>());
        String expected ="0::5"; 
        
        // Act
        checker.blinker(List.of(0L), 5L);
        Map<String,Long> cache = checker.getCache();
        
        // Assert
        assertTrue(cache.containsKey(expected));
    }

    @Test
    void testOfCacheValueOfZeroAfter5Blinks(){
        // Arrange    
        StoneChecker checker = new StoneChecker(new HashMap<>());
        long expected = 4L; 
        String key = "0::5";

        // Act
        checker.blinker(List.of(0L), 5L);

        // Assert
        Map<String, Long> cache = checker.getCache();
        assertEquals(expected, cache.get(key));
    }
}
