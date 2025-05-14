package main;

import java.util.Random;
import java.util.Scanner;

public class Search_in_English {
   static Scanner in = new Scanner(System.in);
   static String InputWord;
   static String[] EnglishWord = new String[5];
   static String[] EnglishK = new String[5];
   static Random r = new Random();

   public static void main(String[] args) {

      InputWord();
      OutputWord();
      System.out.println("-------------------");
      for (int i = 0; i < 2; i++) {
         System.out.println("메뉴를 숫자로 선택하시오");
         System.out.println("1.검색");
         System.out.println("2.삭제");
         System.out.println("3.수정");
         System.out.println("4.저장된 단어들 조회");
         System.out.println("5.종료");
         String menunum = in.nextLine();
         if (menunum.equals("1")) {
            Search();
         } else if (menunum.equals("2")) {
            Delete();
         } else if (menunum.equals("3")) {
            Update();
         } else if (menunum.equals("4")) {
            OutputWord();
         } else if (menunum.equals("5")) {
            System.out.println("종료");
            break;
         }
         i--;
         System.out.println("-------------------");
      }

   }

   // 10개 단어와 뜻 입력
   public static void InputWord() {
      System.out.println("영단어 검색기");
      System.out.println("5개는 단어 5개는 뜻을 입력하시오");
      for (int i = 0; i < EnglishWord.length; i++) {
         EnglishWord[i] = in.nextLine();
      }
      System.out.println("단어의 뜻을 영어단어 입력한 순서에 맞게 입력하세요.");
      for (int i = 0; i < EnglishWord.length; i++) {
         EnglishK[i] = in.nextLine();
      }
      System.out.println();
   }

   // 입력값 출력
   public static void OutputWord() {
      System.out.println("-------------------");
      System.out.println("등록한 단어와 뜻 목록: ");
      for (int i = 0; i < EnglishWord.length; i++) {
         System.out.println(i + 1 + "번째 영단어:" + EnglishWord[i] + " ");
      }
      System.out.println("-------------------");
      for (int i = 0; i < EnglishWord.length; i++) {
         System.out.println(i + 1 + "번째 영단어 뜻: " + EnglishK[i] + " ");
      }
      System.out.println();
   }

   public static void Search() {
      // 입력한 값이 단어와 맞으면 출력 아니면 없음 출력
      System.out.println("검색할 단어를 입력하시오");
      String b = in.nextLine();
      for (int i = 0; i < EnglishWord.length; i++) {
         if (EnglishWord[i].equals(b)) {
            System.out.println("영단어: " + EnglishWord[i]);
            System.out.println("단어뜻: " + EnglishK[i]);
            break;
            //연관검색 
         } else if (!(b.length() == (EnglishWord[i].length() - 1))) {
            int cnt = 0;

            for (int j = 0; j < EnglishWord[i].length() - 1; j++) {
               if (j < b.length()) {
                  if (b.charAt(j) == EnglishWord[i].charAt(j)) {
                     cnt++;
                  }
                  if (cnt >= EnglishWord[i].length() - 1) {
                     System.out.println(EnglishWord[i]);
                     System.out.println(EnglishK[i]);
                  }
               }
            }
         }
         if (i == EnglishWord.length - 1) {   //마지막 요소까지 갔는데도 찾지못했다면"없음" -1 하는이유는 인덱스는0부터 시작하지만 length는 1부터 시작하기때문에.
               System.out.println("없음");
         }
      }
   }

   // 단어 삭제
   public static void Delete() {
      System.out.println("삭제할 단어를 입력하시오");
      InputWord = in.nextLine();
      for (int i = 0; i < EnglishWord.length; i++) {
         if (InputWord.equals(EnglishWord[i])) {
            EnglishWord[i] = "";
            EnglishK[i] = "";
            System.out.println("단어가 삭제되었습니다.");
         }
      }

   }

   // 단어 업데이트(수정)
   public static void Update() {
      System.out.println("변경전 단어를 입력하세요.(공백일경우 엔터)");
      InputWord = in.nextLine();
      for (int i = 0; i < EnglishWord.length; i++) {
         if (InputWord.equals(EnglishWord[i])) {
            System.out.println("변경후 단어를 입력하세요.");
            EnglishWord[i] = in.nextLine();
         }
      }
      System.out.println("변경전 영어단어 뜻을 입력하세요.(공백일경우 엔터)");
      InputWord = in.nextLine();
      for (int i = 0; i < EnglishK.length; i++) {
         if (InputWord.equals(EnglishK[i])) {
            System.out.println("변경후 영어단어 뜻을 입력하세요.");
            EnglishK[i] = in.nextLine();
            System.out.println("단어가 수정되었습니다.");
         }
      }
   }
}