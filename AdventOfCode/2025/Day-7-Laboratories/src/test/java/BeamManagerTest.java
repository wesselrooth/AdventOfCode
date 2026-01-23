import com.example.AdventOfCode.BeamManager;
import com.example.AdventOfCode.InputLoader;
import com.example.AdventOfCode.Splitter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeamManagerTest {

    @Test
    void constructorTest(){
        // Arrange
        BeamManager manager = new BeamManager();

        // Act + Assert
        assertNotNull(manager);
    }

    @Test
    void testLocateNextSplitter() {
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                List.of("|"),
                List.of("^")
        );
        String expected = "0,1";

        // Act
        Splitter result = manager.findAllSplitter(input).get(0);

        // Assert
        assertEquals(expected,result.toString());
    }

    @Test
    void testLocateSplitterWithSpaceInBetween() {
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                List.of("|"),
                List.of("."),
                List.of("^")
        );
        String expected = "0,2";

        // Act
        Splitter result = manager.findAllSplitter(input).get(0);

        // Assert
        assertEquals(expected,result.toString());
    }

    @Test
    void createBeamLeftOfSplitter(){
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                Arrays.asList(
                    ".","^","."
                )
        );
        String expected = "|";

        List<Splitter> splittersList = List.of(new Splitter(1,0));

        // Act
        String result = manager.createNewBeams(input,splittersList).get(0).get(0);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void createBeamRightOfSplitter(){
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                Arrays.asList(
                        ".","^","."
                )
        );
        String expected = "|";

        List<Splitter> splittersList = List.of(new Splitter(1,0));

        // Act
        String result = manager.createNewBeams(input,splittersList).get(0).get(2);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void extendBeamDownwards(){
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                Arrays.asList("|"),
                Arrays.asList("."),
                Arrays.asList(".")
        );
        String expected = "|";

        // Act
        String result = manager.extendBeam(input).get(1).get(0);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void extendBeamDownwardsUntilSplitter(){
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                Arrays.asList("|"),
                Arrays.asList("."),
                Arrays.asList("."),
                Arrays.asList("^")
        );
        String expected = "^";

        // Act
        String result = manager.extendBeam(input).get(3).get(0);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_BeamTouchesSplitter(){
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                Arrays.asList("|"),
                Arrays.asList("^")
        );
        int expected = 1;

        // Act
        int result = manager.countTouchingBeamsToSplitter(input);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void partOneTest() throws URISyntaxException, IOException {
        // Arrange
        InputLoader inputLoader = new InputLoader();
        List< List<String> > input = inputLoader.loadInput("test-input");

        BeamManager manager = new BeamManager();
        int expected = 21;

        // Act
        List<Splitter> splitterList = manager.findAllSplitter(input);
        List<List<String>> updatedInput = manager.createNewBeams(input,splitterList);
        List<List<String>> extendedBeamInput = manager.extendBeam(updatedInput);
        int result = manager.countTouchingBeamsToSplitter(extendedBeamInput);

        // Assert
        result++;
        assertEquals(expected,result);
    }

    @Test
    void partOneIntergrationTest() throws URISyntaxException, IOException {
        // Arrange
        InputLoader inputLoader = new InputLoader();
        List< List<String> > input = inputLoader.loadInput("test-input");

        BeamManager manager = new BeamManager();
        int expected = 21;

        // Act
        List<Splitter> splitterList = manager.findAllSplitter(input);
        List<List<String>> updatedInput = manager.createNewBeams(input,splitterList);
        List<List<String>> extendedBeamInput = manager.extendBeam(updatedInput);
        int result = manager.countTouchingBeamsToSplitter(extendedBeamInput);

        // Assert
        result++;
        assertEquals(expected,result);
    }

    @Test
    void partOneOfficalTest() throws URISyntaxException, IOException {
        // Arrange
        InputLoader inputLoader = new InputLoader();
        List< List<String> > input = inputLoader.loadInput("puzzle-input");
        BeamManager manager = new BeamManager();
        int expected = 1703;

        // Act
        List<Splitter> splitterList = manager.findAllSplitter(input);
        List<List<String>> updatedInput = manager.createNewBeams(input,splitterList);
        List<List<String>> extendedBeamInput = manager.extendBeam(updatedInput);
        int result = manager.countTouchingBeamsToSplitter(extendedBeamInput);

        // Assert
        result++;
        assertEquals(expected,result);
    }

}