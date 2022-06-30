import java.util.Scanner;
//В этой игре вам необходимо собрать все сокровища на игровом поле
public class TreasureHunter {
    public static void main(String[] args) {
        int treasureAmount = 5;
        char[][] gameField = new char[7][7];
        int startPosX = gameField.length / 2;
        int startPosY = gameField[0].length / 2;
        gameField[startPosX][startPosY] = 'X'; //Стартовая позиция игрока
        for (int i = 0; i < treasureAmount; i++) {
            int treasureWidth = (int) (Math.random() * gameField.length);
            int treasureLength = (int) (Math.random() * gameField[0].length);
            if (gameField[treasureLength][treasureWidth] != 'X') {
                gameField[treasureLength][treasureWidth] = 'T';
            } else {
                i--;
            }
        }
        showCharArray(gameField);
        System.out.println("Use WASD to move");
        Scanner key = new Scanner(System.in);
        while (treasureAmount != 0) {
            switch (key.nextLine().toLowerCase()) {
                case "w" -> {
                    if ((startPosX - 1) < 0) {
                        break;
                    }
                    gameField[startPosX][startPosY] = '\0';
                    startPosX--;
                    if(treasureChecker(gameField, startPosX, startPosY)){
                        treasureAmount--;
                    }
                    gameField[startPosX][startPosY] = 'X';
                    showCharArray(gameField);
                }
                case "a" -> {
                    if ((startPosY - 1) < 0) {
                        break;
                    }
                    gameField[startPosX][startPosY] = '\0';
                    startPosY--;
                    if(treasureChecker(gameField, startPosX, startPosY)){
                        treasureAmount--;
                    }
                    gameField[startPosX][startPosY] = 'X';
                    showCharArray(gameField);
                }
                case "s" -> {
                    if ((startPosX + 1) >= gameField.length) {
                        break;
                    }
                    gameField[startPosX][startPosY] = '\0';
                    startPosX++;
                    if(treasureChecker(gameField, startPosX, startPosY)){
                        treasureAmount--;
                    }
                    gameField[startPosX][startPosY] = 'X';
                    showCharArray(gameField);
                }
                case "d" -> {
                    if ((startPosY + 1) >= gameField[0].length) {
                        break;
                    }
                    gameField[startPosX][startPosY] = '\0';
                    startPosY++;
                    if(treasureChecker(gameField, startPosX, startPosY)){
                        treasureAmount--;
                    }
                    gameField[startPosX][startPosY] = 'X';
                    showCharArray(gameField);
                }
            }
        }
        key.close();
        System.out.println("Game Over!");
    }

    public static void showCharArray(char[][] arr) {
        for (char[] chars : arr) {
            for (int k = 0; k < arr[0].length; k++) {
                System.out.print(chars[k] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean treasureChecker(char[][] arr, int x, int y) {
        return arr[x][y] == 'T';
    }
}
