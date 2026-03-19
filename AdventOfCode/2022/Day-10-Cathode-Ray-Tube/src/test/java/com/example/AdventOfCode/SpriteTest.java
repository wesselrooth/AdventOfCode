package com.example.AdventOfCode;
import com.example.AdventOfCode.exceptions.SpriteException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class SpriteTest {

    @Test
    void constructSprite_SpriteRangeToSmallTo() throws SpriteException {
        // Arrange
        int spriteListRange = 2;
        String expected = "List is to small to fit a Sprite";
        // Act
        String result = assertThrows(SpriteException.class, () -> new Sprite(spriteListRange)).getMessage();

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
        "5,5,..###",
        "5,6,..###",
        "5,-1,###..",
    })
    void constructSpriteOnFirstIndex(int range,int registerX,String expected) throws  SpriteException{
        // Arrange
        Sprite sprite = new Sprite(range);

        // Act
        String result = sprite.moveSprite(registerX);

        // Assert
        assertEquals(expected,result);
    }

}