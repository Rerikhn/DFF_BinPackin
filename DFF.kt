fun main(args: Array<String>) {
    val weights = arrayOf(0.1f, 0.2f, 0.3f, 0.7f, 0.8f, 0.9f)
    val containers = Array(weights.size) { _ -> 0f}
    ffd(weights, containers, 1)
}

fun ffd(w: Array<Float>, cont: Array<Float>, max: Int): Unit {
    w.sortDescending()
    cont.fill(0f, 0, cont.size)
    var howMuch = 0
    for (i in w.indices)
        for (j in w.indices)
            if (cont[j] + w[i] <= max) {
                cont[j] += w[i]
                break
            }
    for (i in cont.indices)
        if (cont[i] != 0.0f)
            howMuch++
    fun <T> joinOptions(options: Array<T>) =
            options.joinToString(separator = ", ", prefix = "[", postfix = "]")

    print(joinOptions(cont))
}

