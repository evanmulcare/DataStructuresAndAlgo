public class Book<T>
{
    private String title;
    private int releaseYear;
    private String author;
    public Book(String title,int releaseYear,String author)
    {
        this.setTitle(title);
        this.setReleaseYear(releaseYear);
        this.setAuthor(author);
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getTitle()
    {
        return title;
    }
    
    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }
    public int getReleaseYear()
    {
        return releaseYear;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public String getAuthor()
    {
        return author;
    }
    
    public String toString()
    {
        return "Book Title " + getTitle() + " Release Year " + getReleaseYear() + " Author " + getAuthor(); 
    }
    
    public void print()
    {
        System.out.println(toString());
    }

}

class PrintBook extends Book
    {
        private String publisher;
        private String ISBN;
        
        public PrintBook(String title,int releaseYear,String author,String publisher,String ISBN)
        {
            super(title, releaseYear, author);
            this.setPublisher(publisher);
            this.setISBN(ISBN);
        }
        
        public void setPublisher(String publisher)
        {
            this.publisher = publisher;
        }
        public String getPublisher()
        {
            return publisher;
        }
        
        public void setISBN(String ISBN)
        {
            this.ISBN = ISBN;
        }
        public String getISBN()
        {
            return ISBN;
        }
        
        public String toString()
        {
            return "Book Title " + getTitle() + " Release Year " + getReleaseYear()
            + " Author " + getAuthor() + " Publisher " + getPublisher() + " ISBN " + getISBN(); 
        }
    }

class AudioBook extends Book
{
   private int bookSize;
   private int playLength;
   private String playBackArtist;
   
    public AudioBook(String title,int releaseYear,String author,int bookSize, int playLength,String playBackArtist)
        {
            super(title, releaseYear, author);
            this.setBookSize(bookSize);
            this.setPlayLength(playLength);
            this.setPlayBackArtist(playBackArtist);
        }
        
    public void setBookSize(int bookSize)
        {
            this.bookSize = bookSize;
        }
    public int getBookSize()
        {
            return bookSize;
        }
        
    public void setPlayLength(int playLength)
        {
            this.playLength = playLength;
        }
    public int getPlayLength()
        {
            return playLength;
        }
        
    public void setPlayBackArtist(String playBackArtist)
        {
            this.playBackArtist = playBackArtist;
        }
    public String getPlayBackArtist()
        {
            return playBackArtist;
        }
        
    public String toString()
        {
            return "Book Title " + getTitle() + " Release Year " + getReleaseYear()
            + " Author " + getAuthor() + " Book Size(MB) " 
            + getBookSize() + " Play Length " + getPlayLength() + " PlayBack Artist " + getPlayBackArtist(); 
        }
}