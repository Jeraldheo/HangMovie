import java.io.File;
import java.util.Scanner;

public class Hang_Movie
{
    public static void main(String[] args) throws Exception{
        File movies = new File("movies.txt");
        Integer num_movies = 0;

        Scanner read_movies = new Scanner(movies);

        while(read_movies.hasNextLine())
        {
            num_movies++;
            read_movies.nextLine();
        }

        


    }
}