import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class PriceBasketTest {


    /**
     * Teste le calcul du sous-total avec plusieurs articles
     * Cas standard : Pommes + Lait + Pain
     * Résultat attendu : £1.00 + £1.30 + £0.80 = £3.10
     */
    @Test
    public void testCalculerSousTotal() {
        String[] articles = {"Apples", "Milk", "Bread"};
        assertEquals(3.10, PriceBasket.calculerSousTotal(articles), 0.001);
    }

    /**
     * Teste la réduction de 10% sur les pommes
     * Cas : 2 pommes dans le panier
     * Réduction attendue : 2 * £1.00 * 10% = £0.20
     */
    @Test
    public void testCalculerReductions_PommesSeules() {
        String[] articles = {"Apples", "Apples"};
        var reductions = PriceBasket.calculerReductions(articles);
        Assertions.assertEquals(0.20, reductions.get("Réduction pommes 10%"), 0.001);
        Assertions.assertEquals(1, reductions.size());
    }
    /**
     * Teste l'offre spéciale "2 soupes = pain à moitié prix"
     * Cas : 2 soupes + 1 pain
     * Réduction attendue : £0.80 * 50% = £0.40
     */
    @Test
    public void testCalculerReductions_SoupeEtPain() {
        String[] articles = {"Soup", "Soup", "Bread"};
        var reductions = PriceBasket.calculerReductions(articles);
        Assertions.assertEquals(0.40, reductions.get("Réduction pain 50%"), 0.001);
        Assertions.assertEquals(1, reductions.size());
    }

    /**
     * Teste l'affichage de la facture sans réduction
     * Cas : seulement du lait dans le panier
     * Vérifie :
     * - Le sous-total (£1.30)
     * - Le message "Aucune offre disponible"
     * - Le total (£1.30)
     */
    @Test
    public void testAfficherFacture_SansReduction() {
        String[] articles = {"Milk"};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PriceBasket.afficherFacture(articles);

        String output = outContent.toString();
        assertTrue(output.contains("Sous-total: £1,30"));
        assertTrue(output.contains("(Aucune offre disponible)"));
        assertTrue(output.contains("Total: £1,30"));
    }

    /**
     * Teste la validation avec un article invalide
     * Cas : "Apples" + "ArticleInvalide"
     * Doit lever une IllegalArgumentException
     */
    @Test
    public void testValiderArticles_ArticleInvalide() {
        String[] articles = {"Apples", "ArticleInvalide"};
        assertThrows(IllegalArgumentException.class, () -> PriceBasket.validerArticles(articles));
    }

    /**
     * Teste le cas d'un panier vide
     * Vérifie :
     * - La validation ne génère pas d'exception
     * - Le sous-total est £0.00
     */
    @Test
    public void testPanierVide() {
        String[] articles = {};
        assertDoesNotThrow(() -> PriceBasket.validerArticles(articles));
        assertEquals(0.0, PriceBasket.calculerSousTotal(articles));
    }
}
