import java.util.ArrayList;
import java.util.Scanner;
class Book {
int id;
String title;
String author;
boolean isIssued;
Book(int id, String title, String author) { this.id = id;
this.title = title;
this.author = author; this.isIssued = false;
}
@Override
public String toString() {
return id + " - " + title + " by " + author + (isIssued ? " (Issued)" : " (Available)"); }
}
class Library {
ArrayList<Book> books = new ArrayList<>(); public void addBook(Book book) {
books.add(book);
System.out.println("Book added successfully!"); }
public void displayBooks() {
if (books.isEmpty()) {
System.out.println("No books in library."); } else {
for (Book b : books) { System.out.println(b);
}
}}
public void issueBook(int id) {
for (Book b : books) {
if (b.id == id) {
if (!b.isIssued) {
b.isIssued = true;
System.out.println("Book issued: " + b.title);
return;
} else {
System.out.println("Book is already issued.");
return;
}
}}
System.out.println("Book ID not found.");
}
public void returnBook(int id) {
for (Book b : books) {
if (b.id == id) {
if (b.isIssued) {
b.isIssued = false;
System.out.println("Book returned: " + b.title);
return;
} else {
System.out.println("This book was not issued.");
return;
}
}}
System.out.println("Book ID not found.");
}
}
public class Demo {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Library library = new Library();
while (true) {
System.out.println("\n Welcome to Sanjana's Library System\n"); System.out.println("1. Add Book");
System.out.println("2. Display Books"); System.out.println("3. Issue Book"); System.out.println("4. Return Book"); System.out.println("5. Exit");
System.out.print("Enter choice: "); int choice = sc.nextInt();
switch (choice) { case 1:
System.out.print("Enter Book ID: ");
int id = sc.nextInt();
sc.nextLine(); 
System.out.print("Enter Book Title: ");
String title = sc.nextLine();
System.out.print("Enter Author: ");
String author = sc.nextLine();
Book book = new Book(id, title, author); library.addBook(book);
break;
case 2:
library.displayBooks();
break;
case 3:
System.out.print("Enter Book ID to issue: "); int issueId = sc.nextInt();
library.issueBook(issueId);
break;
case 4:
System.out.print("Enter Book ID to return: "); int returnId = sc.nextInt();
library.returnBook(returnId);
break;
case 5:
System.out.println("Thank You!!..Visit Again.."); sc.close();
System.exit(0);
default:
System.out.println("Invalid choice!"); }
} }
}