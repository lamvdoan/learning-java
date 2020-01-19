package exercise.adventofcode.year2019;

import exercise.adventofcode.util.CSVFileReader;

public class Day2 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int[] opcode = CSVFileReader.getList("/src/exercise/adventofcode/year2019/day2.csv");
                if (opcode == null) return;

                opcode[1] = i;
                opcode[2] = j;
                int instructionPointer = 0;

                while (opcode[instructionPointer] != 99) {
                    if (opcode[instructionPointer] == 1) {
                        opcode[opcode[instructionPointer + 3]] = opcode[opcode[instructionPointer + 1]] + opcode[opcode[instructionPointer + 2]];
                    } else if (opcode[instructionPointer] == 2) {
                        opcode[opcode[instructionPointer + 3]] = opcode[opcode[instructionPointer + 1]] * opcode[opcode[instructionPointer + 2]];
                    } else {
                        System.out.println("Wrong opcode: " + opcode[instructionPointer]);
                        break;
                    }

                    instructionPointer += 4;
                }

                if (opcode[0] == 19690720) {
                    System.out.println("i: " + i);
                    System.out.println("j: " + j);
                    System.out.println("answer: " + (100 * i + j));
                }
            }
        }
    }
}
