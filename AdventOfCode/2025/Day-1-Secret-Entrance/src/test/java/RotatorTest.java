import com.example.AdventOfCode.Direction;
import com.example.AdventOfCode.InputException;
import com.example.AdventOfCode.InputLoader;
import com.example.AdventOfCode.Rotator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RotatorTest {

    @Test
    void testDetectRight() throws InputException {

        // Arrange
        Rotator rotator  = new Rotator(0);
        Direction expected = Direction.RIGHT;

        // Act
        Direction direction = rotator.detectDirection("R1");

        // Assert
        assertEquals(expected,direction);

    }

    @Test
    void testDetectLeft() throws InputException {
        // Arrange
        Rotator rotator  = new Rotator(0);
        Direction expected = Direction.LEFT;

        // Act
        Direction direction = rotator.detectDirection("L1");

        // Assert
        assertEquals(expected,direction);
    }
    @Test
    void testDetectUnknown(){
        // Arrange
        Rotator rotator  = new Rotator(0);
        String expected = "No direction found";

        // Act
        String message = assertThrows(InputException.class,() -> rotator.detectDirection("XXX")).getMessage();

        // Assert
        assertEquals(expected, message);
    }
    @Test
    void testNoInputGiven() {
        // Arrange
        Rotator rotator  = new Rotator(0);
        String expected = "No input given";

        // Act
        String message = assertThrows(InputException.class,() -> rotator.detectDirection("")).getMessage();

        // Assert
        assertEquals(expected, message);
    }

    @Test
    void testRotateLeftFromZero(){
        // Arrange
        Rotator rotator = new Rotator(10);
        int expected = 0;
        rotator.pointer = 0;

        // Act
        rotator.rotateLeft(5);
        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_pointerlocationRotateLeftPastZero(){
        // Arrange
        Rotator rotator = new Rotator(10);
        int expected = 9;
        rotator.pointer = 0;
        rotator.rotateLeft(1);

        // Act
        int result = rotator.pointer;

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_pointerlocationRotateToRight(){
        // Arrange
        Rotator rotator = new Rotator(10);
        int expected = 2;
        rotator.pointer = 8;
        rotator.rotateRight(4);

        // Act
        int result = rotator.pointer;

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testRotateLeftNotTouchZero(){
        // Arrange
        Rotator rotator = new Rotator(100);
        rotator.pointer = 2;
        int expected = 1;

        // Act
        rotator.rotateLeft(3);
        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testRotateLeftSameAmountAsPointer(){
        // Arrange
        Rotator rotator = new Rotator(5);
        rotator.pointer = 2;
        int expected = 1;

        // Act
        rotator.rotateLeft(3);
        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testRotateFullRotationPlusOne(){
        // Arrange
        Rotator rotator = new Rotator(10);
        rotator.pointer = 5;
        int expected = 1;

        // Act
        rotator.rotateRight(6);
        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testRotateMultipleTimesToLeft(){
        // Arrange
        Rotator rotator = new Rotator(10);
        rotator.pointer = 5;
        int expected = 1;

        // Act
        rotator.rotateLeft(6);
        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testRotateRightOverEdge(){
        // Arrange
        Rotator rotator = new Rotator(10);
        rotator.pointer = 9;
        int expected = 1;

        // Act
        rotator.rotateRight(3);
        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testRotateFullCircleRight(){
        // Arrange
        Rotator rotator = new Rotator(10);
        rotator.pointer = 5;
        int expected = 1;

        // Act
        rotator.rotateRight(10);
        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_RotateFullCircleRightPlusOne(){
        // Arrange
        Rotator rotator = new Rotator(10);
        rotator.pointer = 5;
        int expected = 2;

        // Act
        rotator.rotateRight(15);
        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expected,result);

    }

    @Test
    void test_rotate_1000_plus(){
        // Arrange
        Rotator rotator = new Rotator(100);
        rotator.pointer = 50;
        int expected = 10;

        // Act
        rotator.rotateRight(1000);
        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expected,result);
    }


    @Test
    void test_CircleRightTestPointer(){
        // Arrange
        Rotator rotator = new Rotator(10);
        rotator.pointer = 5;
        int expected = 5;

        // Act
        int result = rotator.rotateLeft(1000);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_CircleLeftTestPointer(){
        // Arrange
        Rotator rotator = new Rotator(10);
        rotator.pointer = 5;
        int expected = 5;

        // Act
        int result = rotator.rotateLeft(10);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_CircleRightPlus2TestPointer(){
        // Arrange
        Rotator rotator = new Rotator(10);
        rotator.pointer = 5;
        int expected = 0;

        // Act
        int result = rotator.rotateLeft(15);

        // Assert
        assertEquals(expected,result);
    }


    @Test
    void test_Rotate_left_and_right(){
        // Arrange
        Rotator rotator = new Rotator(2);
        rotator.pointer = 1;
        int expected = 2;

        // Act
        rotator.rotateRight(1);
        rotator.rotateLeft(2);
        rotator.rotateRight(1);

        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expected,result);
    }

    static Stream<Arguments> rotateChecks() {
        return Stream.of(
                Arguments.of("L68", 82),
                Arguments.of("L30", 52),
                Arguments.of("R48", 0),
                Arguments.of("L5", 95),
                Arguments.of("R60", 55),
                Arguments.of("L55", 0),
                Arguments.of("L1", 99),
                Arguments.of("L99", 0),
                Arguments.of("R14", 14),
                Arguments.of("L82", 32)

        );
    }

    @ParameterizedTest
    @MethodSource("rotateChecks")
    void test_MultipleLines(String rotateID, int expected) throws InputException {
        // Arrange
        Rotator rotator = new Rotator(100);
        rotator.pointer = 50;
        int expectedZeroTouch = 6;
        List<String> dialString = List.of(
                "L68",
                "L30",
                "R48",
                "L5",
                "R60",
                "L55",
                "L1",
                "L99",
                "R14",
                "L82"
        );
        // Act
        for (String line: dialString){
            Direction direction = rotator.detectDirection(line);

            int amount = Integer.parseInt(line.substring(1));

            int dailResult = switch (direction){
                case RIGHT -> rotator.rotateRight(amount);
                case LEFT -> rotator.rotateLeft(amount);
            };

            if (line.equals(rotateID)){
                assertEquals(expected,dailResult);
            }

        }
        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expectedZeroTouch,result);
    }

    @Test
    void test_finalTest() throws InputException, URISyntaxException, IOException {
        // Arrange
        Rotator rotator = new Rotator(100);
        rotator.pointer = 50;
        int expected = 6892;

        List<String> dialString = new InputLoader().loadInput("puzzle-input.txt");

        for (String line: dialString){

            Direction direction = rotator.detectDirection(line);
            int amount = Integer.parseInt(line.substring(1));

            switch (direction){
                case RIGHT -> rotator.rotateRight(amount);
                case LEFT -> rotator.rotateLeft(amount);
            }

        }

        int result = rotator.getCrosZeroCount();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_rotateAroundZero(){
        // Arrange
        Rotator rotator = new Rotator(2);
        rotator.pointer = 0;
        int expected = 0;

        // Act
        rotator.rotateRight(1);
        rotator.rotateLeft(2);
        rotator.rotateLeft(1);
        int result = rotator.pointer;

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_rotateToLeft(){
        // Arrange
        Rotator rotator = new Rotator(100);
        rotator.pointer = 5;
        int expected = 95;

        // Act
        rotator.rotateLeft(10);
        int result = rotator.pointer;

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_rotateZeroTimes(){
        // Arrange
        Rotator rotator = new Rotator(10);
        rotator.pointer = 5;
        int expected = 5;

        // Act
        rotator.rotateLeft(0);
        rotator.rotateRight(0);
        int result = rotator.pointer;

        // Assert
        assertEquals(expected,result);
    }


}