package _2_260114._2_Array;

public class _2_Array {
    public static void main(String[] args) {
        int[] scores = new int[5];
        int[] numbers = {1, 2, 3, 4, 5};

        int[][] table = new int[3][2];
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[] nums = {10, 20, 30};
        for (int n : nums) {    //향상된 for 문
            System.out.println(n);
        }

        int[][] grid = {{1,2}, {3,4}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

//        향상된 for문
//        for (int[] ints : grid) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }

        int[] result = getData();
        int[] result2 = getData();
        int[] result3 = getData();
//        3개의 값은 같지만 각각 저장된 메모리 주소가 다르다.
        String[] result4 = makeArray();
        System.out.println(result[1]); // 10
        System.out.println(result4[1]);
    }

    public static int[] getData() {
        return new int[]{5, 10, 15};
    }

    public static String[] makeArray() {
        String[] arr = {"aa", "bb", "cc"};
        return arr;
    }
}
