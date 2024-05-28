package modele;

import java.util.LinkedList;
import java.util.List;

public class GenerationFromages {

	public static void main(String[] args) {
		Fromages mesArticles = generationBaseFromages();
		System.out.println("Liste des fromages et articles :");
		System.out.println();
		System.out.println(mesArticles.toStringFromagesEtArticles());
		System.out.println();
		System.out.println("Liste des articles et de leurs stocks :");
		System.out.println();
		mesArticles.regenerationDuStock();
		System.out.println(mesArticles.toStringArticlesEtStock());
		System.out.println("Erreurs de saisie : ");
		System.out.println(mesArticles.verificationSaisie());
	}

	public static Fromages generationBaseFromages() {
		Fromages mesArticles = new Fromages();
		mesArticles.addFromages(GenerationFromageBrebis());
		mesArticles.addFromages(GenerationFromageChèvre());
		mesArticles.addFromages(GenerationFromageVache());
		mesArticles.regenerationDuStock();
		return mesArticles;
	}

	private static List<Fromage> GenerationFromageBrebis() {
		List<Fromage> fromagesAuLaitDeBrebis = new LinkedList<Fromage>();
		SaisieFromage[] fromages = { new SaisieFromage("Brebis au Bleu",
		        "brebis_au_bleu",
		        "Le brebis au bleu a une pâte très fondante, onctueuse fine et non friable. "
		                + "Son persillage est bleu vert, fonce, pouvant presenter des traces d’aiguilles. "
		                + "Une saveur franche, très typee, savoureuse, sans amertume. Un piquant doux et agreable. "
		                + "Pas de goût acide, de rance ou de saponification. Pas d’excès de sel. "
		                + "Un goût très puissant, aux arômes typiques de brebis, en font definitivement un fromage à decouvrir ! "
		                + "Son croûtage est clair, legèrement morge. Il est fabrique au lait pasteurise.",
		        TypeVente.A_LA_COUPE_AU_POIDS,
		        new String[] { "250 g", "500 g", "1 kg" },
		        new float[] { 8.2F, 16.4F, 32.8F }),
		        new SaisieFromage("Brebis au Fenugrec", "brebis_au_fenugrec",
		                "Cette tomme de brebis a une pâte douce et souple, et sa croûte est epaisse et friable de couleur brune. "
		                        + "Lors de sa fabrication le fenugrec est incorpore au lait, son goût est subtil mais très present.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg" },
		                new float[] { 8.2F, 16.4F, 32.8F }),
		        new SaisieFromage("Brebis Nature", "brebis_nature",
		                "Cette tomme de brebis au lait pasteurise vous offrira un doux goût de brebis, fruite et tendre "
		                        + "sa pâte douce et souple accompagnera votre plateau de fromages "
		                        + "mais pourra egalement être un ingredient dans plusieurs de vos recettes.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg" },
		                new float[] { 7.7F, 15.4F, 30.8F }),
		        new SaisieFromage("Brebis au Piment", "brebis_au_piment",
		                "Le Brebis au Piment est un fromage à decouvrir pour ceux qui aiment les fromages doux et raffines à la fois. "
		                        + "Le piment d’Espelette est incorpore au lait, son goût est subtil mais très present "
		                        + "ce qui donne à la tomme des arômes corses.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg" },
		                new float[] { 8.2F, 16.4F, 32.8F }),
		        new SaisieFromage("Brebis à la Truffe", "brebis_a_la_truffe",
		                "Cette tomme de brebis recouverte d'une croûte epaisse et friable de couleur brune, "
		                        + "renferme une pâte ferme à tendance blanche parsemee de morceaux de truffe. "
		                        + "Lors de sa fabrication la truffe est incorporee au lait, son goût est subtil mais très present. "
		                        + "Alliez plaisir et originalite, en faisant decouvrir la truffe associee aux saveurs du lait de brebis à vos convives.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg" },
		                new float[] { 10.2F, 20.4F, 40.8F }),
		        new SaisieFromage("Brin d'Amour Corse", "brin_d_amour_corse",
		                "Ce fromage au lait cru de brebis à pâte molle à croûte fleurie, propose un caractère corse qui s'exprime par sa croûte recouverte d'herbes, "
		                        + "de sarriettes et de romarin. Le Brin d'Amour offre un goût inimitable et une saveur parfumee et intense, il reste une merveille pour le palais. "
		                        + "C'est tout le caractère du fromage corse vous faisant voyager qui s'exprime dans ce mariage très heureux de lait de brebis et d’aromates. "
		                        + "La «Fleur du maquis» dont la pâte est fine et la couleur varie entre le rouge et le vert.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 8.5F, 16.8F }),
		        new SaisieFromage("Brique de Brebis Fermière",
		                "brique_de_brebis_fermiere",
		                "Cette brique est fabriquee à base de lait cru de brebis, elle dispose d’une croûte tendre de couleur ivoire plissee "
		                        + "et d’une pâte onctueuse et fondante de couleur blanche. "
		                        + "Lors de sa degustation vous decouvrirez des saveurs fruitees, legèrement salees avec des arômes de brebis, de noisette et de lait chaud. "
		                        + "Une authenticite qui revèle la diversite des pâturages du Tarn grâce à son herbage riche et floral. "
		                        + "Un vrai produit qui doit sa beaute simplement au fermier artisan. "
		                        + "Elle est fondante, douce et persistante, prend du caractère sans agressivite en s’affinant avec un petit goût de noisette.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 7.89F }),
		        new SaisieFromage("L'Encalat", "l_encalat",
		                "D'origine du Larzac, ce fromage cremeux au delicieux goût de brebis est incontournable. "
		                        + "Sa texture en bouche est jugee fondante voire très fondante. C'est un produit doux à la saveur salee plutôt faiblement prononcee. "
		                        + "L'Encalat est un fromage à pâte molle fleurie. Un affinage en cave de 2 semaines, offre une texture coulante et à cœur plus pâteuse. "
		                        + "Des saveurs à decouvrir de toute urgence !!",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 8.4F }),
		        new SaisieFromage("Ossau Iraty", "ossau_iraty",
		                "Ce fromage au lait pasteurise de brebis dispose d’une croûte dure de couleur beige orange à gris clair à l’exterieur, et d’une pâte lisse "
		                        + "de couleur ivoire à l’interieur presentant de petites ouvertures. En bouche, l’Ossau Iraty developpera des saveurs fruitees avec des notes "
		                        + "de noisette et de lait de brebis. De consistance onctueuse, ferme et dure, l'Ossau Iraty, d'origine Basque, se deguste en amuse bouche, "
		                        + "en casse croute, ou même en condiment. Ses arômes sont fruites et long en bouche.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg",
		                        "1/2 Tomme (2.1 kg environ)" },
		                new float[] { 8.5F, 16.99F, 33.99F, 57.11F }),
		        new SaisieFromage("Ossau Iraty - Saint Michel",
		                "ossau_iraty__saint_michel",
		                "Au lait cru de brebis, l'Ossau Iraty Saint-Michel dispose d’une croûte dure de couleur brune à l’exterieur, "
		                        + "et d’une pâte lisse legèrement cassante de couleur jaune à l’interieur. En bouche, elle developpera des saveurs fruitees relevees "
		                        + "de notes de lait de brebis et de legères notes de noisette. ",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg" },
		                new float[] { 9.25F, 18.5F, 36.99F }),
		        new SaisieFromage("Roquefort l'Arbas", "roquefort_l_arbas",
		                "Une saveur persillee, plutôt acide et un peu fruite, c’est ce que vous proposera ce fromage au lait cru de brebis. "
		                        + "Le Roquefort de l'Arbas est un fromage type de couleur blanc crème ou ivoire à l’exterieur à pâte fondante et onctueuse, "
		                        + "et parfumee à l’interieur avec des veines bleu-vert bien reparties et marbre.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg" },
		                new float[] { 7.25F, 14.5F, 28.99F }),
		        new SaisieFromage("Roquefort Baragnaudes",
		                "roquefort_baragnaudes",
		                "Fromage au lait cru de brebis, le Roquefort Baragnaudes presente une pâte fondante et onctueuse de couleur blanche ivoire pâle, "
		                        + "avec des veines bleues intenses bordant de nombreuses et larges cavites. "
		                        + "D’une odeur delicate de lait de brebis elle s’accompagne d’un goût puissant aux arômes mielles  qui ravira tous vos convives. "
		                        + "Fin et onctueux, le Roquefort des Caves Baragnaudes invite à un veritable voyage des sens. "
		                        + "Avec des senteurs de sous-bois et de champignons, il developpe un bouquet aromatique raffine qui, porte par une texture onctueuse, "
		                        + "se diffuse lentement pour terminer par des notes noisettes et beurrees.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg" },
		                new float[] { 9.75F, 19.5F, 39F }),
		        new SaisieFromage("Roquefort Carles", "roquefort_carles",
		                "Une saveur typiquement persillee, plutôt acide et un peu fruite, c’est ce que vous proposera ce fromage au lait cru de brebis. "
		                        + "Le Roquefort Carles est un fromage type de couleur blanc crème ou ivoire à l’exterieur à pâte fondante onctueuse, cremeuse et parfumee "
		                        + "à l’interieur. La maison Carles est une entreprise familiale creee en 1927, qui depuis trois generations, produit un roquefort d’exception, "
		                        + "artisanal et de grande qualite. C'est un melange reussi d'exigence, de tradition et de modernite qui fait du Roquefort Carles, "
		                        + "un grand moment gustatif.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg" },
		                new float[] { 10.95F, 21.9F, 43.8F }),
		        new SaisieFromage("Roquefort Papillon", "roquefort_papillon",
		                "Fromage au lait cru de brebis, le Roquefort Papillon presente une pâte fondante et onctueuse de couleur blanche à ivoire pâle, "
		                        + "avec des veines bleues intenses bordant de nombreuses et larges cavites. "
		                        + "D’une odeur delicate de lait de brebis elle s’accompagne d’un goût puissant et sale qui ravira tous vos convives. "
		                        + "Depuis 1906, les fromageries PAPILLON façonnent un Roquefort authentique ne de la rencontre des hommes et de la nature. "
		                        + "Un lien plus que centenaire, dont la notoriete du produit resulte de la confiance envers un savoir-faire naturel, une tradition, un goût, "
		                        + "qui le rendent inimitable. ",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg" },
		                new float[] { 9.25F, 18.5F, 36.99F }),
		        new SaisieFromage("Tomme d'Estaing", "tomme_d_estaing",
		                "L’ESTAING est un fromage au lait cru de brebis, à pâte pressee avec une croûte fleurie. Sa pâte très souple, favorise en bouche "
		                        + "l’expression de tous les parfums du lait de Brebis. Cette tomme de brebis, au lait cru est produite sur le Larzac, et dispose d'un affinage "
		                        + "en cave entre 2 à 6 mois. Sa texture donne un produit qui ne pourra que ravir votre palais. Des saveurs inoubliables...",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg" },
		                new float[] { 8.99F, 17.99F, 35.99F }),
		        new SaisieFromage("Tomme Le Lou Bren", "tomme_le_lou_bren",
		                "D'une couleur de croûte orangee, le Lou Bren peut avoir des tâches grises. La pâte est souple et de couleur ivoire avec quelques fines ouvertures. "
		                        + "Son odeur est fine et legère rappelant la brebis. Sa saveur est florale et acidulee. "
		                        + "D'origine du Larzac, le Lou Bren est affine en cave humide ce qui donnera une souplesse et un parfum de la flore des Causses, "
		                        + "en restant toujours doux en bouche.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 10.3F, 18.45F }) };
		for (SaisieFromage s : fromages) {
			fromagesAuLaitDeBrebis.add(s.builderFromage());
		}
		for (Fromage f : fromagesAuLaitDeBrebis) {
			f.updateTypeFromage(TypeLait.BREBIS);
		}
		return fromagesAuLaitDeBrebis;
	}

	private static List<Fromage> GenerationFromageChèvre() {
		List<Fromage> fromagesAuLaitDeChèvre = new LinkedList<Fromage>();
		SaisieFromage[] fromages = { new SaisieFromage(
		        "Bouton de Culotte fermier", "bouton_de_culotte_fermier",
		        "Au lait cru de chèvre, ce petit fromage presentera une croûte de couleur jaune pâle qui deviendra brunâtre en s’affinant, "
		                + "renfermant une pâte tendre de couleur blanche qui deviendra cassante à maturite. "
		                + "Mais il ne faudra pas se fier à son apparence, malgre sa petite taille celui-ci vous offrira un goût prononce caprin "
		                + "accompagne d’une forte odeur de chèvre.",
		        TypeVente.A_L_UNITE, new String[] { "" }, new float[] { 3.8F }),
		        new SaisieFromage("Pouligny Saint Pierre",
		                "pouligny_saint_pierre",
		                "Pyramide au lait cru de chèvre, ce fromage vous offrira une croûte fine recouverte de legères moisissures blanches et bleutees renfermant "
		                        + "une pâte ferme et souple de couleur ivoire. Ce fromage fermier vous presentera un goût de noisette accompagne d’une legère odeur caprine "
		                        + "qui sera apprecie par tous vos convives. Le Pouligny Saint Pierre presente une etendue de saveurs lui permettant d'être deguste par un large "
		                        + "public. Il est un produit authentiquement fermier et est fabrique dans le Berry.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 8.9F }),
		        new SaisieFromage("Rocamadour", "rocamadour",
		                "Petit fromage au lait cru de chèvre, il se presentera en forme d’un palet proposant une croûte fine et fondante de couleur ivoire renfermant "
		                        + "une pâte onctueuse et souple de couleur blanche. Le Rocamadour sera un delice pour vos papilles vous offrant des saveurs de chèvre, "
		                        + "de crème et de noisette releve d’un peu de sel, le tout accompagne d’une legère odeur caprine. En bouche, le Rocamadour tout en douceur "
		                        + "fond contre le palais, suivant les goûts, on peut l'apprecier cremeux ou sec avec des arômes plus puissants.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 2.9F }),
		        new SaisieFromage("Persille de Chèvre", "persille_de_chevre",
		                "La particularite de ce fromage est qu'il ressemble à un bleu, alors qu'il est fabrique à partir de lait pasteurise de chèvre. "
		                        + "Fromage original à la texture fondante et grasse du roquefort, il a un goût franc et puissant avec une saveur fine et prononcee. "
		                        + "Le fromage doit fondre sous le palais en laissant une etonnante sensation de salinite. "
		                        + "Laissez-le s'affiner et il pourra être très très fort !",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g" },
		                new float[] { 10.95F, 21.9F }),
		        new SaisieFromage("Tomme de Chèvre", "tomme_de_chevre",
		                "D’un goût subtil et d’une personnalite tout en douceur et de finesse, ce fromage au lait pasteurise de chèvre à pâte pressee non cuite "
		                        + "ravivera vos papilles gustatives. La Tomme de Chèvre offre une pâte ferme, fondante en bouche qui relèvera une saveur typique et prononcee "
		                        + "du lait de chèvre avec des arômes de fruits secs. Fromage traditionnel, la degustation de la Tomme de Chèvre en tranches fines allie "
		                        + "le charme de la rusticite à la decouverte d'arômes delicats, elle pourra être utilisee egalement en raclette.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg",
		                        "1/2 Tomme (2 kg environ)" },
		                new float[] { 8.2F, 16.4F, 32.8F, 55.76F }),
		        new SaisieFromage("Tomme de Chèvre Thym Miel",
		                "tomme_de_chevre_thym_miel",
		                "Fromage originaire de la Hollande, la degustation de cette tomme de chèvre vous offrira des saveurs à la fois delicates de miel et de caramel, "
		                        + "et prononcees de thym et d'arômes de chèvre. En plus de son goût subtil, cette tomme est recouverte d'une croûte fleurie de thym "
		                        + "lavee au caramel, celle-ci presente un melange de couleur differente, et renferme une pâte tendre à ferme de couleur ivoire "
		                        + "mouchetee de thym.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 kg" },
		                new float[] { 8.95F, 17.9F, 35.8F }),
		        new SaisieFromage("Bûchette Fermière", "buchette_fermiere",
		                "Delivrant une onctuosite rare, au lait cru de chèvre, nos fromages presentent une croûte fine cendree renfermant une pâte souple, "
		                        + "tendre et homogène de couleur blanche. Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives. "
		                        + "Cette Buchette Fermière est produite par nos soins sous le nom de l'EARL du Chemin Fleury, une ferme familiale situee à Louzy "
		                        + "dans les Deux- Sèvres. ",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 3.99F }),
		        new SaisieFromage("Cabris Fermier", "cabris_fermier",
		                "Produit par nos soins sous le nom de l'EARL Chemin Fleury, nous respectons le savoir faire de cette grande region, tout en se distinguant "
		                        + "par une texture et un goût qui lui sont bien specifiques. Au lait cru de chèvre, nos fromages presentent une croûte fine salee au sel blanc "
		                        + "ou cendre renfermant une pâte souple, tendre et homogène de couleur blanche. "
		                        + "Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives.",
		                TypeVente.A_L_UNITE_PlUSIEURS_CHOIX,
		                new String[] { "Moelleux cendre - Jeune et doux",
		                        "Moelleux blanc - Jeune et doux" },
		                new float[] { 3.39F }),
		        new SaisieFromage("Chabis Fermier", "chabis_fermier",
		                "Au lait cru de chèvre, nos fromages presentent une croûte fine salee au sel blanc ou cendree renfermant une pâte souple, "
		                        + "tendre et homogène de couleur blanche. Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives. Le Chabis est "
		                        + "un habile melange de saveurs : legèrement sucre avec une pointe de sel, delicatement acide dans un arôme de lait. "
		                        + "Fabrique en Poitou à l'EARL du chemin fleury, c’est un excellent fromage de tradition !",
		                TypeVente.A_L_UNITE_PlUSIEURS_CHOIX,
		                new String[] { "Moelleux cendre - Jeune et doux",
		                        "Moelleux blanc - Jeune et doux" },
		                new float[] { 3.99F }),
		        new SaisieFromage("Chabis frais aromatise Fermier",
		                "chabis_frais_aromatise_fermier",
		                "Produit par nos soins sous le nom de l'EARL Chemin Fleury, au lait cru de chèvre, nos Chabis frais aromatises presentent une pâte tendre "
		                        + "moelleuse et fondante en bouche de couleur blanche recouverte de differentes epices : echalotes, ails et fines herbes ou encore poivres "
		                        + "qui lui confère un goût exquis. Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives.",
		                TypeVente.A_L_UNITE_PlUSIEURS_CHOIX,
		                new String[] { "Echalotes", "Ail et fines herbes",
		                        "Poivres" },
		                new float[] { 3.99F }),
		        new SaisieFromage("Coeur de chèvre", "coeur_de_chevre",
		                "Au lait cru de chèvre, nos fromages presentent une croûte fine salee au sel blanc ou cendre renfermant une pâte souple, tendre et homogène "
		                        + "de couleur blanche. Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives. Le coeur de chèvre est un fromage "
		                        + "de chèvre cremeux, son goût peut se reveler aussi bien doux que corse, tant sa force varie en rapport immediat avec son degre d’affinage. "
		                        + "Il est conçu par l'EARL du Chemin Fleury.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 3.99F }),
		        new SaisieFromage("Crottin Fermier", "crottin_fermier",
		                "Au lait cru de chèvre, nos fromages presentent une croûte fine salee au sel blanc renfermant une pâte souple, tendre et homogène de couleur "
		                        + "blanche. Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives. Issu du EARL du Chemin Fleury, ce fromage a "
		                        + "une texture très tendre et moelleuse quand il est jeune. Il se durcit avec le temps pour devenir très sec. "
		                        + "Il developpe pleins d’arômes avec un goût de chèvre marques au depart.\r\n",
		                TypeVente.A_L_UNITE_PlUSIEURS_CHOIX,
		                new String[] { "moelleux (jeune et doux)",
		                        "affine (très prononce)" },
		                new float[] { 3.90F }),
		        new SaisieFromage("Crottin frais aromatise Fermier",
		                "crottin_frais_aromatise_fermier",
		                "Produit par nos soins, sous le nom de l'EARL Chemin Fleury, au lait cru de chèvre, nos crottins frais aromatises presentent une pâte très tendre "
		                        + "et moelleuse de couleur blanche recouverte de differentes epices : echalotes, ails et fines et herbes ou encore poivre. "
		                        + "Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives.",
		                TypeVente.A_L_UNITE_PlUSIEURS_CHOIX,
		                new String[] { "Poivre", "Echalotes",
		                        "Ail et fines herbes" },
		                new float[] { 2.99F }),
		        new SaisieFromage("Faisselle de chèvre 500g",
		                "faisselle_de_chevre_500g",
		                "La veritable faisselle est le caille de lait de chèvre frais mis à egoutter dans une faisselle puis dans un pot pour garder un peu de son "
		                        + "petit lait. Son goût varie selon les saisons. D'une saveur douce, elle prend au printemps un parfum different avec l'herbe verte et fraîche "
		                        + "des champs. Notre faisselle maison est appreciee pour sa saveur fraîche et sa legèrete. "
		                        + "Au petit dejeuner, en en-cas ou au dessert, la faisselle se consomme à toutes heures et vous apportera un peu de fraîcheur.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 3.99F }),
		        new SaisieFromage("Galet de chèvre", "galet_de_chevre",
		                "Produit dans les Deux-Sèvres par l'EARL Chemin Fleury, au lait cru de chèvre, le Galet de chèvre presente une croûte fine salee au sel blanc "
		                        + "renfermant une pâte souple, tendre et homogène de couleur blanche. Ce fromage vous offrira un doux goût de chèvre dont les notes caprines "
		                        + "seront plus prononcees en s'affinant.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 3.99F }),
		        new SaisieFromage("Long Fermier", "long_fermier",
		                "Produit par nos soins sous le nom de l'EARL Chemin Fleury, au lait cru de chèvre, le long fermier met en valeur toutes les qualites du lait, "
		                        + "sa legère acidite, son discret goût de sel, et sa douceur se developpent sous le palais. Les couleurs et la texture sont agreables et "
		                        + "laissent un long arrière-goût en bouche.",
		                TypeVente.A_L_UNITE_PlUSIEURS_CHOIX,
		                new String[] { "Blanc Moelleux - jeune et doux",
		                        "Cendre Moelleux - jeune et doux" },
		                new float[] { 5.59F }),
		        new SaisieFromage("Le Trio Apero", "le_trio_apero",
		                "Produit par nos soins, sous le nom de l'EARL Chemin Fleury, au lait cru de chèvre, nos crottins frais aromatises presentent une pâte très tendre "
		                        + "et moelleuse de couleur blanche recouverte de differentes epices : echalotes, ails et fines et herbes ou encore poivre. "
		                        + "Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 6.99F }),
		        new SaisieFromage("Ovale Fermier", "ovale_fermier",
		                "Au lait cru de chèvre, ce fromage a une croûte legèrement cendree. Sa pâte est d'un blanc pur. Elle reste ferme tout en etant souple "
		                        + "et moelleuse à la fois sous le doigt. Ce fromage degage une odeur subtile et agreable. Leurs doux goûts de chèvre uniques raviront "
		                        + "vos papilles et celles de vos convives. Une saveur exprimee par la douceur d'un lait riche et cremeux.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 3.99F }),
		        new SaisieFromage("Pave Fermier", "pave_fermier",
		                "Au lait cru de chèvre, ce fromage presente une croûte fine salee au sel cendre renfermant une pâte souple, tendre et homogène de couleur blanche. "
		                        + "Son doux goût de chèvre unique ravira vos papilles et celles de vos convives. En forme de pave, il est fabrique à la Ferme du Chemin Fleury "
		                        + "dans les Deux-Sèvres. Son expression buccale est très presente avec une montee rapide et pleine de delicatesse.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 3.99F }),
		        new SaisieFromage("Pyramide Fermière", "pyramide_fermiere",
		                "La pyramide fermière est un fromage de chèvre cremeux, son goût peut se reveler aussi bien doux que corse, tant sa force varie en rapport "
		                        + "immediat avec son degre d'affinage. Fabriquee par nos soins sous le nom de l'EARL chemin Fleury, la pyramide est un fromage au lait cru de "
		                        + "chèvre, elle presente une croûte fine salee au sel cendre renfermant une pâte souple, tendre et homogène de couleur blanche.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 5.49F }),
		        new SaisieFromage("Sein Fleury", "sein_fleury",
		                "Au lait cru de chèvre, le Sein Fleury presente une croûte fine salee au sel cendre renfermant une pâte souple, tendre et homogène de "
		                        + "couleur blanche. Son doux goût de chèvre unique ravira vos papilles et celles de vos convives. Produit par des producteurs locaux de "
		                        + "EARL du chemin fleury, il respecte le savoir faire de cette grande region, tout en se distinguant par une texture et un goût qui lui "
		                        + "sont bien specifique.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 4.2F }),
		        new SaisieFromage("Selle Fleury", "selle_fleury",
		                "Produit dans les Deux-Sèvres par l'EARL Chemin Fleury, au lait cru de chèvre, le Selle Fleury presente une croûte fine salee au sel cendre "
		                        + "renfermant une pâte souple, tendre et homogène de couleur blanche. Ce fromage vous offrira un doux goût de chèvre dont les notes caprines "
		                        + "seront plus prononcees en s'affinant.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 3.99F }) };
		for (SaisieFromage s : fromages) {
			fromagesAuLaitDeChèvre.add(s.builderFromage());
		}
		for (Fromage f : fromagesAuLaitDeChèvre) {
			f.updateTypeFromage(TypeLait.CHEVRE);
		}
		return fromagesAuLaitDeChèvre;
	}

	private static List<Fromage> GenerationFromageVache() {
		List<Fromage> fromagesAuLaitDeVache = new LinkedList<Fromage>();
		SaisieFromage[] fromages = { new SaisieFromage("Abondance", "abondance",
		        "De fabrication fermière, et d'un affinage de 10 semaines en caves avec des soins de frottage, cette tomme degage une odeur de cave et offre "
		                + "un fondant en bouche developpant un goût de noisette. Ce fromage au lait cru de vache se presente sous la forme d’une meule recouverte "
		                + "d’une croûte lisse de couleur brune à legèrement grise, renfermant une pâte souple et fondante de couleur ivoire à jaune "
		                + "l'Abondance presente quelques trous. Elle vous offrira des saveurs fruitees relevees d’une legère pointe de sel avec un parfum de noisette.",
		        TypeVente.A_LA_COUPE_AU_POIDS,
		        new String[] { "250 g", "500 g", "1 Kg" },
		        new float[] { 5.52F, 11.04F, 22.09F }),
		        new SaisieFromage("Appenzeller", "appenzeller",
		                "Le fromage Appenzeller est l’une des plus grandes specialites fromagères suisses. Savoureux et raffine, il est une valeur sûre et "
		                        + "est apprecie depuis plus de 700 ans. C'est un fromage au lait cru de vache à pâte pressee demi-cuite, typique au goût corse, "
		                        + "il doit son goût unique au traitement à la saumure aux herbes. il vous offrira un goût raffine et aromatise avec une pâte tendre "
		                        + "recouverte d’une croûte aux tons brun et rouge. L’Appenzeller d’un caractère affirme restera un mystère mais un delice pour nos papilles.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 8.9F, 17.8F, 35.6F }),
		        new SaisieFromage("Beaufort d'Alpage", "beaufort_d_alpage",
		                "Considere comme le «Prince des Gruyères», ce fromage au lait cru de vache à pâte pressee cuite, vous offrira un parfum fruite et une "
		                        + "onctuosite accompagne d’un goût de noisette très prononce. Fromage savoyard AOC, le Beaufort se presente d’une pâte ferme de couleur ivoire "
		                        + "à jaune pâle, recouvert d’une croûte lisse d’une couleur jaune orangee. Il reste un fromage au goût type sans pour autant être fort.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 12F, 24F, 48F }),
		        new SaisieFromage("Bleu d'Auvergne", "bleu_d_auvergne",
		                "Fromage au lait cru de vache à pâte persillee, ce Bleu d’Auvergne dispose d’un goût affirme et d’une texture fondante. "
		                        + "Celui-ci vous offrira une pâte de couleur blanche à ivoire parsemee de moisissures bleu-vert, et une croûte fine naturelle fleurie "
		                        + "qui peut presenter des reflets de la même teinte. Ce bleu type mais pas fort sera delicieux en fin de repas.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 6.7F, 13.4F, 26.8F }),
		        new SaisieFromage("Bleu de Gex", "bleu_de_gex",
		                "Fromage au lait cru de vache, il dispose d’une croûte fine, sèche et legèrement farineuse de couleur blanche à jaune et renferme "
		                        + "une pâte souple, onctueuse et legèrement friable de couleur blanche à ivoire presentant des veines bleues-vertes. "
		                        + "Le Bleu Gex vous offrira un goût leger et doux accompagnee d’une saveur de noisette et de champignon, le tout releve d’une legère amertume "
		                        + "et d’une pointe de sel. ",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 5.6F, 11.2F, 22.4F }),
		        new SaisieFromage("Bleu des Causses", "bleu_des_causses",
		                "Principalement fabrique en Aveyron à Rodez et affine dans les caves de Peyrelade dans les Gorges du Tarn, ce fromage est en quelque sorte "
		                        + "la version au lait de vache du Roquefort. En effet voisin de celui-ci avec son histoire, il est un fromage au lait pasteurise de vache "
		                        + "à pâte persillee. Il a une qualite dans sa texture à la fois tendre et fondante et il propose une saveur alliant douceur et puissance. "
		                        + "Le Bleu des Causses est un bouquet raffine qui offre une richesse aromatique à consommer toute l’annee de l’aperitif au dessert. "
		                        + "Son goût cremeux vous surprendra !",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 5.99F, 11.98F, 23.96F }),
		        new SaisieFromage("Boulette d'Avesnes", "boulette_d_avesnes",
		                "Facilement reconnaissable à sa forme conique et irregulière, la Boulette d'Avesnes fermière est un fromage au lait cru de vache de "
		                        + "couleur rouge brun. Elle est fabriquee à partir de brisures de maroilles frais enrichi de persil, d’estragon et de clou de girofle, "
		                        + "puis recouverte de paprika. Son odeur et son goût releve et savoureux sont incomparables.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 6.5F }),
		        new SaisieFromage("Brie aux truffes", "brie_aux_truffes",
		                "Couvert d’un blanc duveteux, d’une croûte fine pigmentee parfois de tâches rouges et proposant une pâte coulante. "
		                        + "L’arôme à la fois fin et puissant de la truffe se delayant dans la pâte dense et les touches noisetees du Brie, le tout lie par une "
		                        + "preparation cremeuse à souhait. C’est un fromage pour les amateurs de saveurs prononcees. Specialite de la maison des fromages, "
		                        + "le Brie Truffe est un delice, fabrique par nos soins selon des savoirs-faire secrets, le mariage du Brie et de la Truffe est "
		                        + "un chef d’œuvre gastronomique ! Nous vous aurons prevenu : le goûter c'est l'adopter !",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 15F }),
		        new SaisieFromage("Brie de Meaux", "brie_de_meaux",
		                "Situee au cœur de verts pâturages de la Meuse, la Fromagerie Donge est la reference en matière de Brie de Meaux AOC depuis trois generations. "
		                        + "Couvert d’un blanc duveteux, d’une croûte fine pigmentee parfois de tâches rouges et proposant une pâte jaune paille clair onctueuse, "
		                        + "souple mais non coulante, le Brie de Meaux nous offre une saveur fine avec un goût de noisette. C’est un fromage pour les amateurs de "
		                        + "saveurs prononcees.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 5.99F, 11.98F, 23.96F }),
		        new SaisieFromage("Brie de Melun", "brie_de_melun",
		                "Plus petit que son grand frère «le Brie de Meaux», il a cependant plus de caractère. Ce fromage au lait cru de vache vous offrira une pâte "
		                        + "souple de couleur jaune d’or à l’interieur, et une croûte fleurie blanche parsemee de stries ou de taches rouges ou brunes à l’exterieur. "
		                        + "Le Brie de Melun vous proposera une saveur très fruitee avec un leger goût de noisette accompagnee d’une odeur du terroir qui le rendra "
		                        + "indispensable sur un plateau de fromages. Il pourra aussi entrer dans la confection de specialites regionales dont la plus connue, "
		                        + "la croûte au brie.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 9.15F, 18.3F, 36.6F }),
		        new SaisieFromage("Brillat Savarin", "brillat_savarin",
		                "Portant le nom de l'ancien gastronome, ce double crème à la forme d'un disque au lait cru de vache est un fromage à pâte molle à croûte "
		                        + "fleurie cotonneuse et blanche. Le Brillat Savarin se mange jeune et bien frais, mais il conservera sa douceur au palais en s’affinant et "
		                        + "vous offrira en bouche des arômes de bois et de noisette avec un cœur de crème aux saveurs douces legèrement acidulees.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 7.5F, 14.5F }),
		        new SaisieFromage("Camembert de Buffone", "Camembert-Bufflonne",
		                "Fromage au lait pasteurise de Bufflonne, il se presente sous la forme d’un petit camembert recouvert d'une fine croûte fleurie blanche, "
		                        + "renfermant un doux cœur cremeux",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 7.5F }),
		        new SaisieFromage("Camembert de Normandie AOP",
		                "camembert_de_normandie_aop",
		                "Connu comme le fromage français par excellence, et de valeur sûre, il ne sera jamais de trop sur un plateau. Le Camembert de Normandie "
		                        + "vous offrira une saveur fruitee avec un goût legèrement sale qui s’accentuera en s’affinant. "
		                        + "Moule à la louche il a une forme regulière et  une surface striee, sa pâte est lisse et souple de couleur ivoire à jaune clair "
		                        + "lorsqu'il est affine \"à cœur\". Demi-affine, il reste au centre de la pâte un \"noyau\" blanc central de 2 mm. "
		                        + "Il est obligatoirement commercialise dans une boite en bois.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 5.6F }),
		        new SaisieFromage("Camembert Gaslondes", "camembert_gaslondes",
		                "Parfait pour les amateurs de camembert fort, le Gaslondes très moelleux vous proposera un goût et un parfum prononce sans piquant. "
		                        + "Fromage au lait cru de vache, il dispose d’une croûte striee et duvetee de blanc legèrement pigmentee de rouge en fonction de l’affinage, "
		                        + "et qui renferme une pâte souple de couleur blanche à jaune crème. Le Camembert Gaslondes vous apportera des saveurs fruitees accompagnees "
		                        + "d’arômes laitiers.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 7.3F }),
		        new SaisieFromage("Chaource fermier", "chaource_fermier",
		                "Excellent toute l'annee, le Chaource fermier est très apprecie pour sa pâte. Fromage au lait cru de vache, il propose une croûte blanche "
		                        + "et duveteuse à l’exterieur, et une pâte fine et fondante à l’interieur accompagnee d’arômes de crème et de champignons frais, "
		                        + "releves par une legère pointe de sel. Sa saveur douce et fruitee de noisette sera delicieuse à deguster en aperitif avec un porto "
		                        + "ou même un champagne. Un delice de raffinement.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 6.9F }),
		        new SaisieFromage("Comte 18 mois", "comte_18_mois",
		                "Fromage d'excellence, au lait cru de vache, le Comte est un fromage à pâte pressee cuite et une texture souple et ferme à la fois. "
		                        + "Le Comte reste un fromage d’exception qui se caracterise par une grande diversite aromatique. "
		                        + "Il presente des arômes à dominantes fruites en ete, et torrefies avec des nuances de noisettes en hiver. Avant tout une histoire d'hommes "
		                        + "profondement attaches aux valeurs de terroir et à celles du Comte, les Maîtres de cave Marcel Petite selectionne leurs Comtes en "
		                        + "recherchant la meilleure qualite de finesse, subtilite et intensite du goût. Un delice dans vos plateaux !",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 8.95F, 17.9F, 35.8F }),
		        new SaisieFromage("Comte special de Noël",
		                "comte_special_de_noel",
		                "Ce comte est un produit très rare à obtenir par notre partenaire PETITE. En effet, il est très convoite pour toutes ses qualites. "
		                        + "Fromage d'excellence, au lait cru de vache, ce Comte à pâte pressee cuite d'une texture souple et ferme à la fois affine 28 mois, "
		                        + "vous presentera une pâte plus jaune parsemee de mini-cristaux (appele tyrosine) signe d'un affinage parfait et reussi. "
		                        + "Le Comte reste un fromage d’exception qui se caracterise par une grande diversite aromatique. "
		                        + "Il presente des arômes à dominantes fruites en ete, et torrefies avec des nuances de noisettes en hiver.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 11.5F, 23F, 46F }),
		        new SaisieFromage("Coulommiers", "coulommiers",
		                "Grand frère du Camembert et petit frère du Brie, ce fromage a maintenant une place de choix dans les familles. "
		                        + "Les coulommiers fermiers se font malheureusement rares, mais nous vous le proposons. Fromage au lait cru de vache, "
		                        + "il est recouvert d’une fine croûte duvetee de blanc qui renferme une pâte jaune claire avec un cœur blanc. "
		                        + "Le Coulommiers vous offrira un moelleux et une onctuosite accompagnes d’une saveur d’amande douce et d’une odeur de champignons frais, "
		                        + "de crème et de lait chaud.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 5.5F, 10.99F }),
		        new SaisieFromage("Cure Nantais", "cure_nantais",
		                "Connu comme le \"fromage nantais\", il a un parfum captivant et immanquable. On peut le deguster toute l'annee. "
		                        + "Il presente un goût de terroir prononce. Il est propose froid ou chaud, avec des fruits ou du poireau. C'est un fromage fort, sa pâte est "
		                        + "souple, cremeuse et percee de quelques petits trous, elle revèle une saveur de lard fume et un final epice. "
		                        + "La croûte est rugueuse, odorante et humide",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 7.8F }),
		        new SaisieFromage("Emmental de Savoie IGP",
		                "emmental_de_savoie_igp",
		                "Fabrique en Savoie, au lait cru de vache, il est un fromage à pâte pressee cuite. Ayant une croûte jaune à brun pâle signee de la mention "
		                        + "Savoie sur le talon, et proposant une pâte jaune clair au toucher fin et souple, l’Emmental français offre une diversite de goût "
		                        + "aux arômes subtils, doux et fruites. Seul ou accompagne de pain, il s'accorde bien avec un verre de vin. "
		                        + "Traditionnellement utilise pour la fondue savoyarde, on l'utilise egalement dans de nombreuses preparations culinaires, en tranches, "
		                        + "en cubes, râpe ...",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 6F, 12F, 24F }),
		        new SaisieFromage("Emmentaler Suisse", "emmentaler_suisse",
		                "Indispensable sur un plateau de fromage, l'Emmental Suisse revèle toutes ses subtilites en cuisine, en plats chauds ou froids. "
		                        + "Savoureux sans être envahissant, il est ideal pour les sandwichs et salades, et même au petit-dejeuner. Les Suisses en raffolent. "
		                        + "Fromage au lait cru de vache proposant une pâte ferme et tendre de couleur crème à jaune clair, et une croûte lisse de couleur doree "
		                        + "ou brun clair recouverte d’une inscription rouge «Switzerland Emmentaler». "
		                        + "L’ Emmental Suisse vous offrira un goût doux, tendre aux delicates nuances de noisette et de noix mais gagnera en puissance en s’affinant.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 6.5F, 13F, 26F }),
		        new SaisieFromage("Epoisses", "epoisses",
		                "Au lait cru de vache, ce fromage dispose d’une croûte brillante orangee renfermant une pâte souple beige clair. "
		                        + "En bouche, l’ epoisses vous offrira une onctuosite et un goût releve avec des notes de fruits secs. "
		                        + "D'un caractère puissant, ce fromage particulièrement goûteux est fabrique depuis des siècles de tradition par les moines et "
		                        + "les fermière de la region d’epoisses. Un delice sur un plateau, certains le place au four à même dans sa boîte.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 12.6F }),
		        new SaisieFromage("Fondue Savoyarde", "fondue_savoyarde",
		                "Ideal pour un repas convivial avec vos amis ou en famille. C'est un melange de parfum, d'onctuosite, et de raffinement pour "
		                        + "cette fondue savoyarde. Allez y piquez vos morceaux de pain dans le caquelon au centre de la table. "
		                        + "La fondue savoyarde est un plat regional de la gastronomie française à base de fromage fondu et de pain, traditionnel des pays de Savoie. "
		                        + "Ce plat populaire, vous envoûtera de part ses multiples arômes.",
		                TypeVente.POUR_X_PERSONNES,
		                new String[] { "3", "5", "10" },
		                new float[] { 22.5F, 33.75F, 67.5F }),
		        new SaisieFromage("Fourme d'Ambert", "fourme_d_ambert",
		                "La Fourme d'Ambert est un fromage au lait cru de vache à pâte persillee, elle vous offrira en bouche une saveur delicate et une texture fondante. "
		                        + "Celle-ci presentera une pâte de couleur blanche à ivoire parsemee de moisissures bleu-vert, et une croûte fine naturelle fleurie "
		                        + "qui peut presenter des reflets de la même teinte. Reconnu pour être le fromage bleu le plus doux, ce fromage ravira vos papilles "
		                        + "et celles de vos convives.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 6.2F, 12.4F, 24.8F }),
		        new SaisieFromage("Galet de Loire", "galet_de_loire",
		                "C’est un fromage au lait pasteurise de vache à patte molle à croûte fleurie blanche à jaunâtre, et legèrement striee et tachetee. "
		                        + "Sans odeur et d’un goût de noisette, le galet de Loire nous invite à ne pas se fier sa petite apparence, "
		                        + "en bouche il reste delicat et onctueux au cœur avec sa pâte est cremeuse et devoile un goût type ainsi qu’une importante diversite d’arômes, "
		                        + "tantôt champignon, tantôt etable.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 5.5F }),
		        new SaisieFromage("Gaperon", "gaperon",
		                "Issu d'Auvergne, le Gaperon est un petit fromage dont la saveur varie suivant qu'on le mange frais, jeune, affine ou très affine. "
		                        + "Il degage peu d'odeur mais sa saveur reste \"piquante\" à deguster toute l'annee. Au lait cru de vache, celui-ci est conçu avec "
		                        + "ce qu’il reste du beurre après sa fabrication, c’est -à-dire le «babeurre». Le Gaperon dispose d’une pâte de couleur ivoire à "
		                        + "jaune pâle à l’interieur et d’une croûte lisse et blanche à l’exterieur. Ce petit fromage parseme de poivre moulu et de morceaux d’ail "
		                        + "vous offrira une saveur aromatisee et intense.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 6.5F, 11.8F }),
		        new SaisieFromage("Gorgonzola", "gorgonzola",
		                "D’une pâte de couleur blanche parsemee de veines vertes-bleutees, le Gorgonzola propose une texture ferme mais moelleuse à la fois "
		                        + "aux saveurs particulières et caracteristiques legèrement piquantes. Souvent utilise dans de nombreuses recettes pour son fondant, "
		                        + "le Gorgonzola peut egalement être apprecie sur un plateau de fromages à deguster en fin de repas et pourquoi pas l’associer à une poire. "
		                        + "Il reste et restera un fromage incontournable de la gastronomie italienne.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 5.2F, 10.4F, 20.8F }),
		        new SaisieFromage("Gouda", "gouda",
		                "Specialite fermière hollandaise, ce Gouda vieux dispose d'un affinage exceptionnel qui le rend dur et cassant avec un etonnant goût de "
		                        + "noisette très prononce. Fromage au lait de vache pasteurise, il offre une croûte lisse et dure de cire jaune renfermant une pâte ferme "
		                        + "et friable de couleur crème à jaune. Le Vieux Gouda vous apportera une saveur prononcee et piquante avec des arômes de lait, de crème, "
		                        + "d’amande à deguster à tous moments de la journee.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 7.5F, 15F, 30F }),
		        new SaisieFromage("Gouda aux truffes", "gouda_aux_truffes",
		                "Fromage hollandais au lait de vache thermise, il offre une croûte lisse et dure de cire noire renfermant une pâte jeune et souple agreablement "
		                        + "parfume de couleur crème à jaune. La pâte est parsemee de nombreux eclats de truffes. Ce Gouda vous apportera une saveur douce et subtile "
		                        + "il sera difficile de s'en passer. Très goûteux aux arômes intenses de la truffe noire, il sera irresistible et pourra se manger à "
		                        + "l'aperitif ou même être ajoute dans des plats cuisines. Il vous fera decouvrir des associations etonnantes.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 8.75F, 17.5F, 35F }),
		        new SaisieFromage("Gruyère Suisse", "gruyere_suisse",
		                "C’est un fromage au lait cru de vache au goût fin, subtil et aromatique. Le Gruyère Suisse renferme une pâte souple et ferme de couleur "
		                        + "ivoire recouverte d’une croûte grainee brunâtre. D’une saveur inimitable qui s’affirmera en fonction de son affinage, il sera très apprecie "
		                        + "sur votre plateau fromage. Le Gruyère Suisse traditionnel est fabrique dans les cantons de Fribourg, c'est l'authenticite du travail "
		                        + "du fromager qui va apporte au fromage toute la richesse de son goût incomparable.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 10.7F, 21.4F, 42.8F }),
		        new SaisieFromage("Kaltbach Suisse", "kaltbach_suisse",
		                "En apero, en fin de repas ou pour agrementer vos plats, le Kaltbach regalera petits et grands avec son goût très fruite et son fondant "
		                        + "incomparable. Enrichi en crème et affine dans la grotte de Kaltbach en Suisse, ce fromage dispose d'une texture moelleuse et ferme à la "
		                        + "fois et d'une odeur franche mais très agreable.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 8.7F, 17.4F, 34.8F }),
		        new SaisieFromage("Laguiole", "laguiole",
		                "Ce fromage au lait cru de vache dispose d’une pâte ferme et lisse de couleur jaune paille, recouvert d’une croûte naturelle et epaisse "
		                        + "de couleur orange claire ou brun ambre. Reconnaissable au Taureau imprime sur la croûte suivi du mot \"Laguiole\", "
		                        + "il vous offrira un goût remarquable et unique des saveurs florales de son terroir à consommer à tout moment, de l’aperitif à la fin du repas.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 6.5F, 13F, 26F }),
		        new SaisieFromage("Langres Fermier", "langres_fermier",
		                "Fromage au lait cru de vache, le Langres vous propose une pâte souple, fondante et cremeuse de couleur blanche, recouverte d'une croûte "
		                        + "fine et brillante de couleur jaune clair à brun en s'affinant. En forme d'un cylindre dont le sommet se creuse formant une cuvette, "
		                        + "la \"Fontaine\", celle-ci permettant d'y verser du Champagne ou du Marc de Champagne : façon traditionnelle d’accommoder ce fromage, "
		                        + "vous decouvrirez en le degustant des saveurs relevees avec des notes d'alcool accompagnees d'une forte odeur penetrante.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 7.9F }),
		        new SaisieFromage("Livarot", "livarot",
		                "Appele aussi \"le Colonel\" dû aux cinq bandes en roseau qui entourent sa croûte, appelees \"laiches\", le Livarot au lait cru de vache "
		                        + "dispose d'une pâte souple et legèrement salee à l'interieur et d'une croûte orangee et humide à l'exterieur. D'une odeur forte et d'un goût "
		                        + "releve aux arômes floraux et aux saveurs de charcuteries fumees, il apportera une note d'originalite sur votre plateau mais pourra "
		                        + "egalement constituer un excellent en-cas.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 7.7F, 15.4F }),
		        new SaisieFromage("Maroilles Fermier", "maroilles_fermier",
		                "Fromage de caractère le plus connus du nord de la France, le Maroilles vous proposera une odeur forte et une saveur corsee. "
		                        + "C'est un fromage au lait cru de vache qui dispose d'une croûte rouge orangee lisse et brillante renfermant une pâte souple et onctueuse. "
		                        + "A decouvrir sur votre plateau de fromages.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 10.69F, 20.99F }),
		        new SaisieFromage("Mimolette Tendre", "mimolette_tendre",
		                "La Mimolette ou appelee egalement \"boule de Lille\" est un fromage au lait pasteurise  de vache. Cette boule de couleur orange interieur "
		                        + "comme à l'exterieur dispose d'une pâte tendre. La Mimolette jeune  vous offrira en bouche des saveurs delicates de noisettes relevees "
		                        + "de pointes de sel.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 4.49F, 8.99F, 17.99F }),
		        new SaisieFromage("Mimolette Vieille", "mimolette_vieille",
		                "La Mimolette vieille est facilement identifiable par sa forme ronde. Sa croûte est grisâtre, rempli de trous et de fissures. "
		                        + "Sa pâte, est orange foncee, sèche et cassante. Sa saveur est fruitee, legèrement piquante et se termine par une pointe d'amertume. "
		                        + "Un fromage de caractère aux arômes sales et sucres accompagnes d'une odeur fruitee et de cave.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "200 g", "400 g", "1 Kg" },
		                new float[] { 6.6F, 13.2F, 29.69F }),
		        new SaisieFromage("Mont d'Or boite", "mont_d_or_boite",
		                "Les amateurs de Mont d'or l'attendent avec impatience : le Vacherin du Haut Doubs, presente dans sa boîte epicea où il donne l'air d'être "
		                        + "un peu à l'etroit avec sa croute legèrement plissee, est la star de la table où il peut être deguste à la petite cuillère. "
		                        + "Le Mont d'Or est un fromage au lait cru de vache, à pâte molle, non cuite, legèrement pressee, de consistance cremeuse, legèrement salee. "
		                        + "Il se reconnaît à sa croûte lavee legèrement \"refleurie\", de couleur jaune à brun clair. "
		                        + "Il est cercle d'une sangle d'epicea et insere dans une boîte en bois d'epicea.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 11.8F }),
		        new SaisieFromage("Mont d'Or", "mont_d_or",
		                "Les amateurs de Mont d'or l'attendent avec impatience : le Vacherin du Haut Doubs, presente dans sa boîte epicea où il donne l'air d'être "
		                        + "un peu à l'etroit avec sa croute legèrement plissee, est la star de la table où il peut être deguste à la petite cuillère. "
		                        + "Le Mont d'Or est un fromage au lait cru de vache, à pâte molle, non cuite, legèrement pressee, de consistance cremeuse, legèrement salee. "
		                        + "Il se reconnaît à sa croûte lavee legèrement \"refleurie\", de couleur jaune à brun clair. "
		                        + "Il est cercle d'une sangle d'epicea et insere dans une boîte en bois d'epicea.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 6.75F, 13.5F, 27F }),
		        new SaisieFromage("Montbriac", "montbriac",
		                "Au lait de vache pasteurise, ce fromage renferme une pâte cremeuse de couleur ivoire legèrement persillee recouverte d’une croûte tendre "
		                        + "de couleur grise. Le Montbriac connu aussi comme Rochebaron, vous offrira un parfum delicat et une saveur fruitee et salee avec de legers "
		                        + "arômes du terroir. Ce fromage est le resultat d'une experience heureuse qui combine les moisissures bleue avec un fromage doux et cremeux"
		                        + " typiquement français. Degustez-le en fin de repas avec une baguette bien croustillante.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 6.8F, 13.6F }),
		        new SaisieFromage("Morbier", "morbier",
		                "Marque en son centre d'une celèbre raie noire, le Morbier au lait cru de vache dispose d'une pâte souple et onctueuse coloree entre l'ivoire "
		                        + "et le jaune pâle avec de legères ouvertures et de rares petits trous. Sa croûte lisse et fine de couleur rose clair à beige orange "
		                        + "renferme bien d'autres surprises et qualites. Le Morbier devoilera un parfum franc et persistant ainsi qu'une odeur franche et fruite, "
		                        + "et un leger goût de crème et de fruit comme la noisette.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 5F, 10F, 19.99F }),
		        new SaisieFromage("Munster", "munster",
		                "Delicieux et delicat fromage au lait cru de vache, il propose une pâte moelleuse aux saveurs delicates et une croûte lisse de couleur doree "
		                        + "à orangee. Le Munster au goût releve et fruite dispose d’une odeur forte et penetrante. En plateau ou en cuisine, il est souvent "
		                        + "consomme avec du cumin ou du carvi.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 6.6F, 13.1F }),
		        new SaisieFromage("Munster au Cumin", "munster_au_cumin",
		                "Delicieux et delicat fromage au lait cru de vache, il propose une pâte moelleuse aux saveurs delicates et une croûte lisse de couleur doree "
		                        + "à orangee parsemee de cumin. Le Munster au goût releve et fruite dispose d’une odeur forte et penetrante.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 9.4F, 18.8F }),
		        new SaisieFromage("Neufchâtel Cœur", "neufchatel_coeur",
		                "Le Neufchâtel convient à tous les palais, sous sa croûte blanche fleurie, se cache une pâte lisse et moelleuse (on la dit \"moussee\") "
		                        + "de couleur blanche à ivoire. Au lait cru de vache, ce petit fromage en forme de cœur vous apportera une saveur delicate mais soutenue, "
		                        + "salee et acidulee accompagnee d'une legère odeur de lait. Le Neufchâtel vous offrira un goût de champignons et de lait qui "
		                        + "s'accentuera en s'affinant.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 4.99F }),
		        new SaisieFromage("Olivet", "olivet",
		                "C’est un fromage au lait de vache pasteurise recouvert de cendre, il dispose d’une croûte mince de couleur grise degageant une legère "
		                        + "odeur de terre, renfermant une pâte souple de couleur blanche à ivoire. L’Olivet Cendre vous offrira des saveurs fruitees relevees "
		                        + "d’une pointe de sel. Son processus d’affinage lui permettra de developper un goût d'herbe fraîche plus nuance que le camembert.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 4.99F }),
		        new SaisieFromage("Parmesan Reggiano", "parmesan_reggiano",
		                "Le parmesan, est un fromage italien traditionnel, qui jouit d'une renommee mondiale, il a une saveur lactique, fruitee, salee, parfois "
		                        + "piquante et rentre dans la composition de beaucoup de recettes. Fromage au lait cru de vache, le Parmesan est un fromage à pâte pressee cuite. "
		                        + "D’une croûte brune huilee, aux saveurs très fruitees et d’un piquant unique, il dispose d’une qualite toujours excellente.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 8.7F, 17.4F, 34.8F }),
		        new SaisieFromage("Pont l'Evêque", "pont_l_eveque",
		                "Au lait cru de vache, ce pave dispose d’une croûte lisse de couleur beige clair à l’exterieur et d’une pâte tendre de couleur jaune pâle "
		                        + "à l’interieur. Le Pont l’evêque au goût subtil et fruite avec des notes de noisettes sera un delice en fin de repas à deguster sans moderation.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 5.3F, 10.5F }),
		        new SaisieFromage("Raclette de Savoie", "raclette_de_savoie",
		                "La Raclette est aussi savoureuse à manger à la main comme fondu, elle est de forme ronde, sa croûte lisse de couleur orange fonce à brun, "
		                        + "pâte souple caracterisee par une couleur jaune ivoire, goût franc et très parfumee. A pleine maturite elle devient plus corsee.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg",
		                        "1/2 Tomme 2,6 Kg (environ)" },
		                new float[] { 4.52F, 9.04F, 18.08F, 47.01F }),
		        new SaisieFromage("Reblochon", "reblochon",
		                "Au lait cru de vache ce fromage fermier presente une croûte lisse jaune orange recouverte par une legère mousse blanche, renfermant "
		                        + "une pâte onctueuse de couleur ivoire. Le Reblochon vous offrira une saveur subtile relevee d’une note de noisette qui reste en bouche "
		                        + "après l'avoir deguste. Principalement utilise pour la traditionnelle Tartiflette, il sera un delice sur vos plateaux de fromages.",
		                TypeVente.ENTIER_OU_MOITIE, new String[] { "" },
		                new float[] { 8.99F, 17.6F }),
		        new SaisieFromage("Rosettes de tête de moine",
		                "rosettes_de_tete_de_moine",
		                "Pourquoi avoir absolument besoin du friseur à fromage, pour être en mesure d'apprecier la tête de moine ? La saveur de la rosette est garantie "
		                        + "grâce ce concept. Nous proposons ce service pour assurer des rosettes aerees et solides. Elles sont preparees par nos soins le jour de "
		                        + "l'expedition. Elles sont conditionnees dans une boite plastique. La quantite par boite peut varier de 12 à 14 rosettes. "
		                        + "La tête de moine est un fromage Suisse au lait cru de vache, il propose une croûte ferme brune renfermant une pâte de couleur ivoire à "
		                        + "jaune clair, legèrement dure et fondante en bouche. La Tête de Moine vous apportera des saveurs aromatiques qui s’affirmeront en s’affinant. ",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 8.9F }),
		        new SaisieFromage("Saint Felicien", "saint_felicien",
		                "Ce fromage au lait cru de vache vous proposera un goût cremeux legèrement sale et noisete. Le Saint-Felicien offrira une pâte souple "
		                        + "recouverte d’une croûte naturelle de couleur blanche à jaune clair. Il sera un fromage fermier qui comblera les amateurs de fromages doux. "
		                        + "Le Saint-Felicien seduit de plus en plus de consommateurs par son onctuosite, son cremeux et son bon goût.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 6.1F }),
		        new SaisieFromage("Saint Marcellin Fermier",
		                "Saint-Marcellin-fermier",
		                "Fromage au lait thermise de vache, il propose une pâte molle et cremeuse de couleur ivoire recouverte d'une croûte fine et fleurie de "
		                        + "couleur blanche. D’un goût legèrement acide aux arômes de noisette accompagne d’un parfum boise, c'est un petit fromage produit dans la Drôme, "
		                        + "il est à consommer peu affine accompagne d'une salade mais il developpera toute sa typicite quand il sera coulant sous une croûte bleue.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 2.47F }),
		        new SaisieFromage("Saint Nectaire Fermier",
		                "saint_nectaire_fermier",
		                "Ce fromage au lait cru de vache à pâte pressee non cuite, propose une belle pâte de texture souple de couleur crème. Il est savoureux et "
		                        + "doit être mange à cœur et non pas coulant. Offrant toutes les essences des prairies de son terroir et un delicat goût noisette "
		                        + "le Saint Nectaire est un fleuron gastronomique auvergnat. Au parfum inimitable de terroir qui laisse echapper quelques odeurs de noisette, "
		                        + "chaud ou froid, notre fromage s'adapte à vos envies. Ce fromage d'Auvergne pourra se deguster tout simplement sur une genereuse "
		                        + "tranche de pain de campagne.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg",
		                        "fromage entier de 1,5 Kg (environ)" },
		                new float[] { 7.45F, 14.9F, 29.8F, 40.23F }),
		        new SaisieFromage("Salers", "salers",
		                "La personnalite du Salers, l’extraordinaire etendue de sa palette de goûts, permettent des mariages gourmands allant du classique au plus insolite. "
		                        + "Fromage fermier au lait cru de vache, il dispose d’une pâte jaune et bien liee recouverte d’une croûte doree, epaisse et fleurie de tâches "
		                        + "rouges et orangees. Le Salers vous offre un goût corse, epice, lactique et fruite à deguster tout au long de l’annee. "
		                        + "Vous l’identifierez par une plaque rouge et une empreinte gravee en creux «Salers-Salers» sur l’une des faces de ce fromage.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 7.75F, 15.5F, 31F }),
		        new SaisieFromage("Tête de Moine", "tete_de_moine",
		                "Fromage Suisse au lait cru de vache, il propose une croûte ferme brune renfermant une pâte de couleur ivoire à jaune clair, legèrement dure "
		                        + "et fondante en bouche. La Tête de Moine vous apportera des saveurs aromatiques qui s’affirmeront en s’affinant. Generalement, pour deguster "
		                        + "la Tête de Moine AOP, il ne faut pas couper le fromage mais le racler en rosettes très fines, grâce au friseur à fromage. "
		                        + "En effet, le raclage modifie la structure de la pâte, la plus grande surface mise en contact avec l'air met particulièrement en valeur "
		                        + "l'arôme typique  et permet de mieux la savourer.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "200 g", "400 g",
		                        "Tête de Moine entière 850 g (environ)" },
		                new float[] { 7.56F, 15.12F, 28.92F }),
		        new SaisieFromage("Tomme de Savoie", "tomme_de_savoie",
		                "Doyenne des fromages de Savoie, la Tomme de Savoie est une fabrication ancestrale issue d'un environnement naturel exceptionnel. "
		                        + "Les saveurs de ce fromage reposaient donc sur les parfums du lait, lies notamment aux herbages specifiques dont se nourrissaient "
		                        + "les troupeaux. D’une croûte grise fleurie de moisissures blanches renfermant une pâte tendre de couleur blanche à jaune pâle presentant "
		                        + "de legères ouvertures. Ce fromage au lait cru de vache offre un goût de noisette legèrement sale accompagne d’un parfum de cave, "
		                        + "la tomme de Savoie reste un fromage typique à partager toute l’annee.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg",
		                        "tomme entière de 1,6 Kg (environ)" },
		                new float[] { 5.99F, 11.99F, 23.99F, 30.7F }),
		        new SaisieFromage("Tomme des Pyrenees", "tomme_des_pyrenees",
		                "Fromage au lait cru de vache, il presente une croûte striee, orangee et doree renfermant une pâte souple et onctueuse de couleur jaune "
		                        + "aeree par de petites ouvertures. La Tomme de Vache offrira en bouche des saveurs fruitees legèrement sucrees et acidulee aux notes de noisettes, "
		                        + "le tout s’accompagnant d’une legère odeur de cave. La tomme des Pyrenees \"Bethmale\" offre une saveur forte et fruitee qui saura vous "
		                        + "faire voyager au cœur des montagnes d’Ariège.",
		                TypeVente.A_LA_COUPE_AU_POIDS,
		                new String[] { "250 g", "500 g", "1 Kg" },
		                new float[] { 7.2F, 14.4F, 28.8F }),
		        new SaisieFromage("Trou du Cru", "trou_du_cru",
		                "Petit fromage au lait pasteurise de vache, il se presente sous la forme d’un petit cylindre recouvert d’une croûte lisse et collante de couleur "
		                        + "orange à rouge, renfermant une pâte onctueuse et fondante de couleur jaune clair. D’un goût puissant et delicat à la fois il vous offrira "
		                        + "des saveurs parfumees, salees et sucrees releve d’arômes d’alcool, accompagne d’une legère odeur de paille. Ne vous fiez pas à sa petite taille, "
		                        + "affine avec du marc de Bourgogne, son goût puissant avec une arrière bouche florale enchantera les amateurs de sensations fortes.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 3.99F }),
		        new SaisieFromage("Vieux Lille", "vieux_lille",
		                "Au lait cru de vache, le Vieux Lille se presente sous la forme d’un pave de couleur grisâtre. Sa pâte etant elaboree à base de Maroilles "
		                        + "macere dans une saumure, celle-ci est donc souple et offre une odeur puissante accompagne d’un goût prononce, sale et legèrement piquant.",
		                TypeVente.A_L_UNITE, new String[] { "" },
		                new float[] { 6.99F }) };
		for (SaisieFromage s : fromages) {
			fromagesAuLaitDeVache.add(s.builderFromage());
		}
		for (Fromage f : fromagesAuLaitDeVache) {
			f.updateTypeFromage(TypeLait.VACHE);
		}
		return fromagesAuLaitDeVache;
	}
}