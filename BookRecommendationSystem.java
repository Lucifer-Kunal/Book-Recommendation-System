import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BookRecommendationSystem {

    private static final java.util.List<Book> books = Arrays.asList(
            new Book("The Alchemist", "Fiction", "Paulo Coelho"),
            new Book("Atomic Habits", "Self-Help", "James Clear"),
            new Book("To Kill a Mockingbird", "Classic", "Harper Lee"),
            new Book("1984", "Dystopian", "George Orwell"),
            new Book("Sapiens", "History", "Yuval Noah Harari"),
            new Book("Pride and Prejudice", "Classic", "Jane Austen"),
            new Book("The Great Gatsby", "Classic", "F. Scott Fitzgerald"),
            new Book("The Catcher in the Rye", "Classic", "J.D. Salinger"),
            new Book("Brave New World", "Dystopian", "Aldous Huxley"),
            new Book("The Road", "Dystopian", "Cormac McCarthy"),
            new Book("Educated", "Memoir", "Tara Westover"),
            new Book("Becoming", "Memoir", "Michelle Obama"),
            new Book("The Power of Habit", "Self-Help", "Charles Duhigg"),
            new Book("Think and Grow Rich", "Self-Help", "Napoleon Hill"),
            new Book("Man's Search for Meaning", "Self-Help", "Viktor E. Frankl"),
            new Book("Meditations", "Philosophy", "Marcus Aurelius"),
            new Book("Crime and Punishment", "Classic", "Fyodor Dostoevsky"),
            new Book("War and Peace", "Classic", "Leo Tolstoy"),
            new Book("Anna Karenina", "Classic", "Leo Tolstoy"),
            new Book("The Brothers Karamazov", "Classic", "Fyodor Dostoevsky"),
            new Book("Les Misérables", "Classic", "Victor Hugo"),
            new Book("The Hobbit", "Fantasy", "J.R.R. Tolkien"),
            new Book("The Lord of the Rings", "Fantasy", "J.R.R. Tolkien"),
            new Book("Harry Potter and the Sorcerer's Stone", "Fantasy", "J.K. Rowling"),
            new Book("Harry Potter and the Chamber of Secrets", "Fantasy", "J.K. Rowling"),
            new Book("A Game of Thrones", "Fantasy", "George R.R. Martin"),
            new Book("The Name of the Wind", "Fantasy", "Patrick Rothfuss"),
            new Book("Mistborn: The Final Empire", "Fantasy", "Brandon Sanderson"),
            new Book("The Way of Kings", "Fantasy", "Brandon Sanderson"),
            new Book("Dune", "Science Fiction", "Frank Herbert"),
            new Book("Ender's Game", "Science Fiction", "Orson Scott Card"),
            new Book("Foundation", "Science Fiction", "Isaac Asimov"),
            new Book("Neuromancer", "Science Fiction", "William Gibson"),
            new Book("Snow Crash", "Science Fiction", "Neal Stephenson"),
            new Book("The Martian", "Science Fiction", "Andy Weir"),
            new Book("Artemis", "Science Fiction", "Andy Weir"),
            new Book("The Shining", "Horror", "Stephen King"),
            new Book("It", "Horror", "Stephen King"),
            new Book("Dracula", "Horror", "Bram Stoker"),
            new Book("Frankenstein", "Horror", "Mary Shelley"),
            new Book("The Haunting of Hill House", "Horror", "Shirley Jackson"),
            new Book("Gone Girl", "Thriller", "Gillian Flynn"),
            new Book("The Girl with the Dragon Tattoo", "Thriller", "Stieg Larsson"),
            new Book("The Da Vinci Code", "Thriller", "Dan Brown"),
            new Book("Angels & Demons", "Thriller", "Dan Brown"),
            new Book("Shutter Island", "Thriller", "Dennis Lehane"),
            new Book("Big Little Lies", "Drama", "Liane Moriarty"),
            new Book("The Night Circus", "Fantasy", "Erin Morgenstern"),
            new Book("Circe", "Fantasy", "Madeline Miller"),
            new Book("The Song of Achilles", "Fantasy", "Madeline Miller"),
            new Book("The Midnight Library", "Fiction", "Matt Haig"),
            new Book("Where the Crawdads Sing", "Fiction", "Delia Owens"),
            new Book("Before We Were Strangers", "Romance", "Renee Carlino"),
            new Book("The Hating Game", "Romance", "Sally Thorne"),
            new Book("Beach Read", "Romance", "Emily Henry"),
            new Book("People We Meet on Vacation", "Romance", "Emily Henry"),
            new Book("Red, White & Royal Blue", "Romance", "Casey McQuiston"),
            new Book("The Seven Husbands of Evelyn Hugo", "Fiction", "Taylor Jenkins Reid"),
            new Book("Daisy Jones & The Six", "Fiction", "Taylor Jenkins Reid"),
            new Book("Malibu Rising", "Fiction", "Taylor Jenkins Reid"),
            new Book("Verity", "Thriller", "Colleen Hoover"),
            new Book("It Ends with Us", "Romance", "Colleen Hoover"),
            new Book("Reminders of Him", "Romance", "Colleen Hoover"),
            new Book("Ugly Love", "Romance", "Colleen Hoover"),
            new Book("November 9", "Romance", "Colleen Hoover"),
            new Book("The Silent Patient", "Thriller", "Alex Michaelides"),
            new Book("The Last Mrs. Parrish", "Thriller", "Liv Constantine"),
            new Book("The Couple Next Door", "Thriller", "Shari Lapena"),
            new Book("An Anonymous Girl", "Thriller", "Greer Hendricks"),
            new Book("The Wife Between Us", "Thriller", "Greer Hendricks"),
            new Book("The Chain", "Thriller", "Adrian McKinty"),
            new Book("The Paris Library", "Historical Fiction", "Janet Skeslien Charles"),
            new Book("The Nightingale", "Historical Fiction", "Kristin Hannah"),
            new Book("The Book Thief", "Historical Fiction", "Markus Zusak"),
            new Book("All the Light We Cannot See", "Historical Fiction", "Anthony Doerr"),
            new Book("A Man Called Ove", "Fiction", "Fredrik Backman"),
            new Book("Anxious People", "Fiction", "Fredrik Backman"),
            new Book("My Grandmother Asked Me to Tell You She's Sorry", "Fiction", "Fredrik Backman"),
            new Book("Britt-Marie Was Here", "Fiction", "Fredrik Backman"),
            new Book("Us Against You", "Fiction", "Fredrik Backman"),
            new Book("Bear Town", "Fiction", "Fredrik Backman"),
            new Book("Eleanor Oliphant Is Completely Fine", "Fiction", "Gail Honeyman"),
            new Book("The Rosie Project", "Romance", "Graeme Simsion"),
            new Book("The Rosie Effect", "Romance", "Graeme Simsion"),
            new Book("The Rosie Result", "Romance", "Graeme Simsion")
    );

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BookRecommendationSystem::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("📚 Book Recommendation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());

        // Top Panel: Title
        JLabel titleLabel = new JLabel("📖 Find Your Next Favorite Book", JLabel.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 150, 243));
        titleLabel.setBorder(new EmptyBorder(20, 10, 20, 10));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Center Panel: Inputs
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        inputPanel.setBorder(new EmptyBorder(20, 50, 20, 50));

        JLabel genreLabel = new JLabel("Select Genre:");
        genreLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        String[] genres = {"All", "Fiction", "Self-Help", "Classic", "Dystopian", "History", "Memoir"};
        JComboBox<String> genreComboBox = new JComboBox<>(genres);

        JLabel authorLabel = new JLabel("Select Author:");
        authorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        Set<String> authors = new TreeSet<>();
        authors.add("All");
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        JComboBox<String> authorComboBox = new JComboBox<>(authors.toArray(new String[0]));

        inputPanel.add(genreLabel);
        inputPanel.add(genreComboBox);
        inputPanel.add(authorLabel);
        inputPanel.add(authorComboBox);
        frame.add(inputPanel, BorderLayout.CENTER);

        // Bottom Panel: Recommendations and Button
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(20, 50, 20, 50));

        JButton recommendButton = new JButton("🎯 Get Recommendation");
        recommendButton.setFont(new Font("Arial", Font.BOLD, 16));
        recommendButton.setBackground(new Color(76, 175, 80));
        recommendButton.setForeground(Color.WHITE);
        recommendButton.setFocusPainted(false);
        recommendButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        resultArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPane = new JScrollPane(resultArea);

        bottomPanel.add(recommendButton, BorderLayout.NORTH);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Action Listener for Recommendations
        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedGenre = (String) genreComboBox.getSelectedItem();
                String selectedAuthor = (String) authorComboBox.getSelectedItem();

                java.util.List<Book> recommendations = recommendBooks(selectedGenre, selectedAuthor);
                resultArea.setText("");
                if (recommendations.isEmpty()) {
                    resultArea.setText("No recommendations found for the selected criteria.");
                } else {
                    for (Book book : recommendations) {
                        resultArea.append("📘 " + book.getTitle() + " by " + book.getAuthor() + "\n");
                    }
                }
            }
        });

        // Frame Visibility
        frame.setVisible(true);
    }

    private static java.util.List<Book> recommendBooks(String genre, String author) {
        java.util.List<Book> recommendations = new ArrayList<>();
        for (Book book : books) {
            boolean matchesGenre = genre.equals("All") || book.getGenre().equalsIgnoreCase(genre);
            boolean matchesAuthor = author.equals("All") || book.getAuthor().equalsIgnoreCase(author);

            if (matchesGenre && matchesAuthor) {
                recommendations.add(book);
            }
        }
        return recommendations;
    }
}

class Book {
    private final String title;
    private final String genre;
    private final String author;

    public Book(String title, String genre, String author) {
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }
}
