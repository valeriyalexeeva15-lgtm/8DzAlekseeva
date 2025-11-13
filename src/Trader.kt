class Trader {
    private val quests = mutableListOf<Quest>()

    fun addQuest(quest: Quest) {
        quests.add(quest)
    }

    fun showAvailableQuests() {
        if (quests.isEmpty()) {
            println("Нет доступных квестов.")
        } else {
            for (i in quests.indices) {
                val q = quests[i]
                println("$i - ${q.name} (${q.questType}), ${q.duration}ч, ${q.reward} золота, ${q.difficulty}")
            }
        }
    }

    fun giveQuest(index: Int): Quest? {
        if (index in quests.indices) {
            return quests[index]
        }
        return null
    }

    fun removeQuest(index: Int) {
        if (index in quests.indices) {
            quests.removeAt(index)
        }
    }

    fun start() {
        while (true) {
            println("\nВыберите действие:")
            println("1- Добавить квест")
            println("2- Показать все квесты")
            println("3- Взять квест (удалить из списка)")
            println("0- Выйти")
            print("Ваш выбор: ")

            val choice = readLine()?.toIntOrNull()
            when (choice) {
                0 -> {
                    println("Выход из меню.")
                    break
                }
                1 -> {
                    print("Введите название квеста: ")
                    val name = readLine() ?: continue

                    print("Введите длительность (часы): ")
                    val duration = readLine()?.toIntOrNull() ?: continue

                    print("Введите награду (золото): ")
                    val reward = readLine()?.toIntOrNull() ?: continue

                    print("Введите сложность: ")
                    val difficulty = readLine() ?: continue

                    print("Введите тип квеста (DELIVERY, ELIMINATION, ESCORT, EXPLORE, BOSSFIGHT): ")
                    val typeInput = readLine()?.uppercase()
                    val questType = QuestType.entries.find { it.name == typeInput }
                    if (questType == null) {
                        println("Неверный тип квеста.")
                        continue
                    }

                    val quest = Quest(name, duration, reward, difficulty, questType)
                    addQuest(quest)
                    println("Квест '${quest.name}' добавлен.")
                }
                2 -> showAvailableQuests()
                3 -> {
                    print("Введите номер квеста: ")
                    val index = readLine()?.toIntOrNull()
                    if (index == null) {
                        println("Неверный ввод.")
                        continue
                    }
                    val quest = giveQuest(index)
                    if (quest != null) {
                        println("Вы взяли квест: ${quest.name}")
                        removeQuest(index)
                    } else {
                        println("Неверный номер квеста.")
                    }
                }
                else -> println("Неверный выбор.")
            }
        }
    }
}