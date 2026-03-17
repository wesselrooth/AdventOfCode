package com.example.AdventOfCode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CycleManager {

    private static final Logger LOG = LogManager.getLogger("CONSOLE_JSON_APPENDER");

    private long globalCycleCount = 0;
    private HashMap<Long,Long> signalStrenghMap;

    private List<String> circuitRow  = new ArrayList<>();

    public CycleManager(List<Long> checkList){

        this.signalStrenghMap = new HashMap<>();

        for (Long number: checkList){
            signalStrenghMap.put(number,null);
        }

    }

    public long cyclePartOne(long registerX, long operand, long cycles){

        for (int i = 0; i < cycles; i++){
            globalCycleCount++;
            if (signalStrenghMap.containsKey(globalCycleCount)){
                long cycleCountCalculationResult = globalCycleCount * registerX;
                signalStrenghMap.put(globalCycleCount, cycleCountCalculationResult);

                LOG.info(
                    new JsonLog("Update cycle count",globalCycleCount,cycleCountCalculationResult)
                );
            }

            if (i == 1){
                registerX += operand;
            }

        }
        return registerX;
    }

    public long cyclePartTwo(long registerX, long operand, long cycles){

        for (int i = 0; i < cycles; i++){

            // check of sprite op de matched met de getekende String

            globalCycleCount++;
            if (signalStrenghMap.containsKey(globalCycleCount)){

            }

            if (i == 1){
                registerX += operand;
            }

        }
        return registerX;
    }


    public Cycle detectCycleType(String input) throws CycleException {
        LOG.info(new JsonLog("Start Detect cycle"));

        if (input.isEmpty()){
            LOG.error(
                    new JsonLog("Something went wrong detecting the cycle string")
            );
            throw new CycleException("Empty cycle String");
        }

        input = input.strip();

        if (input.equals("noop")){

            return new Cycle("noop",1,0);
        }

        String[] splittedInput = input.split(" ");

        if (splittedInput.length > 2){
            LOG.error(new JsonLog("Something went wrong detecting the cycle string"));

            throw new CycleException("Unexpected amound of Cycles detected");
        }

        String firstPart = splittedInput[0];

        if (!firstPart.equals("addx")){
            LOG.error(new JsonLog("Something went wrong detecting the cycle string"));
            throw new CycleException("Unknown cycle type detected");
        }
        long oprant = Long.parseLong(splittedInput[1]);

        return new Cycle("addx",2,oprant);
    }

    public long performCycle(long regestryx, String cycleString) throws CycleException {

        Cycle cycle = detectCycleType(cycleString);
        regestryx = cyclePartOne(regestryx,cycle.getOparant(),cycle.getCycleAmount());

        return regestryx;
    }

    public long calculateSignalStrengh(List<String> input) throws CycleException {
        LOG.info(new JsonLog("Start calculating signal strength"));

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
