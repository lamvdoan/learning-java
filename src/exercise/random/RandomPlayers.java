package exercise.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 *  Requires at least 10 players.  Given number of players, randomize the players into 2 teams.
 */

public class RandomPlayers {
    public static void main(String[] args) {
        try {
            randomizePlayers(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            randomizePlayers(new String[]{"Lam"});
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            randomizePlayers(new String[]{"Lam", "Allen"});
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println();

        String[] players = {"Lam", "Bi", "Allen", "Duc", "Phung", "Rob", "James", "Will", "Reggie", "Nick", "David"};
        String[][] teams = randomizePlayers(players);

        for (int team = 0; team < 2; team++) {
            System.out.println("Team " + (team + 1));

            for (int player = 0; player < teams[0].length; player++) {
                if (teams[team][player] != null) {
                    System.out.println((player + 1) + ". " + teams[team][player]);
                }
            }

            System.out.println();
        }
    }

    private static String[][] randomizePlayers(String[] players) {
        if (players == null) {
            throw new IllegalArgumentException("There aren't any player");
        } else if (players.length < 10) {
            boolean isOnePlayer = players.length == 1;
            throw new IllegalArgumentException(
                    "Need 10 players, there "
                            + (isOnePlayer ? "is" : "are")
                            + " only "
                            + players.length
                            + " player"
                            + (isOnePlayer ? "" : "s") + ".");
        }

        int teamSize = players.length / 2 + (players.length % 2 == 0 ? 0 : 1);
        String[][] teams = new String[2][teamSize];

        ArrayList<String> playerLists = new ArrayList<>();
        Collections.addAll(playerLists, players);

        Random random = new Random();
        int index = 0;
        int team = 0;

        for (int remainingMax = players.length - 1; remainingMax >= 0; remainingMax--) {
            if (remainingMax == players.length / 2) {
                team = 1;
                index = 0;
            }

            int number = remainingMax != 0 ? random.nextInt(remainingMax) : 0;
            teams[team][index++] = playerLists.remove(number);
        }

        return teams;
    }
}
