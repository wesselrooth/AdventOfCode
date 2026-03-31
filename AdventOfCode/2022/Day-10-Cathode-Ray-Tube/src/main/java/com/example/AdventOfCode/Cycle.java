package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.CycleException;
import com.example.AdventOfCode.logs.JsonLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cycle {

    private static final Logger LOG = LogManager.getLogger("CONSOLE_JSON_APPENDER");

    private int cycleAmount;
    private int operant;
    private int registerX;
    private String circuitString;
    private int totalCycleCount;
    public Cycle(String input,int registerX,String circuitString) throws CycleException {
        this.registerX = registerX;
        this.circuitString = circuitString;

        if (input.isEmpty()) {
            LOG.error(
                    new JsonLog("Detecting Cycle String is empty")
            );
            throw new CycleException("Empty cycle String");
        }


        String[] splitInput = input.split(" ");
        if (splitInput.length > 2) {
            LOG.error(new JsonLog("Split array is to big than expected"));
            throw new CycleException("Unexpected amount of Cycles detected");
        }

        String firstPart = splitInput[0].strip();

        switch (firstPart) {
            case "addx" -> {
                this.operant = Integer.parseInt(splitInput[1]);
                this.cycleAmount = 2;
            }
            case "noop" -> this.cycleAmount = 1;
            default -> throw new CycleException("Unknown cycle type detected");
        }
    }
    public long getCycleAmount(){
        return cycleAmount;
    }

    public int getOperant(){
        return operant;
    }

    public String getCircuitString(){
        return circuitString;
    }

    public int getRegisterX(){
        return registerX;
    }

    public void addCharacterToCircuit(String toaddchar){
        this.circuitString += toaddchar;
    }

    public void resetCircuitString(){
        this.circuitString = "";
    }

    public int incrementRegisterX(){
        return this.registerX += getOperant();
    }

    public void setTotalCycleCount(int totalCycleCount){
        this.totalCycleCount = totalCycleCount;
    }

    public int getTotalCycleCount(){
        return totalCycleCount;
    }

    public void incrementCycleCount(){
        this.totalCycleCount++;
    }

}
