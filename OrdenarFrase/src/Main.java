import javax.swing.*;
import java.util.Random;

public class Main {

    public static boolean ganaste = false;

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
                ganaste = true;

            } else {
                JOptionPane.showMessageDialog(null, "Incorrecto. ¡Vuelves a iniciar!");
            }

            // Verificar el tiempo (30 segundos)
            if ( (level == 1) && ((endTime - startTime) > 30000)) {
                JOptionPane.showMessageDialog(null, "¡Se acabó el tiempo! Reiniciando el nivel.");
                level = 1;
            }
            else if ( (level == 2) && ((endTime - startTime) > 45000)) {
                JOptionPane.showMessageDialog(null, "¡Se acabó el tiempo! Reiniciando el nivel.");
                level = 1;
            }
            else if ( (level == 3) && ((endTime - startTime) > 60000)) {
                JOptionPane.showMessageDialog(null, "¡Se acabó el tiempo! Reiniciando el nivel.");
                level = 1;
            }
            //sube nivel
            if (ganaste) {
                level++;
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


    private static final String[] EASY_VERSES = {
            "Dios es amor 1_Juan_4:8C",
            "Jesús te ama Juan_3:16C",
            "Cree en el Señor Hechos_16:31A",
            "El amor nunca falla 1_Corintios_13:8B",
            "La fe es por el oir Romanos_10:17C",
            "El que ama ha nacido de Dios 1_Juan_4:7A",
            "Confiad en Jehová para siempre Isaías_26:4A",
            "En el principio creó Dios Génesis_1:1A",
            "El Señor es mi luz Salmo_27:1C",
            "No temas, yo estoy contigo Isaías_41:10C",
            "El amor de Cristo nos constriñe 2_Corintios_5:14A",
            "Cristo es la cabeza del cuerpo Colosenses_1:18A",
            "Alabad al Señor, porque él es bueno Salmos_136:1A",
            "No te dejaré ni te desampararé Josué_1:5C",
            "El temor del Señor es el principio de la sabiduría Proverbios_9:10A",
            "Dios es nuestro amparo y fortaleza Salmo_46:1A",
            "Guarda tu corazón con toda diligencia Proverbios_4:23A",
            "Jesús es el camino, la verdad y la vida Juan_14:6A",
            "La fe obra por el amor Gálatas_5:6B",
            "Dad gracias en todo 1_Tesalonicenses_5:18A",
            "La misericordia de Jehová es desde la eternidad Salmo_103:17A",
            "Bienaventurado todo aquel que teme a Jehová Salmo_128:1A",
            "El que guarda la ley es hijo prudente Proverbios_28:7A",
            "El fruto del Espíritu es amor, gozo, paz Gálatas_5:22C",
            "La palabra de Dios es viva Hebreos_4:12A",
            "No hay otro Dios sino Jehová Isaías_45:5A",
            "La paciencia es mejor que la arrogancia Eclesiastés_7:8B",
            "El camino de los justos es como la luz resplandeciente Proverbios_4:18A",
            "No os conforméis a este siglo Romanos_12:2A",
            "Dios es nuestro refugio y fortaleza Salmo_46:1A",
            "Buscad primeramente el reino de Dios Mateo_6:33A",
            "El que hace la voluntad de Dios, permanece para siempre 1_Juan_2:17A",
            "El temor de Jehová es el principio de la sabiduría Proverbios_1:7A",
            "Bendeciré a Jehová en todo tiempo Salmo_34:1A",
            "Bendito sea Jehová, porque ha oído la voz de mis ruegos Salmo_28:6A",
            "No nos cansemos, pues, de hacer bien Gálatas_6:9A",
            "El principio de la sabiduría es el temor de Jehová Proverbios_9:10A",
            "Cada palabra de Dios es pura Proverbios_30:5A",
            "Más valioso es tener sabiduría que el oro Proverbios_16:16A",
            "Bendito sea Jehová, la roca Salmo_144:1A",
            "Me diste a conocer los caminos de la vida Hechos_2:28A",
            "En Dios he confiado, no temeré Salmo_56:11A",
            "El amor cubrirá multitud de pecados 1_Pedro_4:8B",
            "Esforzaos, y cobrad ánimo Josué_1:6C",
            "Guarda tu lengua del mal Salmo_34:13A",
            "La gracia de nuestro Señor Jesucristo sea con vosotros Romanos_16:20A",
            "Santificado sea tu nombre Mateo_6:9A",
            "El camino del impío es abominación a Jehová Proverbios_15:9A",
            "Jehová es mi pastor Salmo_23:1A",
            "La paz de Dios, que sobrepasa todo entendimiento Filipenses_4:7B",
            "El amor no hace mal al prójimo Romanos_13:10A",
            "Clama a mí, y yo te responderé Jeremías_33:3C",
            "La fe es la certeza de lo que se espera Hebreos_11:1A"
    };

    private static final String[] MEDIUM_VERSES = {

            "Bienaventurado el hombre que no anduvo en consejo de malos Salmo_1:1A",
            "La fe sin obras es muerta Santiago_2:26B",
            "Guardaos de los falsos profetas Mateo_7:15C",
            "La palabra de Dios es lámpara a nuestros pies Salmo_119:105A",
            "Los cielos cuentan la gloria de Dios Salmo_19:1A",
            "El amor cubrirá multitud de pecados 1_Pedro_4:8B",
            "La palabra de Dios es más cortante que toda espada Hebreos_4:12A",
            "Jehová es mi fortaleza Salmo_18:2A",
            "En Dios confiaré, no temeré Salmo_56:4B",
            "El que guarda su palabra, en él verdaderamente el amor de Dios es perfecto 1_Juan_2:5A",
            "Al que cree, todo le es posible Marcos_9:23A",
            "Bendecid a los que os maldicen Romanos_12:14A",
            "La palabra de Dios es poderosa 1_Corintios_1:18A",
            "El amor de Cristo nos constriñe 2_Corintios_5:14A",
            "El que a Dios obedece, en él permanece el amor de Dios 1_Juan_2:5A",
            "Bendeciré a Jehová en todo tiempo Salmo_34:1A",
            "Todo aquel que invoque el nombre de Jehová, será salvo Joel_2:32A",
            "Mi roca, mi libertador Salmo_18:2A",
            "En Dios he confiado, no temeré Salmo_56:11A",
            "Dios es nuestro refugio y fortaleza Salmo_46:1A",
            "Jesús es el camino, la verdad y la vida Juan_14:6A",
            "La fe sin obras es muerta Santiago_2:26B",
            "Guarda tu lengua del mal Salmo_34:13A",
            "El amor es paciente, es benigno 1_Corintios_13:4A",
            "Bendito sea Jehová, la roca Salmo_144:1A",
            "Confiad en Jehová para siempre Isaías_26:4A",
            "No temeré mal alguno Salmo_23:4B",
            "Bendito sea Jehová, porque ha oído la voz de mis ruegos Salmo_28:6A",
            "Jesús es el Señor de señores Apocalipsis_17:14B",
            "El amor no hace mal al prójimo Romanos_13:10A",
            "Hágase tu voluntad Mateo_6:10A",
            "El amor es sufrido, es benigno 1_Corintios_13:4A",
            "El que perdura hasta el fin será salvo Mateo_24:13A",
            "Guarda tu corazón con toda diligencia Proverbios_4:23A",
            "Bienaventurado el hombre que confía en Jehová Jeremías_17:7A",
            "Temed a Dios, y dadle gloria Apocalipsis_14:7A",
            "El que come de este pan vivirá para siempre Juan_6:58A",
            "Bendecid a los que os persiguen Romanos_12:14A",
            "Bendito sea Jehová, la roca Salmo_144:1A",
            "Buscad primeramente el reino de Dios Mateo_6:33A",
            "El amor cubrirá multitud de pecados 1_Pedro_4:8B",
            "Jehová es mi pastor Salmo_23:1A",
            "La paz de Dios, que sobrepasa todo entendimiento Filipenses_4:7B",
            "El amor no hace mal al prójimo Romanos_13:10A",
            "Clama a mí, y yo te responderé Jeremías_33:3C",
            "La fe es la certeza de lo que se espera Hebreos_11:1A"

    };

    private static final String[] HARD_VERSES = {

            "El justo por su fe vivirá Romanos_1:17B",
            "El temor de Jehová es aborrecer el mal Proverbios_8:13B",
            "Sed hacedores de la palabra Santiago_1:22A",
            "Cristo es la cabeza del cuerpo Colosenses_1:18A",
            "No os conforméis a este siglo Romanos_12:2A",
            "Hijo, dame tu corazón Proverbios_23:26A",
            "Mas al que no obra, pero cree en el que justifica al impío, su fe le es contada por justicia Romanos_4:5B",
            "El amor es sufrido, es benigno 1_Corintios_13:4A",
            "Guarda tu corazón con toda diligencia Proverbios_4:23A",
            "Poned en práctica la palabra, y no seáis tan solo oidores Santiago_1:22A",
            "Alabad al Señor, porque él es bueno Salmos_136:1A",
            "Jehová es mi fortaleza y mi escudo Salmo_28:7A",
            "La fe sin obras es muerta Santiago_2:26B",
            "El Señor es mi luz y mi salvación Salmo_27:1A",
            "Hazme saber, oh Jehová, mi fin Salmo_39:4A",
            "Confiad en Jehová para siempre Isaías_26:4A",
            "Jesús es el Señor de señores Apocalipsis_17:14B",
            "Porque a todos los que le recibieron Juan_1:12B",
            "El que persevere hasta el fin será salvo Mateo_24:13A",
            "En quien también vosotros esperasteis, habiendo oído la palabra de verdad Efesios_1:13A",
            "Al que cree, todo le es posible Marcos_9:23A",
            "El que a Dios obedece, en él permanece el amor de Dios 1_Juan_2:5A",
            "El que persevere hasta el fin será salvo Mateo_24:13A",
            "El amor de Dios es para siempre Salmos_136:1A",
            "Cada palabra de Dios es pura Proverbios_30:5A",
            "Nuestro socorro viene de Jehová Salmo_124:8A",
            "Bendito sea Jehová en su santuario Salmo_150:1A",
            "Más valioso es tener sabiduría que el oro Proverbios_16:16A",
            "El que anda en integridad, anda confiado Proverbios_10:9A",
            "Jehová es mi luz y mi salvación Salmo_27:1A",
            "Hágase tu voluntad, así en la tierra como en el cielo Mateo_6:10A",
            "Temed a Dios, y dadle gloria Apocalipsis_14:7A",
            "El principio de la sabiduría es el temor de Jehová Proverbios_9:10A",
            "Buscad primeramente el reino de Dios Mateo_6:33A",
            "El que cree en el Hijo tiene vida eterna Juan_3:36A",
            "No hay otro Dios sino Jehová Isaías_45:5A",
            "Los mandamientos de Jehová son rectos Salmo_19:8A",
            "El amor de Dios es más grande que todo Efesios_3:19B",
            "El justo por su fe vivirá Romanos_1:17B",
            "El que guarda la ley es hijo prudente Proverbios_28:7A",
            "El que a Dios obedece, en él permanece el amor de Dios 1_Juan_2:5A",
            "Por tanto, los que están en Cristo son una nueva creación 2_Corintios_5:17A",
            "El amor de Cristo nos constriñe 2_Corintios_5:14A",
            "No os conforméis a este siglo Romanos_12:2A",
            "Todo aquel que invocare el nombre del Señor, será salvo Romanos_10:13A",
            "Mas al que no obra, pero cree en el que justifica al impío, su fe le es contada por justicia Romanos_4:5B",
            "Todo lo puedo en Cristo que me fortalece Filipenses_4:13A"
    };
}
