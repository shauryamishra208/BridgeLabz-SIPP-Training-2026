class Book {
    private String title;
    private int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getTitle() { return title; }
    public int getPublicationYear() { return publicationYear; }

    public void displayInfo() {
        System.out.println("Title           : " + title);
        System.out.println("Published Year  : " + publicationYear);
    }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public String getName() { return name; }
    public String getBio() { return bio; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name     : " + name);
        System.out.println("Author Bio      : " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Author author = new Author(
            "Clean Code", 2008,
            "Robert C. Martin",
            "Software engineer and author, known as Uncle Bob."
        );

        System.out.println("=== Book & Author Details ===");
        author.displayInfo();
    }
}
