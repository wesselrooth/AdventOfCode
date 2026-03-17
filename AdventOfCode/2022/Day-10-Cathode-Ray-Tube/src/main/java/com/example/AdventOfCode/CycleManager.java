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
    private HashMap<Long,String> crtStringMap;

    private Sprite sprite;
    private String crtString = "";
    private CircuitManager circuitManager = new CircuitManager();


    public CycleManager(List<Long> checkList)  {

        this.signalStrenghMap = new HashMap<>();

        for (Long number: checkList){
            signalStrenghMap.put(number,null);
        }

    }

    public CycleManager(List<Long> checkList,int spriteRange) throws SpriteException {

        for (Long number: checkList){
            crtStringMap.put(number,"");
        }

        this.sprite = new Sprite(spriteRange);
    }

    public int cyclePartOne(int registerX, long operand, long cycles){

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

    public int cyclePartTwo(int registerX, long operand, long cycles){

        for (int i = 0; i < cycles; i++){

            globalCycleCount++;

            if (circuitManager.spriteTouchesPixelToDraw(crtString,sprite.getSprite())){
                crtString = circuitManager.updateCircuit(true,crtString);
            }else {
                crtString = circuitManager.updateCircuit(false,crtString);
            }

            if (crtStringMap.containsKey(globalCycleCount)){
                crtStringMap.put(globalCycleCount,crtString);
                this.crtString =  "";
            }

            if (i == 1){
                registerX += operand;
                sprite.moveSprite(registerX);
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

    public int performCycle(int regestryx, String cycleString,boolean partOne,boolean partTwo) throws CycleException {

        Cycle cycle = detectCycleType(cycleString);

        if (partOne){
            return cyclePartOne(regestryx,cycle.getOparant(),cycle.getCycleAmount());
        }else if (partTwo){
            return cyclePartTwo(regestryx,cycle.getOparant(),cycle.getCycleAmount());
        }
        return regestryx;
    }

    public long calculateSignalStrengh(List<String> input) throws CycleException {
        LOG.info(new JsonLog("Start calculating signal strength"));

        int registryX = 1;

        for (int i = 0; i < input.size(); i++){
            String cycle = input.get(i);
            registryX = performCycle(registryX,cycle,true,false);
        }

        long result = 0;
        for (Long value: signalStrenghMap.values()){
            result += value;
        }

        return result;
    }

    public long calculateCrtStrings(List<String> input) throws CycleException {
        LOG.info(new JsonLog("Start crt Strings"));

        int registryX = 1;

        for (int i = 0; i < input.size(); i++){
            String cycle = input.get(i);
            registryX = performCycle(registryX,cycle,false,true);
        }

        long result = 0;
        for (Long value: signalStrenghMap.values()){
            result += value;
        }

        return result;
    }
}
