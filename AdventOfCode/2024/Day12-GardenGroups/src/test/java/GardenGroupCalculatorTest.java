import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import com.example.AdventOfCode.GardenGroupCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GardenGroupCalculatorTest {

    static Stream<Arguments> filenames() {
        return Stream.of(
                Arguments.of("unit-test-input.txt", 1206),
                Arguments.of("puzzle-input.txt", 902620),
                Arguments.of("small-intergration-test.txt", 80),
                Arguments.of("E-size-test.txt", 204),
                Arguments.of("x-o-input.txt", 436),
                Arguments.of("final-unit-test-a-b.txt", 368)
        );
    }

    @ParameterizedTest
    @MethodSource("filenames")
    void intergrationTest(String filename, int expected) throws URISyntaxException, IOException{
        // Arrange
        GardenGroupCalculator gardenGroupCalculator = new GardenGroupCalculator();
        
        // Act
        int result = gardenGroupCalculator.calculateGardenGroupPrice(filename);
        
        // Assert
        assertEquals(expected, result);
    }
}
