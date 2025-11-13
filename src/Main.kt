fun main() {
    val quest1 = Quest("Исследовать пещеру", QuestType.EXPLORE, "Найдите вход в пещеру и исследуйте её.")
    val quest2 = Quest("Победить босса", QuestType.FIGHT, "Сразитесь с боссом в подземелье.")
    val quest3 = Quest("Собрать ягоды", QuestType.COLLECT, "Соберите 10 ягод в лесу.")
    val quest4 = Quest("Открыть сундук", QuestType.EXPLORE, "Найдите и откройте сундук в старой башне.")

    val quests = listOf(quest1, quest2, quest3, quest4)

    for (quest in quests) {
        quest.printInfo()
    }

    println("\nТолько квесты типа EXPLORE:")
    printExploreQuests(quests)
}