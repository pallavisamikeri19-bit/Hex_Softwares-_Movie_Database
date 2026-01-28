import java.util.ArrayList;
import java.util.Scanner;

// Movie class
class Movie {
    private String title;
    private String director;
    private int year;
    private String genre;

    public Movie(String title, String director, int year, String genre) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void display() {
        System.out.println("\n--- Movie Details ---");
        System.out.println("Title    : " + title);
        System.out.println("Director : " + director);
        System.out.println("Year     : " + year);
        System.out.println("Genre    : " + genre);
    }
}

// MovieDatabase class
class MovieDatabase {
    private ArrayList<Movie> movies = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addMovie() {
        System.out.print("Enter Movie Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Director Name: ");
        String director = sc.nextLine();

        System.out.print("Enter Release Year: ");
        int year = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        movies.add(new Movie(title, director, year, genre));
        System.out.println("Movie added successfully!");
    }

    public void searchMovie() {
        System.out.print("Enter movie title to search: ");
        String searchTitle = sc.nextLine();

        boolean found = false;
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(searchTitle)) {
                m.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Movie not found!");
        }
    }

    public void displayAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies in database!");
            return;
        }

        for (Movie m : movies) {
            m.display();
        }
    }
}

// Main class
public class MovieDatabaseApp {
    public static void main(String[] args) {
        MovieDatabase db = new MovieDatabase();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n===== Movie Database Menu =====");
            System.out.println("1. Add Movie");
            System.out.println("2. Search Movie");
            System.out.println("3. Display All Movies");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    db.addMovie();
                    break;
                case 2:
                    db.searchMovie();
                    break;
                case 3:
                    db.displayAllMovies();
                    break;
                case 4:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }
  }
