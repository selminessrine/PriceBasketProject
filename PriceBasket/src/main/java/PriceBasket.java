import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PriceBasket {

    // Prix des produits disponibles
    private static final Map<String, Double> PRIX_PRODUITS = Map.of(
            "Soup", 0.65,    // Soupe en boîte
            "Bread", 0.80,   // Pain
            "Milk", 1.30,    // Lait
            "Apples", 1.00   // Pommes
    );


 /*   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez les articles (séparés par des espaces) : ");
        String input = scanner.nextLine();

        String[] items = input.split(" ");

        // Appeler la méthode validateItems pour vérifier les articles
        validerArticles(items);

        afficherFacture(items);

        scanner.close();
    }*/

    // Valide que tous les articles existent
    static void validerArticles(String[] articles) {
        for (String article : articles) {
            if (!PRIX_PRODUITS.containsKey(article)) {
                System.out.println(article);
                throw new IllegalArgumentException("Article invalide dans le panier: " + article);
            }
        }
    }

    // Calcule le sous-total du panier
    static double calculerSousTotal(String[] articles) {
        return Arrays.stream(articles)
                .mapToDouble(PRIX_PRODUITS::get)
                .sum();
    }

    // Calcule les réductions applicables
    static Map<String, Double> calculerReductions(String[] articles) {
        Map<String, Double> reductions = new HashMap<>();
        Map<String, Long> compteArticles = Arrays.stream(articles)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Réduction sur les pommes (10%)
        long nbPommes = compteArticles.getOrDefault("Apples", 0L);
        if (nbPommes > 0) {
            reductions.put("Réduction pommes 10%", nbPommes * PRIX_PRODUITS.get("Apples") * 0.10);
        }

        // Réduction pain (moitié prix avec 2 soupes)
        long nbSoupes = compteArticles.getOrDefault("Soup", 0L);
        long nbPains = compteArticles.getOrDefault("Bread", 0L);
        if (nbSoupes >= 2 && nbPains > 0) {
            int painsEligibles = (int) Math.min(nbPains, nbSoupes / 2);
            reductions.put("Réduction pain 50%", painsEligibles * PRIX_PRODUITS.get("Bread") * 0.50);
        }

        return reductions;
    }

    // Affiche la facture détaillée
    static void afficherFacture(String[] articles) {
        double sousTotal = calculerSousTotal(articles);
        Map<String, Double> reductions = calculerReductions(articles);
        double reductionTotale = reductions.values().stream().mapToDouble(Double::doubleValue).sum();
        double total = sousTotal - reductionTotale;

        System.out.printf("Sous-total: £%.2f%n", sousTotal);

        if (!reductions.isEmpty()) {
            reductions.forEach((description, montant) ->
                    System.out.printf("%s: -%dp%n", description, (int)(montant * 100)));
        } else {
            System.out.println("(Aucune offre disponible)");
        }

        System.out.printf("Total: £%.2f%n", total);
    }

      public static void main(String[] args) {
        if (args.length == 0 || (args[0].equals("PriceBasket") && args.length == 1)) {
            System.out.println("Veuillez fournir des articles dans le panier");
            return;
        }

        // Gérer les formats "PriceBasket article1..." et "article1 article2..."
        String[] articles = args[0].equals("PriceBasket") ?
                Arrays.copyOfRange(args, 1, args.length) : args;

        validerArticles(articles);
        afficherFacture(articles);
    }
}
