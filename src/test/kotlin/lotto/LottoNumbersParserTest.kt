package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbersParser

internal class LottoNumbersParserTest : BehaviorSpec({

    Given("LottoNumbersParser") {
        val lottoNumbersParser = LottoNumbersParser
        When("white space가 섞인 번호가 입력되면") {
            val inputs = listOf(
                "1,2,3" to listOf(1, 2, 3),
                "1, 2, 3" to listOf(1, 2, 3),
                "1, 2,3" to listOf(1, 2, 3)
            )
            Then("올바르게 List<Int>로 파싱된다.") {
                inputs.forAll { input ->
                    val actual = lottoNumbersParser.splitInputLottoNumbers(input.first)
                    actual shouldBe input.second
                }
            }
        }
    }
})
