package com.martak.adventofcode.securecontainer;

public class PasswordValidation {

    public static void main(String[] args) {
        Range range = new Range(307237, 769058);
        PasswordValidation passwordValidation = new PasswordValidation(range);
        int counter = 0;
        for (int i = range.getMin(); i <= range.getMax(); i++) {
            if (passwordValidation.check(i)) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    private final Range range;

    public PasswordValidation(Range range) {
        this.range = range;
    }

    public boolean check(int password) {
//        if (!isWithinTheRange(password)) {
//            return false;
//        }
        if (!containsTwoTheSameAdjacentDigits(password)) {
            return false;
        }
        return containsNoDecreasingPair(password);
    }

    private boolean isWithinTheRange(int password) {
        return password >= range.getMin() && password <= range.getMax();
    }

    private boolean containsTwoTheSameAdjacentDigits(int password) {
        char[] chars = String.valueOf(password).toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private boolean containsNoDecreasingPair(int password) {
        char[] chars = String.valueOf(password).toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
