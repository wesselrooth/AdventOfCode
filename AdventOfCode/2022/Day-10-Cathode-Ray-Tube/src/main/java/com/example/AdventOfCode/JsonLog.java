package com.example.AdventOfCode;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class JsonLog {

    private String logMessage;
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

    public void setCycleCount(long cycleCount){
        this.cycleCount = cycleCount;
    }

    public long getCycleCountCalculationResult(){
        return cycleCountCalculationResult;
    }

    public void setCycleCountCalculationResult(long cycleCountCalculationResult){
        this.cycleCountCalculationResult = cycleCountCalculationResult;
    }

}
