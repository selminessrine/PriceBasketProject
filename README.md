# PriceBasketProject
Écrire un programme et les tests unitaires associés qui peuvent calculer le prix d'un panier de produits en tenant compte de certaines
 offres spéciales.
Les produits qui peuvent être achetés, ainsi que leurs prix normaux, sont :
• Soupe – 65p par boîte
• Pain – 80p par pain
• Lait – 1,30 £ par bouteille
• Pommes – 1,00 £ par sac

Offres spéciales actuelles :
• Les pommes bénéficient d'une réduction de 10 % sur leur prix normal cette semaine
• Achetez 2 boîtes de soupe et obtenez un pain à moitié prix

Le programme doit accepter une liste d'articles dans le panier et afficher le sous-total, les réductions des offres spéciales et le prix final.
L'entrée doit se faire via la ligne de commande sous la forme :
PriceBasket item1 item2 item3 ...
Par exemple :
PriceBasket Apples Milk Bread

Le résultat doit être affiché sur la console, par exemple :
Sous-total : 3,10 £
Pommes 10 % de réduction : -10p
Total : 3,00 £

Si aucune offre spéciale ne s'applique, le code doit afficher :
Sous-total : 1,30 £
(Aucune offre disponible)
Prix total : 1,30 £

Le code et la conception doivent répondre à ces exigences,
tout en étant suffisamment flexibles pour permettre des modifications futures de
la liste des produits et/ou des réductions appliquées.
