package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Chapter;
import practicumopdracht.models.Comic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class TextChapterDAO extends ChapterDAO{
    @Override
    public boolean save() {
        File file = new File("chapters.txt");

        try(PrintWriter printWriter = new PrintWriter(file)){
            printWriter.println(chapters.size());
            for (Chapter chapter: chapters){
                printWriter.println(MainApplication.getComicDAO().getComicId(chapter.getBelongsTo()));
                printWriter.println(chapter.getTitle());
                printWriter.println(chapter.getChapterNumber());
                printWriter.println(chapter.getReleaseDate());
                printWriter.println(chapter.isLiked());
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
        File file = new File("chapters.txt");

        try(Scanner scanner = new Scanner(file)) {
            int chapterAmount = scanner.nextInt();
            for (int i = 0; i < chapterAmount; i++){
                Comic belongsTo = MainApplication.getComicDAO().getById(scanner.nextInt());
                scanner.nextLine();
                String title = scanner.nextLine().trim();
                int chapterNumber = scanner.nextInt();
                scanner.nextLine();
                LocalDate releaseDate = LocalDate.parse(scanner.nextLine().trim());
                boolean isLiked = Boolean.parseBoolean(scanner.nextLine());

                Chapter chapter = new Chapter(belongsTo, title, chapterNumber, releaseDate, isLiked);
                super.chapters.add(chapter);
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
}

