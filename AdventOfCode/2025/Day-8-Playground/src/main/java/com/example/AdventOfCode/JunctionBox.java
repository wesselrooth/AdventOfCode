package com.example.AdventOfCode;

public class JunctionBox {

    private final long x;
    private final long y;
    private final long z;
    private Circuit circuit = new Circuit();

    public JunctionBox(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

}
