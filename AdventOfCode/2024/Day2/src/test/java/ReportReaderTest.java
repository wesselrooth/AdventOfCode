import org.example.ParceException;
import org.example.ReportReader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReportReaderTest {

    @Test
    void constructorTest(){
        //    Arrange + Act
        ReportReader recordReader = new ReportReader();
        //    Assert
        assertNotNull(recordReader);
    }




    @Test
    void reportReaderTest() throws ParceException {
        //    Arrange
        ReportReader recordReader = new ReportReader();
        boolean expected = true;
        //    Act
        boolean result = recordReader.reportCheck("7 6 4 2 1");
        //    Assert
        assertEquals(expected,result);
    }

    @Test
    void integegrationTest() throws ParceException {

        //    Arrange
        int expected = 4;

        List<String> inputList = new ArrayList<>();
        inputList.add("7 6 4 2 1");
        inputList.add("1 2 7 8 9");
        inputList.add("9 7 6 2 1");
        inputList.add("1 3 2 4 5");
        inputList.add("8 6 4 4 1");
        inputList.add("1 3 6 7 9");

        //    Act
        int result = 0;
        for (String input: inputList){

            if (!ReportReader.reportCheck(input)){
                continue;
            }
            result++;
        }

        //    Assert
        assertEquals(expected,result);

    }
    @Test
    void safeTest() throws ParceException {

        //    Arrange
        boolean expected = true;

        //    Act

        boolean result = ReportReader.reportCheck("40 42 43 46 47 48 49 49");
        //    Assert
        assertEquals(expected,result);

    }
}
