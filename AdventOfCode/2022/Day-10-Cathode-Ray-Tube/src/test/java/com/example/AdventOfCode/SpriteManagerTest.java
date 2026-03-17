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
        String result = assertThrows(SpriteException.class, () -> new SpriteManager(spriteListRange)).getMessage();

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
        "5,6,..###",
        "5,-1,###..",
    })
    void constructSpriteOnFirstIndex(int range,int registerX,String expected) throws  SpriteException{
        // Arrange
        SpriteManager spriteManager = new SpriteManager(range);

        // Act
        String result = spriteManager.moveSprite(registerX);

        // Assert
        assertEquals(expected,result);
    }

}