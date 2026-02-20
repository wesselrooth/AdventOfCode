package com.example.AdventOfCode;

public class JsonLog {

    private final String logMessage;
    private long cycleCount;
    private long cycleCountCalculationResult;

    public JsonLog(String message){
        this.logMessage = message;
    }

    public JsonLog(String message,long cycleCount){
        this.logMessage = message;
    }

    public JsonLog(String message, long cycleCount, long cycleCountCalculationResult){
        this.logMessage = message;
        this.cycleCount = cycleCount;
        this.cycleCountCalculationResult = cycleCountCalculationResult;
    }

    public String getLogMessage(){
        return logMessage;
    }

    public long getCycleCount(){
        return cycleCount;
    }

    public long getCycleCountCalculationResult(){
        return cycleCountCalculationResult;
    }

}
