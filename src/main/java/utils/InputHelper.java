package utils;

import model.Producte;

import java.util.Scanner;

public final class InputHelper {

    private static InputHelper instance;
    public Scanner lector;

    private InputHelper() {
        lector = new Scanner(System.in);
    }

    public static InputHelper getInstance() {
        if (instance == null) {
            instance = new InputHelper();
        }
        return instance;
    }

    public int nextInt()
    {
        return Integer.parseInt(lector.nextLine());
    }

    public Producte askProducte() {

        //TODO:Preguntar dades del producte

        return new Producte("pomaP", "Pink Lady", "Poma Pink Lady envasada",
                0.2f, 1.0f);
    }
}