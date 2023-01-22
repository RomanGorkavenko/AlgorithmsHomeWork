package ru.roman.sem2;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Notebook> notebooks = new NotebookService().creatNotebookList(10000);
        Collections.sort(notebooks);
        for (Notebook notebook : notebooks) {
            System.out.printf("%s %d %s\n",notebook.getPrice(),notebook.getRam(),notebook.getBrand());
        }

    }

}
