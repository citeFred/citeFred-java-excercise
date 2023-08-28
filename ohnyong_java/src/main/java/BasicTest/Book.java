package BasicTest;

import java.util.Arrays;
import java.util.Scanner;

/*1. 인스턴스변수
index, title, contents
각각 알맞는 참조형 변수로 생성
2. 클래스변수
pages
3. title, contents만 초기화하는 생성자
4. contents를 수정하는 메서드 update
5. contents를 확인하는 메서드 read
*인스턴스 변수의 접근제어자는 Book 클래스에서만 접근 가능하게*/
public class Book {
    int index; //iv
    String title; //iv
    String[] contents; //iv
    static int pages; //cv (static)
    public Book(){
        //기본생성자
        //super();들어가야하지않나? 컴파일러가 해주니 상관없겠지?
    }

    public Book(int index) {
    }

    public Book(String title, String[] contents){
        //여기에도 super();가 들어가는데 아래 변수들은 초기화되겠군
        this.title = title;
        this.contents = contents;
    }


    //메소드

    void idxCnt(int index){
        this.index = index;
    }
    void addBook(Book b){
        this.title = b.title;
        this.contents = b.contents;
        this.index++;
    }
    void updateBook(String[][] bookUpdate){ // <- 나중엔 DTO로 받을것이다.
        this.title = bookUpdate[0][0];
        for(int i=0;i<bookUpdate.length;i++) {
            for(int j=0;j< bookUpdate.length;j++) {
                this.contents = new String[]{bookUpdate[1][j]};
            }
        }
    }
    String readPage(int pages) { // n페이지를 보고싶다.
        String outputContent = "";
        for (int i = 0; i < contents.length; i++) {
            if (pages-1 == i) {
                outputContent = this.contents[i];
            }else{
                outputContent = "없습니다.";
            }
        }
        return outputContent;
    }

}

class BookTest{
    public static void main(String[] args) {
        //Add 버튼을 통해 책 정보를 받았다면,
        String title = "Title";
        String[] contents = {"책입니다.1", "재밌어요2"};
        Book b = new Book(title, contents);
        b.addBook(b);


        //입력을 통해 책 변경 값들을 받았다면,
        String[] titleUpdate = {"Title 변경"};
        String[] contentsUpdate = {"흥미로움1","재밌나요2"}; // 별도인스
        String[][] bookUpdate = {titleUpdate, contentsUpdate}; // <<--- { {title} , { {흥}, {재} } 를 updateBook 인자로 전달
        //System.out.println(Arrays.toString(contentsUpdate));
        b.updateBook(bookUpdate); //Memo Update- > 값들어옴 -> DTO에 담아서 -> 전달, 받고

        //입력을 통해 보려는 책(특정 책 index)와 page 값을 받았다면,
        //int index = 0;
        System.out.println("보고싶은 페이지를 입력하세요");
        Scanner sc = new Scanner(System.in);
        int pages = sc.nextInt();
        System.out.println(b.readPage(pages));

    }
}
