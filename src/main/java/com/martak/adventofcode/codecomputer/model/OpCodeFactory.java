package com.martak.adventofcode.codecomputer.model;

public class OpCodeFactory {

    private static final int SHIFT_2 = 2;
    private static final int SHIFT_4 = 4;

    public static OpCode getOpCode(int[] inputIntCode, int index) {
        int opCodeValues = inputIntCode[index];
        int opCode = opCodeValues % 100;
        int firstArgMode = (opCodeValues / 100) % 10;
        int secondArgMode = opCodeValues / 1000;
        switch (opCode) {
            case 1:
                return new OpCode1(SHIFT_4, firstArgMode, secondArgMode);
            case 2:
                return new OpCode2(SHIFT_4, firstArgMode, secondArgMode);
            case 3:
                return new OpCode3(SHIFT_2);
            case 4:
                return new OpCode4(SHIFT_2);
            case 99:
                return new OpCode99(inputIntCode.length - index);
            default:
                throw new IllegalArgumentException("unknown opcode: " + inputIntCode[index]);
        }
    }
}
