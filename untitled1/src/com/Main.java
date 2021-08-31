package com;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        // Câu 1
        System.out.println("Giải câu 1.");
        File bookFile = new File("Book.txt");
        if (bookFile.exists()) {
            bookFile.getAbsoluteFile().delete();
        } else {
            bookFile.createNewFile();
        }

        // Tạo các đối tượng book
        List<Book> list = new ArrayList<>();
        String option = "0";
        System.out.print("Lựa chọn (1 : Tự nhập dữ liệu | 0 : Dùng dữ liệu có sẵn | Không chọn => 0 | Chọn sai => 0) : ");
        option = input.nextLine();
        if (option == null || option.isEmpty() || !option.equals("1")) {
            list.add(new Book("B1", "Doraemon", "Người không ngủ", 20F));
            list.add(new Book("B2", "Cừu vui vẻ và sói xám", "Lung Thị Linh", 30F));
            list.add(new Book("B3", "Trạn vương", "Hội những người thích lấy vợ giàu", 50F));
            list.add(new Book("B4", "Người không ngủ", "Nguyễn Văn Toản", 10000F));
        } else {
            int loop = 0;
            int check = 1;
            while (true) {
                if (loop == 0) {
                    System.out.print("Bạn có muốn nhập dữ liệu (1 : true | 0 : false) : ");
                } else {
                    System.out.print("Bạn có muốn nhập tiếp dữ liệu (1 : true | 0 : false) : ");
                }
                check = Integer.parseInt(input.nextLine());
                if (check == 0) {
                    break;
                } else {
                    System.out.println("Book " + (loop + 1));
                    Book book = new Book();
                    System.out.print("Nhâp code : ");
                    book.setCode(input.nextLine());
                    System.out.print("");
                    System.out.print("Nhập title : ");
                    book.setTitle(input.nextLine());
                    System.out.print("");
                    System.out.print("Nhập author : ");
                    book.setAuthor(input.nextLine());
                    System.out.print("");
                    System.out.print("Nhập price : ");
                    book.setPrice(Float.parseFloat(input.nextLine()));
                    list.add(book);
                }
                loop++;
                System.out.println("-------");
            }
        }


        System.out.println("\n"+"Thông tin trong tệp Book.txt");
        // Ghi 1 list book vào file
        FileWriter writer = new FileWriter(bookFile.getAbsolutePath(), true);
        for (Book i : list) {
            writer.write(i.toString() + "\n");
        }
        writer.close();

        // Đọc file
//        InputStream inputStream = new FileInputStream(bookFile);
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        int c;
//        while ((c = inputStreamReader.read()) != -1) {
//            System.out.print((char) c);
//        }
//        inputStream.close();

        Path path = Paths.get(bookFile.getAbsolutePath());
        List<String> reader = Files.readAllLines(path);
        System.out.println(reader);
        // Kết thúc câu 1
        System.out.println("\n");


        // Câu 2
        System.out.println("Giải câu 2.");
        System.out.println("Phần nhập thông tin các học sinh.");
        HashMap<String, String> students = new HashMap<>();
        // Nhập dữ liệu
        int flag = 0;
        int i = 0;
        while (true) {
            String phoneNumber = "";
            String name = "";
            String next = "000";
            if (i == 0) {
                System.out.print("Bạn có muốn nhập dữ liệu (1 : true | 000 : false) : ");
            } else {
                System.out.print("Bạn có muốn nhập tiếp dữ liệu (1 : true | 000 : false) : ");
            }
            next = input.nextLine();
            if (next == null || next.isEmpty() || next.equals("000")) {
                if (i == 0) {
                    flag = 1;
                }
                break;
            } else {
                System.out.println("Nhập thông tin học sinh " + (i + 1) + " ");
                System.out.print("Nhập số điện thoại : ");
                phoneNumber = input.nextLine();
                System.out.print("Nhập tên : ");
                name = input.nextLine();
                students.put(phoneNumber, name);
                i++;
                System.out.println("----");
            }
        }

        // In dữ liệu
        System.out.println();
        if (flag == 1) {
            System.out.println("Bạn không nhập thông tin của học sinh nào!");
        } else {
            System.out.println("Thông tin các học sinh :");
            for (String z : students.keySet()) {
                System.out.println("Số điện thoại: " + z + " | Tên: " + students.get(z));
            }
        }

        if(students.containsKey("000")){
            System.out.println("Có chứa dữ liệu sdt 000 : "+students.get("000"));
        }
        // Kết thúc câu 2


    }
}
