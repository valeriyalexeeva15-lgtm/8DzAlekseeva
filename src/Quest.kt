class Quest (
    val name: String,
    val questType: QuestType,
    val description: String
    ) {
    fun describe() {
        println("Квест: $name")
        println("Тип: $questType")
        println("Описание: $description")
    }

    fun printInfo() {
            println("[$questType] $name — $description")
        }
    }

    fun printExploreQuests(quests: List<Quest>) {
        for (quest in quests) {
            if (quest.questType == QuestType.EXPLORE) {
                quest.describe()
                println()
            }
        }
}