import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static List<String> getInput(String path) throws IOException {
        return Files.lines(Path.of(path)).toList();
    }

    public static Map<Integer, List<String>> files(List<String> words) throws IOException {
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public static Map<Integer, Integer> files2(List<String> words) throws IOException {
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.summingInt(e -> 1)));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(files(getInput("src/data.txt")));
        System.out.println();
        System.out.println(files2(getInput("src/data.txt")));
    }
}