package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgMode;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgModeFactory;

public class OpCode6 implements OpCode {

    @Override
    public Context execute(Context context) {
        int[] code = context.getCode();
        int pointer = context.getPointer();
        ArgMode argMode1 = ArgModeFactory.getArgMode((code[pointer] / 100) % 10);
        ArgMode argMode2 = ArgModeFactory.getArgMode((code[pointer] / 1000));
        int first = argMode1.getValue(code, pointer + 1);
        int second = argMode2.getValue(code, pointer + 2);
        if (first == 0) {
            pointer = second;
        } else {
            pointer += 3;
        }
        return new Context(pointer, code, context.getInputs(), context.getOutput(), context.getRelativeBase());
    }
}
