package winedatabase;

import wine.Wine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by Jaanus on 5.11.16.
 */
public class WineDatabase {
    private List<Wine> wines;

    public void readDataFromDataSet() {
        Path path = Paths.get("/home/kotkas44/projects/java/JOOP/kodutöö7/datasets/", "wine.data.txt");
        try (Stream<String> data = Files.lines(path)) {
            wines = data.map(line -> createWine(line.split(",")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Wine createWine(String[] info) {
        Wine wine = new Wine();
        wine.setCategory(Integer.parseInt(info[0]));
        wine.setAlcoholByVolume(Double.parseDouble(info[1]));
        wine.setMagnesiumContent(Double.parseDouble(info[5]));
        wine.setFlavonoidContent(Double.parseDouble(info[7]));
        return wine;
    }

    public void printWinesMagnesiumContentsStatistics() {
        startNewWineMagnesiumContentStream().average()
                .ifPresent(avg -> System.out.println("Keskmine: " + avg));
        startNewWineMagnesiumContentStream().min()
                .ifPresent(min -> System.out.println("Miinimum: " + min));
        startNewWineMagnesiumContentStream().max()
                .ifPresent(max -> System.out.println("Maximum: " + max));
    }

    private DoubleStream startNewWineMagnesiumContentStream() {
        return wines.stream().mapToDouble(wine -> wine.getMagnesiumContent());
    }

    public void putMagnesiumContentSlogans() {
        startNewWineMagnesiumContentStream().average()
                .ifPresent(avg -> setWineSloganToWarnAboutHighMagnesiumContent(avg));
    }

    private void setWineSloganToWarnAboutHighMagnesiumContent(Double averageMagnesiumContent) {
        String warningSlogan = "Siin veinis on palju magneesiumit!";
        wines.stream().filter(wine -> wine.getMagnesiumContent() > averageMagnesiumContent)
                .forEach(wine -> wine.addSlogan(warningSlogan));
    }

    public void printFiveSmallestFlavonoidAmounts() {
        wines.stream().mapToDouble(wine -> wine.getFlavonoidContent())
                .sorted()
                .limit(5)
                .forEach(System.out::println);
    }

    public void putCategoryThreeHighAlcoholSlogans() {
        wines.stream().mapToDouble(wine -> wine.getAlcoholByVolume())
                .average()
                .ifPresent(avg -> setCategoryThreeWineSloganToWarnAboutHighAlcoholContent(avg));
    }

    private void setCategoryThreeWineSloganToWarnAboutHighAlcoholContent(Double averageAlcoholContent) {
        String warningSlogan = "Alkohol on hea sulane, aga halb peremees! Alkohol kahjustab tervist ja eriti teie aju!";
        wines.stream().filter(wine -> wine.getCategory() == 3 && wine.getAlcoholByVolume() > averageAlcoholContent)
                .forEach(wine -> wine.addSlogan(warningSlogan));
    }

    public void printWines() {
        wines.forEach(System.out::println);
    }

    public static void main(String[] args) {
        WineDatabase database = new WineDatabase();
        database.readDataFromDataSet();
        System.out.println("Magneesiumi sisalduse statistilised näitajad veinides: ");
        database.printWinesMagnesiumContentsStatistics();
        database.putMagnesiumContentSlogans();
        System.out.println("\n5 kõige väiksemat magneesiumisisaldust veinides:");
        database.printFiveSmallestFlavonoidAmounts();
        database.putCategoryThreeHighAlcoholSlogans();
        System.out.println("\nVeinide info:");
        database.printWines();
    }
}
