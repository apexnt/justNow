const val MINUTE = 60
const val HOUR = 3_600
const val DAY = 86_400
const val TWO_DAY = 172_800
const val THREE_DAY = 259_200

fun main() {
    println("Преобразование секунд в строку, описывающую, когда пользователь был в сети")
    print("Введите количество секунд:")
    val inputNumberOfSeconds = readLine()?.toInt() ?: return
    val outputText = masterTransformation(inputNumberOfSeconds)
}


fun masterTransformation(inputNumberOfSeconds: Int) {
    when (inputNumberOfSeconds) {
        in (MINUTE + 1) until HOUR -> {
            val minutes = inputNumberOfSeconds / MINUTE
            val textMinute = transformationTextMinute(minutes)
            print("Был(а) в сети $minutes $textMinute назад.")
        }
        in HOUR until DAY -> {
            val hours = inputNumberOfSeconds / HOUR
            val textHour = transformationTextHour(hours)
            print("Был(а) в сети $hours $textHour назад.")
        }
        else -> {
            val textDay = transformationTextDay(inputNumberOfSeconds)

        }
    }
}

fun transformationTextMinute(minutes: Int): String {
    return when {
        minutes % 10 == 1 -> "минуту"
        minutes % 10 == 2 || minutes % 10 == 3 || minutes % 10 == 4 -> "минуты"
        else -> {
            "минут"
        }
    }
}

fun transformationTextHour(hours: Int): String {
    return when {
        hours % 10 == 1 -> "час"
        hours % 10 == 2 || hours % 10 == 3 || hours % 10 == 4 -> "часа"
        else -> {
            "часов"
        }
    }
}

fun transformationTextDay(inputNumberOfSeconds: Int) {
    return when {
        inputNumberOfSeconds in DAY..TWO_DAY -> print("Был(а) в сети сегодня")
        inputNumberOfSeconds in TWO_DAY..THREE_DAY -> print("Был(а) в сети вчера")
        inputNumberOfSeconds > THREE_DAY -> print("Был(а) в сети давно")
        else -> {
            print("Был(а) только что")
        }
    }

}



















