//TODO Build a class that can be used to update the progress the player makes and to check if an input is part of our chosen movie

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class Hang_Movie
{
    public static void main(String[] args) throws Exception{
        Scanner read_guess = new Scanner(System.in);
        File movies = new File("movies.txt");
        Integer num_movies = count_movies(movies);
        String chosen_movie = choose_movie(movies, num_movies);
        Integer title_size = chosen_movie.length();
        Character[] progress_display = new Character[title_size];
        Hashtable<Character, ArrayList<Integer>>  letter_indexes  =  new Hashtable<Character, ArrayList<Integer>>();

        final Integer CHANCES = 10;
        Integer  current_chance = 0;
        
        for(int i = 0; i<title_size; i++)
        {
            Character  character = chosen_movie.charAt(i); 
            if(Character.isLetter(character))
            {
                progress_display[i] = '_';

                if(letter_indexes.containsKey(character))
                {
                    letter_indexes.get(character).add(i);
                }
                else
                {
                    ArrayList<Integer> indexes = new ArrayList<Integer>();
                    indexes.add(i);
                    letter_indexes.put(character, indexes);
                }
            }
            else
            {
               progress_display[i] = ' ';
            }
         
        }

        
        print_progress(progress_display);
        do
        {
            System.out.print("Enter letter: ");
            Character guess = read_guess.nextLine().charAt(0);

            if(letter_indexes.containsKey(guess))
            {
                ArrayList<Integer> indexes = letter_indexes.get(guess);
                for(Integer index: indexes)
                {
                    progress_display[index] = chosen_movie.charAt(index);
                }
                letter_indexes.remove(guess);
            }

            current_chance++;
            print_progress(progress_display);
        }while(!letter_indexes.isEmpty() && current_chance<CHANCES);

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

    private static void print_progress(Character[] progress_display)
    {
        for(Character character: progress_display)
        {
            System.out.print(character + " ");
        }
        System.out.println();
    }
}