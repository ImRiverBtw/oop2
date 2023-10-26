package practicumopdracht.data;

import practicumopdracht.models.Comic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.AccessDeniedException;
import java.util.Scanner;

public class TextComicDAO extends ComicDAO{
    @Override
    public boolean save() {
        File file = new File("comics.txt");


        try(PrintWriter printWriter = new PrintWriter(file);){
            printWriter.println(comics.size());
            for (Comic comic: comics){
                printWriter.println(comic.getName());
                printWriter.println(comic.getDescription().replace("\n", "&newline&"));
                printWriter.println(comic.getAuthor());
                printWriter.println(comic.getRating());
            }
            return true;

        }
        catch(FileNotFoundException ex){
            System.out.println("File not found!");
        }
        catch (SecurityException ex) {
            System.out.println("You don't have permission to access this file");
        }
        catch(Exception ex) {
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
                String singleLineDescription = scanner.nextLine().trim();
                String[] lines = singleLineDescription.split("&newline&");
                StringBuilder descriptionSb = new StringBuilder();
                for (String line : lines) {
                    descriptionSb.append(line).append("\n");
                }
                String restoredDescription = descriptionSb.toString();
                String author = scanner.nextLine().trim();
                double rating = Double.parseDouble(scanner.nextLine().trim());

                Comic comic = new Comic(name, rating, author, restoredDescription);
                super.comics.add(comic);
            }
            return  true;
        }
        catch(FileNotFoundException ex){
            System.out.println("File not found!");
        }
        catch (SecurityException ex) {
            System.out.println("You don't have permission to access this file");
        }
        catch(Exception ex) {
            System.out.println("Unexpected error!");
            ex.printStackTrace();
        }
        return false;
    }
}
