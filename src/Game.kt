import java.awt.event.KeyEvent
import kotlin.coroutines.ContinuationInterceptor
import kotlin.random.Random

fun main(args: Array<String>) {

    print("Enter player name: ")
    val playerName = readLine()!!.capitalize()

    print("Enter player race (dwarf, gnome, human, or elf): ")
    val race = readLine()!!.capitalize()

    val champion = Player(name = playerName, race = race)

    print("Enter enemy name: ")
    val enemyName = readLine()!!.capitalize()

    print("Enter enemy race (orc, goblin, human, or dark elf): ")
    val enemyRace = readLine()!!.capitalize()

    val enemy = Player(name = enemyName, race = enemyRace)

    fun damageAssessment(champion: Player, enemy: Player, championStrength: Int, enemyStrength: Int): String {
        if (champion.isImmortal) {
            return "${champion.name} cannot be damaged!"
        } else {
            val eStrength: Int = when {
                enemy.isCursed -> if (enemy.health < 50) {
                    (enemyStrength*1.25).toInt()
                } else {
                    enemyStrength
                }
                enemy.isSly -> (enemyStrength*(Random.nextDouble(1.0, 1.75))).toInt()
                else -> enemyStrength
            }

            val champDamage: Int = when {
                champion.isBlessed -> if (champion.health < 50) {
                    (eStrength * 0.85).toInt()
                } else {
                    eStrength
                }
                champion.isCunning -> (eStrength * (Random.nextDouble(0.0, 0.75))).toInt()
                else -> eStrength
            }

            champion.health -= champDamage
            enemy.health -= championStrength

            return "${champion.name} health: ${champion.health}\n" +
                    "${enemy.name} health: ${enemy.health}\n"
        }
    }

    println("Press enter to begin battle, q to quit: ")
    var battleInput = readLine()!!

    while (battleInput != "q" && (champion.health > 0 || enemy.health > 0)) {
        println(damageAssessment(champion, enemy, champion.dealDamage(), enemy.dealDamage()))
        println("Press enter to continue battle, q to quit: ")
        battleInput = readLine()!!
        println(battleInput)
    }
}
