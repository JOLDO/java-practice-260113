package _2_260114._2_Array.Exam;

import java.util.Scanner;

public class _2_Exam_Case {
    public static void main(String[] args) {
        /*
        1. (1차원 배열 & 누적 연산)
        사용자로부터 정수 5개를 입력받아 배열에 저장하세요.
        그 후 배열에 저장된 모든 숫자의
        **합계(Sum)**와 **평균(Average)**을 계산하여 출력하는 코드를 작성하세요.
        */
        Scanner scanner = new Scanner(System.in);
        int[] arrInt = new int[5];
        int sum = 0;
        for (int i = 0; i < arrInt.length; i++) {
            System.out.println("숫자" + (i + 1));
            arrInt[i] = scanner.nextInt();
            sum += arrInt[i];
        }
        System.out.println("합계: " + sum + ", 평균: " + (double) sum / arrInt.length);

        scanner.close();
        /*
        2. (2차원 배열 & 조건문)
        4x4 크기의 2차원 정수 배열을 만드세요.
        이중 반복문을 사용하여 행의 인덱스와 열의 인덱스가 같을 때(i == j)는
        1을 저장하고, 다를 때는 0을 저장하세요.
        그 후 배열의 형태를 출력하세요. (대각선 줄 긋기)
        힌트) 출력 print()
                - 줄바꿈을 할 때 : System.out.println();
        */
        int[][] grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = 0;
                }
//                System.out.print(grid[i][j]);
            }
//            System.out.println();
        }

//        합한 값이 갯수의 -1(반대 대각선)
//        for(int i = 0; i < 4; i++) {
//            for(int j = 0; j < 4; j++) {
//                if(i + j == 3) {
//                    grid[i][j] = 1;
//                } else {
//                    grid[i][j] = 0;
//                }
//            }
//        }

        for (int[] row : grid) {
            for (int col : row) {
                System.out.print(col);
            }
            System.out.println();
        }

        /*
        3. (메서드 & 최대값 찾기)
        정수형 배열을 매개변수(파라미터)로 받아,
        배열 안에 있는 숫자 중 **가장 큰 수(Max Value)**를 찾아
        반환하는 메서드 getMaxValue를 작성하세요.
        Main 메서드에서 샘플 배열을 만들어 테스트하세요.
        String[] numbers = {100,200,300};
        힌트)
        // 배열의 첫 번째 값을 기준값으로 설정
        int maxVal = arr[0];
        if (num > maxVal) { // 현재 꺼낸 숫자가 기준값보다 크다면
            maxVal = num; // 기준값을 현재 숫자로 변경
        }
        */
        int[] numbers = {100, 200, 300};
        System.out.println(getMaxValue(numbers));
    }

    private static int getMaxValue(int[] numbers) {
        int maxValue = 0;
        for (int row : numbers) {
            if (row > maxValue) {
                maxValue = row;
            }
        }
        return maxValue;
    }
}
