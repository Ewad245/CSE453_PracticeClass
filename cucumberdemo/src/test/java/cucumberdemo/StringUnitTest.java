package cucumberdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class StringUnitTest {

	@ParameterizedTest
	@MethodSource("cucumberdemo.StringParams#blankStrings")
	void isBlank_ShouldReturnTrueForNullOrBlankStringsExternalSource(String input) {
		assertTrue(Strings.isBlank(input));
	}

}
