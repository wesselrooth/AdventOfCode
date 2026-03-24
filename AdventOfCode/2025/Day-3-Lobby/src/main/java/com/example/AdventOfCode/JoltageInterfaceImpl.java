package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.InputException;
import interfaces.JoltageInterface;

import java.util.List;

public class JoltageInterfaceImpl implements JoltageInterface {

    StringHelper helper = new StringHelper();

    @Override
    public long getJoltage(String input) throws InputException {

        if (input == null || input.isEmpty()){
            throw new InputException("Input is null or size is null");
        }

        List<Integer> numberList = helper.convertToListOfInteger(input);

        return helper.get2HighestNumbers(numberList);
    }


}
