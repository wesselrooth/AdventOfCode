package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquationManagerTest {

    @Test
    void constructorTest(){
         // Arrange
        EquationManager equationManager = new EquationManager();

        // Act + Assert
        assertNotNull(equationManager);

    }

}