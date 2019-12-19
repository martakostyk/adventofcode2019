package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgMode;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgModeFactory;

import java.math.BigInteger;

public class OpCode9 implements OpCode {

    @Override
    public Context execute(Context context) {
        BigInteger[] code = context.getCode();
        int pointer = context.getPointer();
        ArgMode argMode = ArgModeFactory.getArgMode((code[pointer].intValue() / 100) % 10);
        int relativeBase = context.getRelativeBase() + argMode.getValue(context, pointer + 1).intValue();
        return new Context(pointer + 2, code, context.getInputs(), context.getOutput(), relativeBase);
    }
}
