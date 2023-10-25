package practicumopdracht.data;

import practicumopdracht.models.Comic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ComicTextDAO extends ComicDAO{
    @Override
    public boolean save() {
        File file = new File("comics.txt");


        try(PrintWriter printWriter = new PrintWriter(file);){
            printWriter.println(comics.size());
            for (Comic comic: comics){
                printWriter.println(comic.getName());
                printWriter.println(comic.getDescription());
                printWriter.println(comic.getAuthor());
                printWriter.println(comic.getRating());
            }
            return true;

        } catch(FileNotFoundException ex){
            System.out.println("File not found!");
        } catch(Exception ex) {
            System.out.println("Unexpected error!");
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean load() {
        File file = new File("comics.txt");

        try(Scanner scanner = new Scanner(file);) {
            int comicAmount = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < comicAmount; i++){
                String name = scanner.nextLine().trim();
                String description = scanner.nextLine().trim();
                String author = scanner.nextLine().trim();
                double rating = Double.parseDouble(scanner.nextLine().trim());

                Comic comic = new Comic(name, rating, author, description);
                super.comics.add(comic);
                return true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch(Exception ex) {
            System.out.println("Unexpected error!");
            ex.printStackTrace();
        }
        return false;
    }
}
