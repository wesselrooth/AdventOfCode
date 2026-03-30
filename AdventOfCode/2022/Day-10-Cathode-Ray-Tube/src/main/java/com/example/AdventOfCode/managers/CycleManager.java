package com.example.AdventOfCode.managers;

import com.example.AdventOfCode.Cycle;
import com.example.AdventOfCode.Sprite;
import com.example.AdventOfCode.exceptions.CycleException;
import com.example.AdventOfCode.exceptions.SpriteException;
import com.example.AdventOfCode.logs.JsonLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CycleManager {

    private static final Logger LOG = LogManager.getLogger("CONSOLE_JSON_APPENDER");

    private long globalCycleCount = 0;
    private final HashMap<Long, Long> signalStrengthMap;
    private List<String> circuitStringResultList = new ArrayList<>();
    private final List<Long> checkList;
    private final Sprite sprite;

    public CycleManager(List<Long> checkList, int spriteRange) throws SpriteException {
        this.checkList = checkList;
        signalStrengthMap = new HashMap<>();

        for (Long number : checkList) {
            signalStrengthMap.put(number, null);
        }

        this.sprite = new Sprite(spriteRange);
    }

    public Cycle performCycle(Cycle cycle){

        for (int i = 0; i < cycle.getCycleAmount(); i++) {
            globalCycleCount++;

            CircuitManager circuitManager = new CircuitManager();
            boolean touchesSprite = circuitManager.spriteTouchesPixelToDraw(cycle.getCircuitString(), sprite.getSprite());

            if (touchesSprite){
                cycle.addCharacterToCircuit("#");
            }else {
                cycle.addCharacterToCircuit(".");
            }

            if (checkList.contains(globalCycleCount)) {
                System.out.println(cycle.getCircuitString());
                circuitStringResultList.add(cycle.getCircuitString());
                cycle.resetCircuitString();
            }

            if (signalStrengthMap.containsKey(globalCycleCount)) {
                long cycleCountCalculationResult = globalCycleCount * cycle.getRegisterX();
                signalStrengthMap.put(globalCycleCount, cycleCountCalculationResult);

                LOG.info(
                        new JsonLog("Update cycle count", globalCycleCount, cycleCountCalculationResult)
                );
            }

            if (i == 1) {
                cycle.incrementRegisterX();
                sprite.moveSprite(cycle.getRegisterX());
            }
        }

        return cycle;
    }

    public int calculateSignalStrength(List<String> input) throws CycleException {

        int registryX = 1;
        String circuitString = "";
        Cycle cycle;

        for (int i = 0; i < input.size(); i++) {
            String cycleString = input.get(i);
            cycle  = new Cycle(cycleString,registryX, circuitString);

            cycle = performCycle(cycle);

            circuitString = cycle.getCircuitString();
            registryX = cycle.getRegisterX();
        }

        int result = 0;
        for (Long value : signalStrengthMap.values()) {
            result += value;
        }
        return result;
    }

    public List<String> getCheckList() {
        return circuitStringResultList;
    }
}
