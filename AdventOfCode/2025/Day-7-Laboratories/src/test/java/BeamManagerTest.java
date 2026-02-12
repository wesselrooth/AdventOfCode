import com.example.AdventOfCode.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeamManagerTest {

    InputLoader loader = new InputLoader();

    @Test
    void testLocateNextSplitter() {
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                List.of("|"),
                List.of("^")
        );
        String expected = "0,1";
        InputLoader loader = new InputLoader();
        Grid grid = loader.convertRawInputToGrid(input);
        GridManager gridManager = new GridManager();
        // Act
        Splitter result = gridManager.findAllSplitter(grid).get(0);

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
        InputLoader loader = new InputLoader();
        Grid grid = loader.convertRawInputToGrid(input);
        GridManager gridManager = new GridManager();
        // Act
        Splitter result = gridManager.findAllSplitter(grid).get(0);

        // Assert
        assertEquals(expected,result.toString());
    }

    @Test
    void createBeamLeftOfSplitter(){
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                Arrays.asList(
                    ".^.".split("")
                )
        );
        String expected = "|";

        List<Splitter> splittersList = List.of(new Splitter(1,0));

        Grid grid = loader.convertRawInputToGrid(input);

        // Act
        String result = manager.createNewBeams(grid,splittersList).getRow(0).getIcon(0).getIcon();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void createBeamRightOfSplitter(){
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                Arrays.asList(
                        ".^.".split("")
                )
        );
        String expected = "|";
        InputLoader loader = new InputLoader();
        Grid grid = loader.convertRawInputToGrid(input);
        List<Splitter> splittersList = List.of(new Splitter(1,0));

        // Act
        String result = manager.createNewBeams(grid,splittersList).getRow(0).getIcon(2).getIcon();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void extendAllBeamsDownwards(){
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                Arrays.asList("|"),
                Arrays.asList("."),
                Arrays.asList(".")
        );
        String expected = "|";
        Grid grid = loader.convertRawInputToGrid(input);
        // Act
        String result = manager.extendAllBeams(grid).getRow(1).getIcon(0).getIcon();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void extendAllBeamsDownwardsUntilSplitter(){
        // Arrange
        BeamManager manager = new BeamManager();
        List< List<String> > input = List.of(
                Arrays.asList("|"),
                Arrays.asList("."),
                Arrays.asList("."),
                Arrays.asList("^")
        );
        String expected = "^";
        Grid grid = loader.convertRawInputToGrid(input);

        // Act
        String result = manager.extendAllBeams(grid).getRow(3).getIcon(0).getIcon();

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
        long expected = 1;
        Grid grid = loader.convertRawInputToGrid(input);

        // Act
        long result = manager.countTouchingBeamsToSplitter(grid);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void partOneTest() throws URISyntaxException, IOException {
        // Arrange
        InputLoader inputLoader = new InputLoader();
        List< List<String> > input = inputLoader.loadInput("test-input");

        BeamManager manager = new BeamManager();
        long expected = 21;
        InputLoader loader = new InputLoader();
        Grid grid = loader.convertRawInputToGrid(input);
        GridManager gridManager = new GridManager();
        // Act

        List<Splitter> splitterList = gridManager.findAllSplitter(grid);
        Grid updatedInput = manager.createNewBeams(grid,splitterList);
        Grid extendedBeamInput = manager.extendAllBeams(updatedInput);
        long result = manager.countTouchingBeamsToSplitter(extendedBeamInput);

        // Assert
        result++;
        assertEquals(expected,result);
    }

    @Test
    void partOneIntergrationTest() throws URISyntaxException, IOException {
        // Arrange
        long expected = 21;
        StarCollector starCollector = new StarCollector();

        // Act
        long result = starCollector.partOne("test-input");

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void partOneOfficalTest() throws URISyntaxException, IOException {
        // Arrange
        StarCollector starCollector = new StarCollector();
        long expected = 1703;
        // Act
        long result = starCollector.partOne("puzzle-input");

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void extendBeamDownwardsWithOneSplitter() throws BeamManagerException {
        // Arrange
        List< List<String> > input = List.of(
                Arrays.asList(".S.".split("")),
                Arrays.asList(".|.".split("")),
                Arrays.asList("|^|".split(""))
        );
        BeamManager manager = new BeamManager();
        InputLoader inputLoader = new InputLoader();

        long expected = 2;
        Grid grid = inputLoader.convertRawInputToGrid(input);

        // Act
        long result = manager.findPathsDownInGrid(grid);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void extendBeamDownwardsWithTwoSplitter() throws BeamManagerException {
        // Arrange
        List< List<String> > input = List.of(
                Arrays.asList("..S.".split("")),
                Arrays.asList("..|.".split("")),
                Arrays.asList(".|^|".split("")),
                Arrays.asList(".|.|".split("")),
                Arrays.asList("|^|^|".split("")),
                Arrays.asList("|.|.|".split(""))
        );
        BeamManager manager = new BeamManager();
        InputLoader inputLoader = new InputLoader();

        long expected = 4;
        Grid grid = inputLoader.convertRawInputToGrid(input);

        // Act
        long result = manager.findPathsDownInGrid(grid);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void extendBeamDownwardsWithThreeSplitter() throws BeamManagerException {
        // Arrange
        List< List<String> > input = List.of(
                Arrays.asList("...S...".split("")),
                Arrays.asList("...|...".split("")),
                Arrays.asList("..|^|..".split("")),
                Arrays.asList(".|^|^|.".split("")),
                Arrays.asList(".|.|.|.".split("")),
                Arrays.asList("|^|^|^|".split(""))
        );
        BeamManager manager = new BeamManager();
        InputLoader inputLoader = new InputLoader();

        long expected = 8;
        Grid grid = inputLoader.convertRawInputToGrid(input);

        // Act
        long result = manager.findPathsDownInGrid(grid);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void countPathsDownWithExtendingMiddlePart() throws BeamManagerException {
        // Arrange
        List< List<String> > input = List.of(
                Arrays.asList("...S...".split("")),
                Arrays.asList("...|...".split("")),
                Arrays.asList("..|^|".split("")),
                Arrays.asList(".|^|^|...".split("")),
                Arrays.asList(".|.|.|...".split("")),
                Arrays.asList("|^|||^|..".split(""))
        );

        BeamManager manager = new BeamManager();
        InputLoader inputLoader = new InputLoader();

        long expected = 6;
        Grid grid = inputLoader.convertRawInputToGrid(input);

        // Act
        long result = manager.findPathsDownInGrid(grid);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void countPathsdown() throws BeamManagerException {
        // Arrange
        List< List<String> > input = List.of(
                Arrays.asList("...S...".split("")),
                Arrays.asList("...|..".split("")),
                Arrays.asList("..|^|".split("")),
                Arrays.asList(".|^|^|...".split("")),
                Arrays.asList(".|^|^|...".split(""))
        );

        BeamManager manager = new BeamManager();
        InputLoader inputLoader = new InputLoader();

        long expected = 4;
        Grid grid = inputLoader.convertRawInputToGrid(input);

        // Act
        long result = manager.findPathsDownInGrid(grid);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void partTwoPrepTest() throws URISyntaxException, IOException, BeamManagerException {
        // Arrange
        int expected = 40;
        StarCollector starCollector = new StarCollector();

        // Act
        long result = starCollector.partTwo("test-input");

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void partTwoTest() throws URISyntaxException, IOException, BeamManagerException {
        // Arrange
        long expected = 171692855075500L;
        StarCollector starCollector = new StarCollector();

        // Act
        long result = starCollector.partTwo("puzzle-input");

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testThrowUnexpectedException() throws BeamManagerException {
        // Arrange
        List< List<String> > input = List.of(
                Arrays.asList(".S.".split("")),
                Arrays.asList(".|.".split("")),
                Arrays.asList("|&|".split(""))
        );
        BeamManager manager = new BeamManager();
        InputLoader inputLoader = new InputLoader();

        Grid grid = inputLoader.convertRawInputToGrid(input);

        String expected = "Unexpected symbol: &";

        // Act
        String result = assertThrows(BeamManagerException.class, () -> manager.findPathsDownInGrid(grid)).getMessage();

        // Assert
        assertEquals(expected,result);
    }
}