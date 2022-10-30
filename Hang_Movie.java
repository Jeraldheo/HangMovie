import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Hang_Movie
{
    public static void main(String[] args) throws Exception{
        File movies = new File("movies.txt");
        Integer num_movies = count_movies(movies);
        String chosen_movie = choose_movie(movies, num_movies);
        
        


    }

    private static Integer count_movies(File movies) throws Exception
    {
        Scanner read_movies = new Scanner(movies);
        Integer num_movies = 0;
        while(read_movies.hasNextLine())
        {
            num_movies++;
            read_movies.nextLine();
        }
        read_movies.close();
        return num_movies;
    }

    private static String choose_movie(File movies, Integer num_movies) throws Exception
    {
        Random movie_selector = new Random();
        Integer list_number = movie_selector.nextInt(num_movies) + 1;// index_movie is an integer from 1 to num_movies
        Scanner read_movies = new Scanner(movies);

        String chosen_movie = "";
        for(int i = 1; i<=list_number;i++)
        {
            chosen_movie = read_movies.nextLine();
        }
        read_movies.close();
        return chosen_movie;

    }
}