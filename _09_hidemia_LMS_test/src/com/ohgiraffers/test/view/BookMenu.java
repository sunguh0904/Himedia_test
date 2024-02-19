package com.ohgiraffers.test.view;

import com.ohgiraffers.test.controller.BookManager;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {

    Scanner sc = new Scanner(System.in);

    BookManager bm = new BookManager();

    public BookMenu() {}

    public void menu() {

        while (true) {

            System.out.println("========Menu========");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Search Book");
            System.out.println("4. Print Book");
            System.out.println("5. Display Book");
            System.out.println("0. programDown");
            System.out.println("=====================");

            int choiceNum = sc.nextInt();

            switch (choiceNum) {
                case 1 : bm.addBook(inputBook());
                    break;
                case 2 : bm.deleteBook(inputBookDelete());
                    break;
                case 3 : bm.searchBook(inputBookTitle());
                    break;
                case 4 : bm.printBook(inputBookPrint());
                    break;
                case 5 : bm.displayAll();
                    break;
                case 0 :
                    return;
                default:
                    return;
            }
        }
    }

    public BookDTO inputBook() {
        System.out.print("도서 순번 : ");
        int bNo = sc.nextInt();
        System.out.print("도서 장르 : ");
        int category = sc.nextInt();
        System.out.print("도서 제목 : ");
        String title = sc.next();
        System.out.print("도서 저자 : ");
        String author = sc.next();
        BookDTO bookDTO = new BookDTO(bNo, category, title, author);
        return bookDTO;
    }

//    public int inputBookPrint () {
//        System.out.print("검색 도서 번호 : ");
//        int printNum = sc.nextInt();
//        return printNum;
//    }

    public int inputBookPrint () {
        System.out.print("검색 도서 번호 : ");
        int printNum = sc.nextInt();
        return printNum;
    }

    public int inputBookDelete() {
        System.out.print("삭제 도서 번호 : ");
        int deleteNum = sc.nextInt();
        return deleteNum;
    }

    public String inputBookTitle() {
        System.out.print("도서 검색 : ");
        String searchTitle = sc.next();
        return searchTitle;
    }
}