package com.example.AdventOfCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class SpriteManagerTest {

    @Test
    void constructSprite_SpriteRangeToSmallTo() throws  SpriteException{
        // Arrange
        int spriteListRange = 2;
        String expected = "List is to small to fit a Sprite";
        // Act
        String result = assertThrows(SpriteException.class, () -> new SpriteManager(spriteListRange,0)).getMessage();

        // Assert
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
        "3,0,###",
        "3,1,###",
        "3,2,###",
        "4,0,###.",
        "4,1,###.",
        "4,2,.###",
        "4,3,.###",
        "5,2,.###.",
        "5,3,..###",
        "5,4,..###",
    })
    void constructSpriteOnFirstIndex(int range,int registerX,String expected) throws  SpriteException{
        // Act
        SpriteManager spriteManager = new SpriteManager(range,registerX);

        // Assert
        String result = String.join("", spriteManager.getSprite());
        assertEquals(expected,result);
    }

    @Test
    void constructSprite_SecondIndexWhileSizeIsLangerThenMinimal() throws  SpriteException{
        // Arrange
        int spriteListRange = 4;
        String expected = "###.";
        int registerX = 1;
        // Act
        SpriteManager spriteManager = new SpriteManager(spriteListRange,registerX);
        String result = String.join("", spriteManager.getSprite());

        // Assert
        assertEquals(expected,result);
    }


}