package com.example.guessthat.GameLogic

data class Question(
    val question: String,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val solution: String,
)
fun getGeoQuestions(): List<Question> {
    return listOf(
        Question(
            "Welches ist das Land mit den meisten Einwohnern?",
            "Pakistan",
            "China",
            "Indien",
            "USA",
            "Indien"
        ),
        Question(
            "Wo befindet sich der Mount Everest?",
            "China",
            "Pakistan",
            "Bangladesh",
            "Nepal",
            "Nepal"
        ),
        Question(
            "Die Hauptstadt der Türkei lautet...",
            "Ankara",
            "Istanbul",
            "Trabzon",
            "Antalya",
            "Ankara"
        ),
        Question(
            "Welches Land ist KEIN Nachbarland Österreichs?",
            "Slowenien",
            "Slowakei",
            "Tschechien",
            "Kroaiten",
            "Kroaiten"
        ),
        Question(
            "Die Hauptstadt Brasiliens lautet...",
            "Sao Paolo",
            "Brasilia",
            "Rio de Janeiro",
            "Manaus",
            "Brasilia"
        ),
        Question(
            "Miami befindet sich in welchem Bundesstaat?",
            "Georgia",
            "Kalifornien",
            "Florida",
            "Ohio",
            "Florida"
        ),
        Question(
            "Die grösste Insel der Welt ist...",
            "Java",
            "Grönland",
            "Grossbritanien",
            "Madagaskar",
            "Grönland"
        ),
        Question(
            "Das kleinste Land der Welt ist...",
            "Vatikanstaat",
            "Malta",
            "Monaco",
            "Tuvalu",
            "Vatikanstaat"
        ),
        Question(
            "Das größte Land Afrikas ist...",
            "Algerien",
            "DR Kongo",
            "Sudan",
            "Ägypten",
            "Algerien"
        ),
        Question(
            "Die meistgesprochene Sprache der Welt ist...",
            "Hindi",
            "Mandarin",
            "Englisch",
            "Spanisch",
            "Englisch"
        ),
        Question(
            "Kasachstan ist ein...",
            "Inselstaat",
            "Binnenstaat",
            "Küstenstaat",
            "Stadtstaat",
            "Binnenstaat"
        ),
        Question(
            "Budapest ist die Hauptstadt von...",
            "Rumänien",
            "Bulgarien",
            "Serbien",
            "Ungarn",
            "Ungarn"
        ),
        Question(
            "Die größte Insel Griechenlands lautet...",
            "Kreta",
            "Zypern",
            "Mykonos",
            "Santorini",
            "Kreta"
        )
    )
}
