import org.example.LevelParser;
import org.example.ParceException;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LevelParserTest {

    @Test
    void constructorTest(){
        // Arrange + Act
        LevelParser levelParser = new LevelParser();
        // Assert
        assertNotNull(levelParser);
    }

    @Test
    void testParseLine() throws ParceException {
    //    Arrange
    LevelParser levelParser = new LevelParser();
    int expected = 2;
    //    Act
    List<String> resultList = levelParser.parseLevel("1 2");
    //    Assert
    assertEquals(expected,resultList.size());
    }

    @Test
    void testParseLineEmptyWhiteSpaceBehind() throws ParceException {
        //    Arrange
        LevelParser levelParser = new LevelParser();
        int expected = 2;
        //    Act
        List<String> resultList = levelParser.parseLevel("1 2 ");
        //    Assert
        assertEquals(expected,resultList.size());
    }

    @Test
    void testParseLineMultipleInts() throws ParceException {
        //    Arrange
        LevelParser levelParser = new LevelParser();
        int expected = 9;
        //    Act
        List<String> resultList = levelParser.parseLevel("1 2 33 4 55 6 77 8 9");
        //    Assert
        assertEquals(expected,resultList.size());
    }

    @Test
    void testEmptyParseLine() throws ParceException {
        //    Arrange
        LevelParser levelParser = new LevelParser();
        int expected = 0;
        //    Act
        assertThrows(ParceException.class,() ->levelParser.parseLevel(""));
    }
    @Test
    void testEmptyParseLineException() throws ParceException {
        //    Arrange
        LevelParser levelParser = new LevelParser();
        String expected = "Input is empty";
        //    Act
        String message = assertThrows(ParceException.class,() ->levelParser.parseLevel("")).getMessage();
        assertEquals(expected, message);
    }

    @Test
    void testConvertToIntegerList(){
    //    Arrange
    LevelParser levelParser = new LevelParser();
    int expected = 1;
    List<String> stringList = List.of("1");
    //    Act
    List<Integer> integerList = levelParser.convertToIntegerList(stringList);

    //    Assert
    assertEquals(expected,integerList.size());
    }
}
