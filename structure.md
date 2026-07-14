mtg-library/
├── build.gradle
├── settings.gradle
├── .gitignore
├── .env
├── README.md
├── docker-compose.yml
├── scripts/
│   └── fetchBulkData.py
├── migrations/                        ← Flyway picks these up automatically
│   ├── V1__create_cards.sql
│   ├── V2__create_collections.sql
│   └── V3__create_decks.sql
└── src/
├── main/
│   ├── java/com/yourname/mtglibrary/
│   │   ├── MtgLibraryApplication.java
│   │   ├── controller/
│   │   │   ├── CardController.java
│   │   │   └── DeckController.java
│   │   ├── model/
│   │   │   ├── Card.java
│   │   │   ├── CommanderDeck.java
│   │   │   └── CollectionEntry.java
│   │   ├── repository/
│   │   │   ├── CardRepository.java
│   │   │   └── DeckRepository.java
│   │   ├── service/
│   │   │   ├── CardService.java
│   │   │   ├── DeckService.java
│   │   │   └── ScryfallService.java
│   │   └── dto/
│   │       ├── CardDTO.java
│   │       └── DeckDTO.java
│   └── resources/
│       ├── application.yml
│       └── application-dev.yml
└── test/
└── java/com/yourname/mtglibrary/
├── service/
│   ├── CardServiceTest.java
│   └── DeckServiceTest.java // need more strucutred file.
└── controller/
└── CardControllerTest.java