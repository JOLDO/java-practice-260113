package _2_260114;

import java.util.ArrayList;
import java.util.Scanner;

public class _2_Exam_3 {
    public static void main(String[] args) {
        /*
        1)
        사용자로부터 정수 5개를 입력받아 배열에 저장하고 역순 출력
        힌트)
        - 크기가 5개인 정수를 요소로 가지는 배열 생성
        - 스캐너를 이용해서, 입력받은 정수를 , 배열에 담기 , 반복문 활용
                - 배열에서 꺼내서, 출력하기.
        */
//        int[] arrInt = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("데이터 수");
        int[] dataArr = new int[scanner.nextInt()];
        for(int i = 0; i < dataArr.length; i++) {
            System.out.println("정수" + (i + 1));
            dataArr[i] = scanner.nextInt();
        }
        for(int i = dataArr.length - 1; i >= 0; i--) {
            System.out.print("[" + dataArr[i] + "]");
            if(i != 0)  System.out.print(",");
        }
        System.out.println("");
        /*
        2)
        3x3 배열을 만들어 모든 요소에 1~9 채우고 출력
        */
        System.out.println("행갯수");
        int row = scanner.nextInt();

        System.out.println("열갯수");
        int col = scanner.nextInt();  //8교시에 행열 갯수 지정해서 해보

        int[][] grid = new int[row][col];
//        int[][] arrInt3_3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.println("[" + i + "]" + "[" + j + "]");
                grid[i][j] = scanner.nextInt();
            }
        }
        System.out.print("[");
        for(int i = 0; i < grid.length; i++) {
            System.out.print("[");
            for(int j = 0; j < grid[i].length ; j++) {
                if(j != 0) {
                    System.out.print(",");
                }
                System.out.print(grid[i][j]);
            }
            System.out.print("]");
            if(i != grid.length - 1) System.out.print(",");
        }
        System.out.println("]");
        /*
        3)
        문자열 배열을 메서드로 받아 가장 긴 문자열을 반환
        힌트)
        - 배열을 반환하는 메서드를 생성합니다.
        public static String 메서드명(String[] 배열이름)
        - 반복문을 이용해서, 배열 안에 들어 있는 문자열 중에서 가장 긴 문자열 찾아서
        배치. 배열의 길이를 이용하면. 배열. length()
        */
        System.out.println("배열갯수");
        String[] arrStr = new String[scanner.nextInt() + 1];

        for(int i = 0; i < arrStr.length ; i++) {
            arrStr[i] = scanner.nextLine();
        }
        System.out.println(longestStr(arrStr));

        ArrayList<String> arrList = longestStr2(arrStr);
        for(int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i));
            if(i != arrList.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.print("\n");
        System.out.println(longestStr2(arrStr));
        scanner.close();
    }

    public static String longestStr(String[] arr) {
        ArrayList<String> aaa = new ArrayList<>();
//가변배열 배우면 넣어보기
        String longStr = "";
        for(int i = 0; i < arr.length; i++) {
            if(longStr.length() < arr[i].length()) {
                longStr = arr[i];
            }
        }
        return longStr;
    }

    public static ArrayList<String> longestStr2(String[] arr) {
        ArrayList<String> arrList = new ArrayList<>();
//가변배열 배우면 넣어보기
        int leng = 0;
        for(int i = 0; i < arr.length; i++) {
            if(leng < arr[i].length()) {
                arrList.clear();
                arrList.add(arr[i]);
                leng = arr[i].length();
            } else if(leng == arr[i].length()) {
                arrList.add(arr[i]);
            }
        }
        return arrList;
    }
}
