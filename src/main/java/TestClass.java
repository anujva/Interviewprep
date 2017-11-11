

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestClass {
    public static void main(String[] args) {
//        String[] words = {
//                "Word1", "Word2", "Word3"
//        };
//
//        changeValueInArray(words);
//
//        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i]);
//        }

        try {
            DirectoryStream<Path> pathDirectoryStream =
                    Files.newDirectoryStream(new File("/home/anuj").toPath());
            for (Path path : pathDirectoryStream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeValueInArray(String[] words) {
        words[0] = "What the hell";
        words = new String[]{
                "Changing everything"
        };
    }
}
