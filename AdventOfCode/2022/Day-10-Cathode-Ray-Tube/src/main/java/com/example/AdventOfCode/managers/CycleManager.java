package com.example.AdventOfCode.managers;

import com.example.AdventOfCode.Cycle;
import com.example.AdventOfCode.Sprite;
import com.example.AdventOfCode.exceptions.CycleException;
import com.example.AdventOfCode.exceptions.SpriteException;
import com.example.AdventOfCode.logs.JsonLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CycleManager {

    private static final Logger LOG = LogManager.getLogger("CONSOLE_JSON_APPENDER");

    private final List<Long> signalStrengthList;
    private final List<String> circuitStringList = new ArrayList<>();
    private final List<Long> checkList;
    private final Sprite sprite;

    public CycleManager(List<Long> checkList, int spriteRange) throws SpriteException {
        this.checkList = checkList;
        signalStrengthList = new ArrayList<>();
        this.sprite = new Sprite(spriteRange);
    }

    public Cycle performCycle(Cycle cycle,long totalCycleCount){

        for (int i = 0; i < cycle.getCycleAmount(); i++) {
            totalCycleCount++;

            CircuitManager circuitManager = new CircuitManager();
            boolean touchesSprite = circuitManager.spriteTouchesCircuitString(cycle.getCircuitString(), sprite.getSprite());

            if (touchesSprite){
                cycle.addCharacterToCircuit("#");
            }else {
                cycle.addCharacterToCircuit(".");
            }

            if (checkList.contains(totalCycleCount)) {

                System.out.println(cycle.getCircuitString());
                circuitStringList.add(cycle.getCircuitString());
                cycle.resetCircuitString();

                long cycleCountCalculationResult = totalCycleCount * cycle.getRegisterX();

                signalStrengthList.add(cycleCountCalculationResult);

                LOG.info(
                        new JsonLog("Update cycle count", totalCycleCount, cycleCountCalculationResult)
                );
            }

            if (i == 1) {
                cycle.incrementRegisterX();
                sprite.moveSprite(cycle.getRegisterX());
            }
        }

        cycle.setTotalCycleCount(totalCycleCount);

        return cycle;
    }

    public int calculateSignalStrength(List<String> input) throws CycleException {

        int registryX = 1;
        String circuitString = "";
        Cycle cycle;
        long totalCycleAmount = 0;

        for (int i = 0; i < input.size(); i++) {
            String cycleString = input.get(i);
            cycle  = new Cycle(cycleString,registryX, circuitString);
            cycle = performCycle(cycle,totalCycleAmount);

            totalCycleAmount = cycle.getTotalCycleCount();

            circuitString = cycle.getCircuitString();
            registryX = cycle.getRegisterX();
        }

        int result = 0;
        for (Long value : signalStrengthList) {
            result += value;
        }
        return result;
    }

    public List<String> getCheckList() {
        return circuitStringList;
    }
}
