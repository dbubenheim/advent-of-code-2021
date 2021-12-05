package aoc2021.day03

data class DiagnosticReport(
    val gammaRate: GammaRate = GammaRate(),
    val epsilonRate: EpsilonRate = EpsilonRate()
) {
    fun update(number: IntArray) =
        copy(gammaRate = gammaRate.update(number), epsilonRate = epsilonRate.update(number))

    fun result() = gammaRate.toDecimal() * epsilonRate.toDecimal()
}