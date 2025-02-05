package com.example.guessthat.GameLogic

@kotlinx.serialization.Serializable
data class Question(
    val question: String,
    val answer1: String?,
    val answer2: String?,
    val answer3: String?,
    val answer4: String?,
    val solution: String,
    var id: String
)
fun getQuestions(): List<Question> { //for offline game
    return listOf(
        Question(
            "Welches Land hat die meisten Einwohner?",
            "Pakistan",
            "China",
            "Indien",
            "USA",
            "Indien",
            "Geo"
        ),
        Question(
            "Wo befindet sich der Mount Everest?",
            "China",
            "Pakistan",
            "Bangladesh",
            "Nepal",
            "Nepal",
            "Geo"
        ),
        Question(
            "Die Hauptstadt der Türkei ist...",
            "Ankara",
            "Istanbul",
            "Trabzon",
            "Antalya",
            "Ankara",
            "Geo"
        ),
        Question(
            "Welches Land ist KEIN Nachbarland Österreichs?",
            "Slowenien",
            "Slowakei",
            "Tschechien",
            "Kroaiten",
            "Kroaiten",
            "Geo"
        ),
        Question(
            "Die Hauptstadt Brasiliens ist...",
            "Sao Paolo",
            "Brasilia",
            "Rio de Janeiro",
            "Manaus",
            "Brasilia",
            "Geo"
        ),
        Question(
            "In welchem Bundesstaat befindet sich Miami?",
            "Georgia",
            "Kalifornien",
            "Florida",
            "Ohio",
            "Florida",
            "Geo"
        ),
        Question(
            "Die grösste Insel der Welt ist...",
            "Java",
            "Grönland",
            "Grossbritanien",
            "Madagaskar",
            "Grönland",
            "Geo"
        ),
        Question(
            "Das kleinste Land der Welt ist...",
            "Vatikanstaat",
            "Malta",
            "Monaco",
            "Tuvalu",
            "Vatikanstaat",
            "Geo"
        ),
        Question(
            "Das größte Land Afrikas ist...",
            "Algerien",
            "DR Kongo",
            "Sudan",
            "Ägypten",
            "Algerien",
            "Geo"
        ),
        Question(
            "Die meistgesprochene Sprache der Welt ist...",
            "Hindi",
            "Mandarin",
            "Englisch",
            "Spanisch",
            "Englisch",
            "Geo"
        ),
        Question(
            "Kasachstan ist ein...",
            "Inselstaat",
            "Binnenstaat",
            "Küstenstaat",
            "Stadtstaat",
            "Binnenstaat",
            "Geo"
        ),
        Question(
            "Budapest ist die Hauptstadt von...",
            "Rumänien",
            "Bulgarien",
            "Serbien",
            "Ungarn",
            "Ungarn",
            "Geo"
        ),
        Question(
            "Die größte Insel Griechenlands ist...",
            "Kreta",
            "Zypern",
            "Mykonos",
            "Santorini",
            "Kreta",
                "Geo"
        ),
        Question(
            "Welches Land hat 2022 die Fussball WM gewonnen?",
            "Frankreich",
            "Argentinien",
            "Deutschland",
            "Brasilien",
            "Argentinien",
                "Sport"
            ),
            Question(
                "Erhält man beim American Football 3 Punkte handelt es sich um ein...",
                "Touchdown",
                "Safety",
                "Field Goal",
                "Foulspiel",
                "Field Goal",
                "Sport"
            ),
            Question(
                "Kobe Bryant spielte seine ganze Karriere für die...",
                "LA Clippers",
                "Chicago Bulls",
                "Los Angeles Lakers",
                "Boston Celtics",
                "Los Angeles Lakers",
                "Sport"
            ),
            Question(
                "Trifft ein Spieler beim Golf den Ball direkt vom Abschlag ins Loch handelt es sich um ein...",
                "Hole-in-one",
                "Break",
                "Foul",
                "Handicap",
                "Hole-in-one",
                "Sport"
            ),
            Question(
                "Wo fanden die ersten Olympischen Spiele der Neuzeit statt?",
                "Paris",
                "Berlin",
                "London",
                "Athen",
                "Athen",
                "Sport"
            ),
            Question(
                "Welche Person gewann die meisten olympischen Medallien",
                "Usain Bolt",
                "Michael Phelps",
                "Isabell Werth",
                "Simone Biles",
                "Michael Phelps",
                "Sport"
            ),
            Question(
                "Welcher Fussballer gewann die meisten Balon'd'Ors",
                "Cristiano Ronaldo",
                "Franz Beckenbauer",
                "Pele",
                "Lionel Messi",
                "Lionel Messi",
                "Sport"
            ),
            Question(
                "Das Finale in der NFL heißt...",
                "Super Bowl",
                "NFL Finals",
                "All-Star Game",
                "Conference Finals",
                "Super Bowl",
                "Sport"
            ),
            Question(
                "Welches Etappenrennen gilt als das wichtigste im Straßenradrennen",
                "Giro d'italia",
                "Tour de France",
                "Vuelta a Espana",
                "Tour of Austria",
                "Tour de France",
                "Sport"
            ),
            Question(
                "Was ist die höchste Gewichtsklasse im Boxen?",
                "Panzergewicht",
                "Supergewicht",
                "Cruisergewicht",
                "Schwergewicht",
                "Schwergewicht",
                "Sport"
            ),
            Question(
                "Welches Event findet von jährlich von Dezember-Jänner im Alexandria Palace statt?",
                "Handball WM",
                "Eiskunstlauf-Weltmeisterschaft ",
                "World Darts Championship",
                "Balon'd'Or Verleihung",
                "World Darts Championship",
                "Sport"
            ),
            Question(
                "Was ist die kürzeste olympische Sprintdistanz?",
                "100 Meter",
                "60 Meter",
                "50 Meter",
                "80 Meter",
                "100 Meter",
                "Sport"
            ),
            Question(
                "Wie wird beim Tennis bei Satzgleichstand eine Entscheidung erzwungen?",
                "Münzwurf",
                "Tie-Break",
                "Sudden Death",
                "Silver Goal",
                "Tie-Break",
                "Sport"
            ),
        Question(
            question = "Wie viele Katzen lebten 2023 in Deutschland? (In Millionen)",
            null,
            null,
            null,
            null,
            "16",
                "Estimation"
        ),
        Question(
            question = "Wie viele Zimmer hat das weiße Haus?",
            null,
            null,
            null,
            null,
            "132",
            "Estimation"
        ),
        Question(
            question = "Wie viele Eier legt ein Huhn im Jahr durchschnittlich?",
            null,
            null,
            null,
            null,
            "300",
            "Estimation"
        ),
        Question(
            question = "Wie tief ist der tiefste Punkt der Erde? (In Metern)",
            null,
            null,
            null,
            null,
            "11034",
            "Estimation"
        ),
        Question(
            question = "Wie viele Bäume gibt es auf der Welt? (In Milliarden)",
            null,
            null,
            null,
            null,
            "3000",
            "Estimation"
        ),
        Question(
            question = "Wie lang ist die Chinesische Mauer? (In Kilometern)",
            null,
            null,
            null,
            null,
            "21196",
            "Estimation"
        ),
        Question(
            question = "Wie lang dauerte der Hundertjährige Krieg?  (In Jahren)",
            null,
            null,
            null,
            null,
            "116",
            "Estimation"
        ),
        Question(
            question = "Wie groß war Alexander der Große?  (In Zentimetern)",
            null,
            null,
            null,
            null,
            "150",
            "Estimation"
        ),
        Question(
            question = "Wie viele Kinder werden auf der Welt pro Tag geboren?",
            null,
            null,
            null,
            null,
            "440000",
            "Estimation"
        ),
        Question(
            question = "Wann erschien der erste Starwars Film?",
            null,
            null,
            null,
            null,
            "1977",
            "Estimation"
        ),
        Question(
            question = "Wie viele Schafe gibt es in Neuseeland? (In Millionen)",
            null,
            null,
            null,
            null,
            "30",
            "Estimation"
        ),
        Question(
            question = "Wie viele Knochen hat das menschliche Skelett?",
            null,
            null,
            null,
            null,
            "212",
            "Estimation"
        ),
        Question(
            question = "Wie viele Inseln hat Indonesien?",
            null,
            null,
            null,
            null,
            "17508",
            "Estimation"
        ),
        Question(
            question = "Wie schwer ist das IPhone 16? (In Gramm)",
            null,
            null,
            null,
            null,
            "170",
            "Estimation"
        ),
        Question(
            question = "Wie viele Bienen leben in einem Bienenstock?",
            null,
            null,
            null,
            null,
            "50000",
            "Estimation"
        ),
        Question(
            question = "Wie viele Einwohner hat Grönland?",
            null,
            null,
            null,
            null,
            "56000",
            "Estimation"
        )

    )
}
