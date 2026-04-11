package com.example.plantsstoreapp

object PlantRepository {

    val suculentas = listOf(
        Planta(1,  "Echeveria",       "Suculenta", "Planta compacta com folhas em roseta.",       "Regar a cada 10-14 dias. Precisa de muita luz solar direta. Evite excesso de água para não apodrecer a raiz.", R.drawable.echeveria, preco = 25.90),
        Planta(2,  "Aloe Vera",       "Suculenta", "Famosa pelas propriedades medicinais.",        "Regar a cada 2 semanas. Tolera sol pleno. Ótima para uso medicinal na pele.",               R.drawable.aloevera, preco = 18.50),
        Planta(3,  "Crassula",        "Suculenta", "Conhecida como árvore da felicidade.",         "Regar uma vez por semana no verão, quinzenal no inverno. Prefere locais bem iluminados.",   R.drawable.crassula, preco = 22.00),
        Planta(4,  "Haworthia",       "Suculenta", "Ideal para ambientes internos com pouca luz.", "Regar a cada 10 dias. Tolera meia sombra, ideal para ambientes internos.",                 R.drawable.haworthia, preco = 19.90),
        Planta(5,  "Sedum",           "Suculenta", "Muito resistente ao calor e ao sol.",          "Regar semanalmente. Ótima para jardins externos, muito resistente ao calor.",              R.drawable.sedum, preco = 15.00),
        Planta(6,  "Agave",           "Suculenta", "Extremamente resistente à seca.",              "Regar mensalmente. Extremamente resistente à seca e ao sol forte.",                        R.drawable.agave, preco = 30.00)
    )

    val tropicais = listOf(
        Planta(10, "Costela-de-Adão", "Tropical",  "Folhas grandes com recortes característicos.", "Regar 2x por semana. Prefere ambientes úmidos e luminosos sem sol direto.",               R.drawable.defaultuserimg, preco = 45.00),
        Planta(11, "Helicônia",       "Tropical",  "Flores exuberantes e coloridas.",              "Regar diariamente. Adora calor e umidade alta. Ideal para jardins tropicais externos.",    R.drawable.defaultuserimg, preco = 55.00),
        Planta(12, "Bananeira",       "Tropical",  "Crescimento rápido em climas quentes.",        "Regar 3x por semana. Precisa de muito sol e solo fértil.",                                 R.drawable.defaultuserimg, preco = 35.00),
        Planta(13, "Antúrio",         "Tropical",  "Flores em formato de coração.",                "Regar 2x por semana. Prefere meia sombra e umidade. Evite sol direto que queima as folhas.", R.drawable.defaultuserimg, preco = 40.00),
        Planta(14, "Palmeira Areca",  "Tropical",  "Purifica o ar e decora ambientes internos.",   "Regar 2x por semana. Purifica o ar e se adapta bem a ambientes internos iluminados.",     R.drawable.defaultuserimg, preco = 60.00),
        Planta(15, "Calathea",        "Tropical",  "Folhas com padrões únicos e coloridos.",       "Regar 2x por semana com água sem cloro. Prefere sombra e alta umidade.",                  R.drawable.defaultuserimg, preco = 38.00)
    )

    val ervas = listOf(
        Planta(20, "Manjericão",      "Erva",      "Tempero aromático muito usado na culinária.",  "Regar diariamente. Precisa de sol pleno por pelo menos 6h. Colher as folhas estimula o crescimento.", R.drawable.defaultuserimg, preco = 10.00),
        Planta(21, "Hortelã",         "Erva",      "Cresce bem em vasos, aroma refrescante.",      "Regar diariamente. Cresce bem em vasos. Prefere meia sombra e solo sempre úmido.",        R.drawable.defaultuserimg, preco = 8.00),
        Planta(22, "Alecrim",         "Erva",      "Resistente ao calor, ótimo tempero.",          "Regar a cada 2 dias. Prefere sol pleno e solo bem drenado. Resistente ao calor.",         R.drawable.defaultuserimg, preco = 9.00),
        Planta(23, "Lavanda",         "Erva",      "Repele insetos e tem aroma relaxante.",        "Regar semanalmente. Ama sol pleno e solo seco. Repele insetos naturalmente.",              R.drawable.defaultuserimg, preco = 14.00),
        Planta(24, "Sálvia",          "Erva",      "Ótima para tempero e chás medicinais.",        "Regar 2x por semana. Prefere sol pleno. Ótima para tempero e chás medicinais.",           R.drawable.defaultuserimg, preco = 11.00),
        Planta(25, "Erva-cidreira",   "Erva",      "Excelente para chás calmantes.",               "Regar diariamente. Cresce bem em vasos. Excelente para chás calmantes.",                  R.drawable.defaultuserimg, preco = 9.50)
    )

    val flores = listOf(
        Planta(30, "Rosa",            "Flor",      "Clássica e muito apreciada em jardins.",       "Regar 3x por semana. Precisa de sol pleno. Adubar mensalmente para floração constante.",  R.drawable.defaultuserimg, preco = 28.00),
        Planta(31, "Girassol",        "Flor",      "Cresce rápido e atrai polinizadores.",         "Regar diariamente. Precisa de muito sol. Cresce rápido e atrai polinizadores.",            R.drawable.defaultuserimg, preco = 12.00),
        Planta(32, "Orquídea",        "Flor",      "Elegante, ideal para ambientes internos.",     "Regar semanalmente, imergindo o vaso. Prefere luminosidade indireta e boa ventilação.",   R.drawable.defaultuserimg, preco = 75.00),
        Planta(33, "Margarida",       "Flor",      "Floração abundante na primavera e verão.",     "Regar 2x por semana. Prefere sol pleno. Floração abundante na primavera e verão.",        R.drawable.defaultuserimg, preco = 16.00),
        Planta(34, "Violeta",         "Flor",      "Delicada, ideal para ambientes internos.",     "Regar por baixo do vaso para não molhar as folhas. Prefere meia sombra.",                 R.drawable.defaultuserimg, preco = 20.00),
        Planta(35, "Lírio da Paz",    "Flor",      "Purifica o ar e tolera pouca luz.",            "Regar 2x por semana. Tolera pouca luz. Purifica o ar e é excelente para interiores.",    R.drawable.defaultuserimg, preco = 32.00)
    )

    fun todas() = suculentas + tropicais + ervas + flores
}
