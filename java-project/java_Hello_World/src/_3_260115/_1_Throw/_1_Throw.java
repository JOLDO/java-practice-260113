package _3_260115._1_Throw;

public class _1_Throw {
    public static void main(String[] args) {
//        try {
//            throw new Exception("직접 예외 발생");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        throw new ArrayIndexOutOfBoundsException("aa");
        // IDE 에서, 빨간 밑줄이 생긴 경우, 처리하는 방법
        // 1) 수동으로 처리가 가능하고,
        // 2) IDE 도움을 받아서, 빨간색 밑줄에, 커서를 가져다 놓으면, 수정하는 방법을 안내.
        // 선택이용도 가능.
    }
}
