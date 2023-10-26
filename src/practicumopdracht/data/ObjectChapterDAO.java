package practicumopdracht.data;

import practicumopdracht.Main;
import practicumopdracht.MainApplication;
import practicumopdracht.models.Chapter;
import practicumopdracht.models.Comic;

import java.io.*;
import java.util.Objects;

public class ObjectChapterDAO extends ChapterDAO {

    @Override
    public boolean save() {
        File file = new File("chapters.obj");

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeInt(chapters.size());
            for (Chapter chapter : chapters){
                objectOutputStream.writeObject(chapter);
                objectOutputStream.writeInt(MainApplication.getComicDAO().getComicId(chapter.getBelongsTo()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean load() {
        File file = new File("chapters.obj");
        System.out.println("loading chapters");

        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            int chapterAmount = objectInputStream.readInt();
            for (int i = 0; i < chapterAmount; i++) {
                Chapter chapter = (Chapter) objectInputStream.readObject();
                Comic belongsTo = MainApplication.getComicDAO().getById(objectInputStream.readInt());
                Chapter newChapter = new Chapter(belongsTo, chapter.getTitle(), chapter.getChapterNumber(), chapter.getReleaseDate(), chapter.isLiked());
                chapters.add(newChapter);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
