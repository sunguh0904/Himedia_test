package com.ohgiraffers.test.controller;

import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    ArrayList<BookDTO> list = new ArrayList<>();

    public void addBook(BookDTO book) {
        list.add(book);
    }

    public void deleteBook(int index) {
        for (BookDTO bookDTO : list) {
            if (bookDTO.equals(index)) {
                list.remove(index);
            }
        }
        System.out.println("해당 도서를 삭제 했습니다.");
    }

    public int searchBook(String title) {
        int result = 1;
        for (BookDTO bookDTO : list) {
            if (bookDTO.getTitle().contains(title)) {
                System.out.println(bookDTO);
                result = 0;
                break;
            }
        }
        return result;
    }

    public void printBook(int index) {
        for (BookDTO bookDTO : list) {
//            bookDTO.getbNo()
        }
    }

    public void displayAll() {
        for (BookDTO bookDTO : list) {
            System.out.println(bookDTO);
        }
    }

//    public ArrayList<BookDTO> sortedBookList(int select) {}

    public void printBookList(ArrayList<BookDTO> br) {}
}
