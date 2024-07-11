package cucumberdemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class JUnit5TestExample {

	/*
	 * @BeforeAll static void initAll() {
	 * System.out.println("@BeforeAll - Run before all methods once"); }
	 * 
	 * @BeforeEach void init() {
	 * System.out.println(" @BeforeEach - Run before each test methods "); }
	 * 
	 * @DisplayName("First test")
	 * 
	 * @Test void testMethod1() { System.out.println(" Test method 1"); }
	 * 
	 * @Test
	 * 
	 * @Disabled void testMethod2() { System.out.println(" Test method 2"); }
	 * 
	 * @Test void testMethod3() { System.out.println(" Test method 3"); }
	 * 
	 * @AfterEach void tearDown() {
	 * System.out.println(" @AfterEach - Run after each test methods "); }
	 * 
	 * @AfterAll static void tearDownAll() {
	 * System.out.println("@AfterAll - Run after all test methods once"); }
	 */

	/*
	 * @DisplayName("Kiem tra so duong")
	 * 
	 * @Test void test1() { String str ="1990"; Double actual =
	 * StringUtils.convertToDouble(str); assertEquals(1990, actual); }
	 * 
	 * @DisplayName("Kiem tra so am")
	 * 
	 * @Test void test2() { String str ="-1990"; Double actual =
	 * StringUtils.convertToDouble(str); assertEquals(-1990, actual); }
	 * 
	 * @Test public void testConvertToDoubleOK() { // Test case with the age is a
	 * numeric string String age = "1990"; Double expAge = Double.valueOf(age);
	 * Double actual = StringUtils.convertToDouble(age);
	 * assertAll("Do many assertions.", () -> { assertNotNull(actual);
	 * assertEquals(expAge, actual); }); // Or Java 8 Lambdas style
	 * assertAll("Do many assertions.Java 8 Lambdas style", () -> {
	 * assertNotNull(actual, () -> "The actual is NULL"); assertEquals(expAge,
	 * actual, () -> "The expected is: " + expAge + " while the actual is:" +
	 * actual); }); }
	 * 
	 * @Test public void testConvertToDoubleWithNullArgument() { // Test case with
	 * the age is null String age = null; Double actual =
	 * StringUtils.convertToDouble(age); assertNull(actual,
	 * "The actual is not null"); // Java 8 Style assertNull(actual, () ->
	 * "The actual is not null"); }
	 */

	/*
	 * @DisplayName("Kiem tra chuoi khong phai so")
	 * 
	 * @Test public void testConvertToDoubleThrowException() { // Test with the age
	 * is a non numeric string String age = "N/A";
	 * assertThrows(NumberFormatException.class, () -> {
	 * StringUtils.convertToDouble(age); });
	 * assertThrows(NumberFormatException.class, () -> {
	 * StringUtils.convertToDouble(age); }); }
	 */

	/*
	 * @DisplayName("Kiem tra so le")
	 * 
	 * @ParameterizedTest
	 * 
	 * @ValueSource(ints = { 1, 3, 5, -3, 15, Integer.MAX_VALUE }) // six numbers
	 * void isOdd_ShouldReturnTrueForOddNumbers(int number) {
	 * assertTrue(Numbers.isOdd(number)); }
	 * 
	 * @DisplayName("Kiem tra rong")
	 * 
	 * @ParameterizedTest
	 * 
	 * @ValueSource(strings = { "", " " }) void
	 * isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
	 * assertTrue(Strings.isBlank(input)); }
	 * 
	 * @DisplayName("CSV File test string")
	 * 
	 * @ParameterizedTest
	 * 
	 * @CsvFileSource(resources = "/testcase.csv", numLinesToSkip = 1) void
	 * toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(String input,
	 * String expected) { String actualValue = input.toUpperCase();
	 * assertEquals(expected, actualValue); }
	 */

	@DisplayName("Kiem tra chuoi rong voi arguments")
	@ParameterizedTest
	@MethodSource("provideStringsForIsBlank")
	void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
		assertEquals(expected, Strings.isBlank(input));
	}

	private static Stream<Arguments> provideStringsForIsBlank() {
		return Stream.of(Arguments.of(null, true), Arguments.of("", true), Arguments.of(" ", true),
				Arguments.of("not blank", false));
	}

	@DisplayName("Kiem tra chuoi rong khong arguments")
	@ParameterizedTest
	@MethodSource // hmm, no method name ...
	void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(String input) {
		assertTrue(Strings.isBlank(input));
	}

	private static Stream<String> isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument() {
		return Stream.of(null, "", " ");
	}

}


