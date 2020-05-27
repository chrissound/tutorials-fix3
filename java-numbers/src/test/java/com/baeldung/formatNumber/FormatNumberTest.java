package com.baeldung.formatNumber;

import org.junit.Test;

import static com.baeldung.formatNumber.FormatNumber.*;
import static org.assertj.core.api.Assertions.*;

public class FormatNumberTest {
        private static final double D = 4.2352989244d;
        private static final double F = 8.6994540927d;

        @Test public void givenDecimalNumber_whenFormatNumberToNDecimalPlaces_thenGetExpectedResult() {

                assertThat(withBigDecimal(D, 2)).isEqualTo(4.24);
                assertThat(withBigDecimal(D, 3)).isEqualTo(4.235);
                assertThat(withBigDecimal(F, 2)).isEqualTo(8.7);
                assertThat(withBigDecimal(F, 3)).isEqualTo(8.699);

                assertThat(withMathRound(D, 2)).isEqualTo(4.24);
                assertThat(withMathRound(D, 3)).isEqualTo(4.235);
                assertThat(withMathRound(F, 2)).isEqualTo(8.7);
                assertThat(withMathRound(F, 3)).isEqualTo(8.699);

                assertThat(withStringFormat(D, 2)).isEqualTo("4.24");
                assertThat(withStringFormat(D, 3)).isEqualTo("4.235");
                assertThat(withStringFormat(F, 2)).isEqualTo("8.70");
                assertThat(withStringFormat(F, 3)).isEqualTo("8.699");

                assertThat(withDecimalFormatLocal(D)).isEqualTo(4.235);
                assertThat(withDecimalFormatLocal(F)).isEqualTo(8.699);

                assertThat(withDecimalFormatPattern(D, 2)).isEqualTo(4.24);
                assertThat(withDecimalFormatPattern(D, 3)).isEqualTo(4.235);
                assertThat(withDecimalFormatPattern(F, 2)).isEqualTo(8.7);
                assertThat(withDecimalFormatPattern(F, 3)).isEqualTo(8.699);
        }
}
