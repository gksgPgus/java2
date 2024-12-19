package 한혜현;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 희망도서신청 {
    private static List<String> 책이름 = new ArrayList<>();
    private static Map<String, List<String>> 신청이름제목 = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("희망 도서 신청 프로그램");
            System.out.println("1. 희망 도서 신청");
            System.out.println("2. 신청 내역 조회");
            System.out.println("3. 파일에 데이터 저장");
            System.out.print("선택: ");
            int a = sc.nextInt();

            switch (a) {
                case 1:
                    도서신청(sc);
                    break;
                case 2:
                    신청내역조회();
                    break;
                case 3:
                    파일에저장();
                    break;
            }
        }
    }

    private static void 도서신청(Scanner sc) {
        System.out.print("학생 이름: ");
        String user = sc.nextLine();
        System.out.print("신청할 도서 이름: ");
        String book = sc.nextLine();

        책이름.add(book);

        System.out.println("도서 신청이 완료되었습니다.");
    }

    private static void 신청내역조회() {
        System.out.println("신청 내역");
    }
    
    private static void 파일에저장() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("book.txt"))) {
            
        } catch (IOException e) {
        	
        }
    }
}