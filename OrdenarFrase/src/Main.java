import javax.swing.*;
import java.util.Random;

public class Main {

    private static final String[] EASY_VERSES = {
            "Dios es amor",
            "El Señor es mi pastor",
            "Ama a tu prójimo como a ti mismo"
            // Agrega más versículos fáciles aquí
    };

    private static final String[] MEDIUM_VERSES = {
            "Por sus frutos los conoceréis",
            "El que persevera hasta el fin, será salvo",
            "La fe sin obras es muerta"
            // Agrega más versículos de nivel medio aquí
    };

    private static final String[] HARD_VERSES = {
            "El Espíritu Santo os enseñará todas las cosas",
            "En el principio era el Verbo",
            "Porque de tal manera amó Dios al mundo"
            // Agrega más versículos difíciles aquí
    };

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        int level = 1;
        while (level <= 3) {
            String verse = getRandomVerse(level);
            String scrambledVerse = scrambleVerse(verse);

            long startTime = System.currentTimeMillis(); // Inicio del temporizador

            String userGuess = JOptionPane.showInputDialog(null,
                    "Versículo desordenado:\n" + scrambledVerse,
                    "Nivel " + level,
                    JOptionPane.QUESTION_MESSAGE);

            long endTime = System.currentTimeMillis(); // Fin del temporizador

            if (userGuess != null && userGuess.equalsIgnoreCase(verse)) {
                JOptionPane.showMessageDialog(null, "¡Correcto!");
                level++;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrecto. ¡Vuelves a iniciar!");
                level = 1;
            }

            // Verificar el tiempo (30 segundos)
            if (endTime - startTime > 30000) {
                JOptionPane.showMessageDialog(null, "¡Se acabó el tiempo! Reiniciando el nivel.");
                level = 1;
            }
        }
        JOptionPane.showMessageDialog(null, "¡Felicidades! Has completado todos los niveles.");
    }

    private static String getRandomVerse(int level) {
        Random random = new Random();
        String[] verses;
        switch (level) {
            case 1:
                verses = EASY_VERSES;
                break;
            case 2:
                verses = MEDIUM_VERSES;
                break;
            case 3:
                verses = HARD_VERSES;
                break;
            default:
                throw new IllegalArgumentException("Nivel no válido");
        }
        return verses[random.nextInt(verses.length)];
    }

    private static String scrambleVerse(String verse) {
        String[] words = verse.split(" ");
        Random random = new Random();
        for (int i = 0; i < words.length; i++) {
            int j = random.nextInt(words.length);
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
        }
        return String.join(" ", words);
    }
}
