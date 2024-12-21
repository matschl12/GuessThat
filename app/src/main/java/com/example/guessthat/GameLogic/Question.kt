package com.example.guessthat.GameLogic

data class Question(
    val question: String,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val solution: String,
    var id: String
)
fun getQuestions(): List<Question> {
    return listOf(
        Question(
            "Welches ist das Land mit den meisten Einwohnern?",
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
            "Die Hauptstadt der Türkei lautet...",
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
            "Die Hauptstadt Brasiliens lautet...",
            "Sao Paolo",
            "Brasilia",
            "Rio de Janeiro",
            "Manaus",
            "Brasilia",
            "Geo"
        ),
        Question(
            "Miami befindet sich in welchem Bundesstaat?",
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
            "Die größte Insel Griechenlands lautet...",
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
                "Die ersten Olympischen Spiele der Neuzeit fanden wo statt?",
                "Paris",
                "Berlin",
                "London",
                "Athen",
                "Athen",
                "Sport"
            ),
            Question(
                "Welche Person gewann die meisten Olympischen Medallien",
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
                "Was ist die kürzeste olympische Sprintdistanz? (In Metern)",
                "100",
                "60",
                "50",
                "80",
                "100",
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
            )
        )
}
