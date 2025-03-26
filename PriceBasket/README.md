# 🛒 PriceBasket - Calcul de Panier avec Promotions

## 📋 Description
Un programme Java qui calcule le prix total d'un panier de courses en appliquant des offres promotionnelles. Le projet inclut les tests unitaires pour garantir la fiabilité des calculs.

## 🛍️ Produits et Prix
| Article   | Prix Unitaire | Code |
|-----------|--------------|------|
| Soupe     | 65p          | `Soup` |
| Pain      | 80p          | `Bread` |
| Lait      | £1.30        | `Milk` |
| Pommes    | £1.00        | `Apples` |

## 🎁 Offres Spéciales
1. **Réduction Pommes** : 10% de réduction sur les pommes
    - Exemple : 2 pommes = £2.00 → £1.80 après réduction
2. **Offre Soupe + Pain** :
    - Achetez 2 soupes → 1 pain à moitié prix (40p de réduction)

## ▶️ Exécution du Programme
### Etape d'exécution
1) Configurer les arguments dans "Program arguments".

2) Exécuter le programme en cliquant sur "Run".

### Par exemple :
PriceBasket Apples Milk Bread

Le résultat doit être affiché sur la console, par exemple :

Sous-total : 3,10 £

Pommes 10 % de réduction : -10p

Total : 3,00 £

Si aucune offre spéciale ne s'applique, le code doit afficher :

Sous-total : 1,30 £

(Aucune offre disponible)

Prix total : 1,30 £