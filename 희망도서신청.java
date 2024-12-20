package 한혜현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * 희망도서신청하는 프로그램
 * 2024-12-17: 최초생성
 */
public class 희망도서신청 {
    private static List<String> 책이름 = new ArrayList<>();
    private static Map<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("희망 도서 신청 프로그램");
            System.out.println("1. 희망 도서 신청");
            System.out.println("2. 신청 내역 조회");
            System.out.println("3. 파일에 데이터 저장");
            System.out.println("4. 파일 불러오기");
            System.out.print("선택: ");
            int a = sc.nextInt();
            sc.nextLine();

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
                case 4:
                    파일에서불러오기();
                    break;
            }
        }
    }

    /**
     * 학생 이름과 도서이름을 입력받고 List와Map에 저장하기
     */
    private static void 도서신청(Scanner sc) {
        System.out.print("학생 이름: ");
        String user = sc.nextLine();
        System.out.print("신청할 도서 이름: ");
        String book = sc.nextLine();

        책이름.add(book);
        map.putIfAbsent(user, new ArrayList<>());
        map.get(user).add(book);

        System.out.println("도서 신청이 완료되었습니다.");
    }

    private static void 신청내역조회() {
        System.out.println("신청 내역");
        for (String user : map.keySet()) {
            System.out.println(user + ": " + map.get(user));
        }
    }
    /**
     * 파일에 데이터를 저장하기
     */
    private static void 파일에저장() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("book.txt"))) {
            for (String user : map.keySet()) {
                writer.write(user + ": " + String.join(", ", map.get(user)));
                writer.newLine();
            }
            System.out.println("신청 내역이 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 오류: " + e.getMessage());
        }
    }

    /**
     * 파일에 저장된 내역을 불러와서 출력
     */
    private static void 파일에서불러오기() {
            System.out.println("신청 내역을 불러옵니다.");
        try (BufferedReader reader = new BufferedReader(new FileReader("book.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String user = parts[0].trim();
                String[] books = parts[1].split(",");
                map.putIfAbsent(user, new ArrayList<>());
                for (String book : books) {
                    book = book.trim();
                    책이름.add(book);
                    map.get(user).add(book);
                }
            }
            for (String user1 : map.keySet()) {
                System.out.println(user1 + ": " + map.get(user1));
            }
        } catch (FileNotFoundException e) {
            System.out.println("신청 내역이 없습니다.");
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }

}