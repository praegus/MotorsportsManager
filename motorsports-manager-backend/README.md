# Motorsports Manager

## Architecture
Hexagonale architectuur
https://en.wikipedia.org/wiki/Hexagonal_architecture_(software)

Door de adapters los te trekken van de domein logica zorg je voor een schonere scheiding tussen business logica en de interfaces van je applicatie.
Dit maakt het ook makkelijker om adapters te vervangen.

## Lokaal Builden

### Voorbereiding
Draai `mvn clean compile`

### Lokaal opstarten
Open de [MotorsportsManagerApplication](configuration/src/main/java/io/sdet/msm/configuration/MotorsportsManagerApplication.java)
Gebruik rechtermuisknop en kies voor "Run"

### Lokaal testen draaien
Open de [CucumberRunnerTest](configuration/src/test/java/io/sdet/msm/configuration/CucumberRunnerTest.java)
Gebruik rechtermuisknop en kies voor "Run"