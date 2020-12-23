public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        char[][] diagonalCross = new char[size][size];
        for (int i = 0; i < diagonalCross.length; i++) {
            for (int j = 0; j < diagonalCross.length; j++) {
                if (i == j || diagonalCross.length - i - 1 == j) {
                    diagonalCross[i][j] = symbol;
                } else {
                    diagonalCross[i][j] = ' ';
                }
            }
        }
        return diagonalCross;
    }
}