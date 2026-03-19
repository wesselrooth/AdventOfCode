package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.CycleException;
import com.example.AdventOfCode.exceptions.SpriteException;
import com.example.AdventOfCode.logs.JsonLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleManager {

    private static final Logger LOG = LogManager.getLogger("CONSOLE_JSON_APPENDER");

    private long globalCycleCount = 0;
    private final HashMap<Long,Long> signalStrengthMap;
    private final HashMap<Long,String> circuitStringMap;

    private final Sprite sprite;
    private String crtString = "";
    private final CircuitManager circuitManager = new CircuitManager();

    public CycleManager(List<Long> checkList,int spriteRange) throws SpriteException {
        circuitStringMap = new HashMap<>();
        signalStrengthMap = new HashMap<>();

        for (Long number: checkList){
            circuitStringMap.put(number,"");
            signalStrengthMap.put(number,null);
        }

        this.sprite = new Sprite(spriteRange);
    }

    public int cycle(int registerX, int operand, long cycles){

        for (int i = 0; i < cycles; i++){
            globalCycleCount++;

            boolean touchesSprite = circuitManager.spriteTouchesPixelToDraw(crtString,sprite.getSprite());
            crtString = circuitManager.updateCircuit(touchesSprite,crtString);

            if (circuitStringMap.containsKey(globalCycleCount)){
                circuitStringMap.put(globalCycleCount,crtString);
                this.crtString =  "";
            }

            if (signalStrengthMap.containsKey(globalCycleCount)){
                long cycleCountCalculationResult = globalCycleCount * registerX;
                signalStrengthMap.put(globalCycleCount, cycleCountCalculationResult);

                LOG.info(
                    new JsonLog("Update cycle count",globalCycleCount,cycleCountCalculationResult)
                );
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
                new JsonLog("Detecting Cycle String is empty")
            );
            throw new CycleException("Empty cycle String");
        }

        input = input.strip();
        if (input.equals("noop")){
            return new Cycle(1,0);
        }

        String[] splitInput = input.split(" ");
        if (splitInput.length > 2){
            LOG.error(new JsonLog("Splitted array is to big than expected"));
            throw new CycleException("Unexpected amound of Cycles detected");
        }

        String firstPart = splitInput[0];
        if (!firstPart.equals("addx")){
            LOG.error(new JsonLog("Something went wrong detecting the cycle string"));
            throw new CycleException("Unknown cycle type detected");
        }
        int operant = Integer.parseInt(splitInput[1]);

        return new Cycle(2,operant);
    }

    public int performCycle(int registryX, String cycleString) throws CycleException {

        Cycle cycle = detectCycleType(cycleString);
        return cycle(registryX,cycle.getOperant(),cycle.getCycleAmount());
    }

    public int calculateSignalStrength(List<String> input) throws CycleException {
        LOG.info(new JsonLog("Start calculating signal strength"));

        int registryX = 1;
        for (int i = 0; i < input.size(); i++){
            String cycle = input.get(i);
            registryX = performCycle(registryX,cycle);
        }

        int result = 0;
        for (Long value: signalStrengthMap.values()){
            result += value;
        }
        return result;
    }

    public Map<Long,String> getCircuitStringMap(){
        return circuitStringMap;
    }
}
