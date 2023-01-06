public class BookTest
{
    public static void main(String[] args)
    {
        Book b1 = new Book("baseBook", 1999, "James");
        Book b2 = new PrintBook("paperBackBook", 2000, "alan",                                         "Penguin", "B234S");
        Book b3 = new AudioBook("AudioBook", 1999, "James", 25, 90,                                     "Elena");
        
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
    }
}
