package com.martak.adventofcode.wirepathanalyzer.model;

import java.util.ArrayList;
import java.util.List;

import static com.martak.adventofcode.wirepathanalyzer.model.Constants.*;

public class CommandParser {

    public static List<Command> getPath(String[] commands) {
        List<Command> path = new ArrayList<>();
        Point start = new Point(0, 0);
        for (String command : commands) {
            int x = start.getX();
            int y = start.getY();
            String direction = command.substring(0, 1);
            int steps = Integer.valueOf(command.substring(1));
            switch (direction) {
                case UP:
                    y += steps;
                    break;
                case RIGHT:
                    x += steps;
                    break;
                case DOWN:
                    y -= steps;
                    break;
                case LEFT:
                    x -= steps;
                    break;
            }
            Point end = new Point(x, y);
            path.add(new Command(direction, steps, start, end));
            start = end;
        }
        return path;
    }
}
