import kotlin.random.Random

class Player (var name: String, var race: String) {
    var faction = when (race) {
        "Dwarf" -> "Guardians of the Mountains"
        "Gnome" -> "Tinkerers in the Mines"
        "Human" -> "People of the Land and Sea"
        "Elf" -> "People of the Forest"
        "Orc" -> "Guardians of the Dungeons"
        "Goblin" -> "Creatures in the Mines"
        "Dark elf" -> "Creatures of the Forest"
        else -> "Unknown Race"
    }
    var health = when (this.race) {
        "Dwarf", "Orc" -> 120
        "Gnome", "Goblin" -> 70
        else -> 100
    }
    var strength = when (this.race) {
        "Dwarf", "Orc" -> (10..16)
        "Gnome", "Goblin" -> (8..22)
        else -> (12..18)
    }
    var isBlessed = when (this.race) {
        "Dwarf" -> true
        else -> false
    }
    var isCursed = when (this.race) {
        "Orc" -> true
        else -> false
    }
    var isImmortal = when (this.race) {
        "Elf", "Dark elf" -> true
        else -> false
    }
    var isCunning = when (this.race) {
        "Gnome" -> true
        else -> false
    }
    var isSly = when (this.race) {
        "Goblin" -> true
        else -> false
    }

    fun dealDamage(): Int {
        return this.strength.shuffled().take(1)[0]
    }
}
