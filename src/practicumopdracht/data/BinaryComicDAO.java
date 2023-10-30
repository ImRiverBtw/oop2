package practicumopdracht.data;

import practicumopdracht.models.Comic;

import java.io.*;

public class BinaryComicDAO extends ComicDAO {

    @Override
    public boolean save() {
        File file = new File("comics.dat");

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)
        ) {
            dataOutputStream.writeInt(comics.size());
            for (Comic comic : comics) {
                dataOutputStream.writeUTF(comic.getName());
                dataOutputStream.writeUTF(comic.getDescription());
                dataOutputStream.writeUTF(comic.getAuthor());
                dataOutputStream.writeDouble(comic.getRating());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (SecurityException ex) {
            System.out.println("You don't have permission to access this file");
        } catch (Exception ex) {
            System.out.println("Unexpected error!");
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean load() {
        File file = new File("comics.dat");

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream)
        ) {
            int comicAmount = dataInputStream.readInt();
            for (int i = 0; i < comicAmount; i++) {
                String name = dataInputStream.readUTF();
                String description = dataInputStream.readUTF();
                String author = dataInputStream.readUTF();
                double rating = dataInputStream.readDouble();
                Comic comic = new Comic(name, rating, author, description);
                comics.add(comic);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (SecurityException ex) {
            System.out.println("You don't have permission to access this file");
        } catch (Exception ex) {
            System.out.println("Unexpected error!");
            ex.printStackTrace();
        }
        return false;
    }
}
