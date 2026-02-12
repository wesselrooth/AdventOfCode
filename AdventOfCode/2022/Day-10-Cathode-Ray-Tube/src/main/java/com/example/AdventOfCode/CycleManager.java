package com.example.AdventOfCode;

import java.util.HashMap;
import java.util.List;

public class CycleManager {

    private long globalCycleCount = 0;

    private HashMap<Long,Long> signalStrenghMap;

    public CycleManager(List<Long> checkList){

        this.signalStrenghMap = new HashMap<>();

        for (Long number: checkList){
            signalStrenghMap.put(number,null);
        }

    }

    public long cycle(long registerX, long oparend, long cycles){

        for (int i = 0; i < cycles; i++){

            globalCycleCount++;



            if (signalStrenghMap.containsKey(globalCycleCount)){
                long tmpResult = globalCycleCount * registerX;
                signalStrenghMap.put(globalCycleCount, tmpResult);
            }
            if (i == 1){
                registerX += oparend;
            }
        }
        return registerX;
    }

    public Cycle detectCycleType(String input) throws CycleException {

        if (input.isEmpty()){
            throw new CycleException("Empty cycle String");
        }

        input = input.strip();

        if (input.equals("noop")){
            return new Cycle("noop",1,0);
        }

        String[] splittedInput = input.split(" ");

        if (splittedInput.length > 2){
            throw new CycleException("Unexpected amound of Cycles detected");
        }

        String firstPart = splittedInput[0];

        if (!firstPart.equals("addx")){
            throw new CycleException("Unknown cycle type detected");
        }
        long oprant = Long.parseLong(splittedInput[1]);

        return new Cycle("addx",2,oprant);
    }

    public long performCycle(long regestryx, String cycleString) throws CycleException {

        Cycle cycle = detectCycleType(cycleString);
        regestryx = cycle(regestryx,cycle.getOparant(),cycle.getCycleAmount());

        return regestryx;
    }

    public long calculateSignalStrengh(List<String> input) throws CycleException {

        long registryX = 1;

        for (int i = 0; i < input.size(); i++){

            String cycle = input.get(i);

            registryX = performCycle(registryX,cycle);
        }

        long result = 0;

        for (Long value: signalStrenghMap.values()){
            result += value;
        }

        return result;
    }

}
