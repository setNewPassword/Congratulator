import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Congratulator {
    private final List<String> begin;
    private final List<String> middle;
    private final List<String> end;

    List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл " + e.getMessage() + ". Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }


    public Congratulator() {
        begin = readFileContents("src/Dataset/Begin.txt");
        middle = readFileContents("src/Dataset/Middle.txt");
        end = readFileContents("src/Dataset/End.txt");

    }

    public String congratulate() {
        return "С Новым годом, " + begin.get((int) (Math.random() * (begin.size()-1)))
                + " Я желаю вам " + middle.get((int) (Math.random() * (middle.size()-1)))
                + " И пусть " + end.get((int) (Math.random() * (end.size()-1)));
    }
}
