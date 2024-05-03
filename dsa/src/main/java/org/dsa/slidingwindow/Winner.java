package org.dsa.slidingwindow;

public class Winner {
    public static void main(String[] args) {
        int[] player1 = new int[]{5,6,1,10};
        int[] player2 = new int[]{5,1,10,5};

        System.out.println("Winner is" +isWinner(player1,player2));
    }

    private static int isWinner(int[] player1, int[] player2) {
        int player1Score = score(player1);
        int player2Score = score(player2);
        System.out.println("PLayer1 sum" + player1Score);
        System.out.println("PLayer2 sum" + player2Score);
        return result(player1Score,player2Score);
    }

    private static int score(int[] player) {
        if (player.length == 1) {
            return player[0];
        }

        int sum = 0;
        if (player[0] == 10) {
            sum = player[0] + 2 * player[1];
        } else {
            sum = player[0] + player[1];
        }

        for (int i = 2; i < player.length; i ++) {
            if (player[i - 1] == 10 || player[i - 2] == 10) {
                sum += 2 * player[i];
            } else {
                sum += player[i];
            }
        }

        return sum;
    }

    private static int result(int player1Sum, int player2Sum) {
        if (player1Sum > player2Sum) {
            return 1;
        } else if (player1Sum < player2Sum) {
            return 2;
        } else {
            return 0;
        }
    }
}
