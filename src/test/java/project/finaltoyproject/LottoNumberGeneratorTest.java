package project.finaltoyproject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {


    @Test
    @DisplayName("로또 번호 갯수 테스트")
    void lottoNumberSizeTest()
    {
        //given
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int price = 1000;
        //when
        final List<Integer> lotto = lottoNumberGenerator.generate(price);
        //then
        Assertions.assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 범위 테스트")
    void lottoNumberRangeTest()
    {
        // given
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int price = 1000;
        // when
        final List<Integer> lotto = lottoNumberGenerator.generate(price);

        //then
        // 현재 상황 : 리스트 내부의 값 하나하나가 특정 조건을 모두 만족하는지 체크해보자
        Assertions.assertThat(lotto.stream().allMatch(v->v >= 1 && v <=45 )).isTrue();
    }

}