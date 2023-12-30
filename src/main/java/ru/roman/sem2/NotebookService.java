package ru.roman.sem2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NotebookService {

    public List<Notebook> creatNotebookList(int numberOfLaptops){
        double[] priceArray = new double[]{100, 200, 300, 400, 500, 600, 700, 800};
        int[] ramArray = new int[]{4, 8, 16, 20, 24, 28, 32};
        Notebook.Brand[] brandArray = Notebook.Brand.values();
        List<Notebook> notebooks = new ArrayList<>();

        for (int i = 0; i < numberOfLaptops; i++) {
            int indexPrice = ThreadLocalRandom.current().nextInt(priceArray.length);
            int indexRaw = ThreadLocalRandom.current().nextInt(ramArray.length);
            int indexBrand = ThreadLocalRandom.current().nextInt(brandArray.length);
            notebooks.add(new Notebook(priceArray[indexPrice], ramArray[indexRaw], brandArray[indexBrand]));
        }
        return notebooks;
    }

}
