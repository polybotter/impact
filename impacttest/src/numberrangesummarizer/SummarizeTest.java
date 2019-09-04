package numberrangesummarizer;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class SummarizeTest {

	@Test
	public void testSummarize() {
		String testSummarize = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
		Summarize summary = new Summarize();
		assertEquals("1, 3, 6-8, 12-15, 21-24, 31", summary.runSummarize(testSummarize));
	}
	
	//Remove characters
	@Test
	public void testCharacterInSummarize() {
		String testCharacterInSummarize = "1,2A,3,6,7,BASD8,12,13,14,15,21,2H2,23,24,25,38,39";
		Summarize summary = new Summarize();
		assertEquals("1-3, 6-8, 12-15, 21-25, 38-39", summary.runSummarize(testCharacterInSummarize));
	}
	
	//Remove unnecessary whitespaces
	@Test
	public void testWhiteSpace() {
		String testWhiteSpace = "   1,3,6,7,8,12   ,13,14,15,21,22,23,24,31   ";
		Summarize summary = new Summarize();
		assertEquals("1, 3, 6-8, 12-15, 21-24, 31", summary.runSummarize(testWhiteSpace));
	}
	
	//Remove symbols
	@Test
	public void testSymbols() {
		String testSymbols = "1,3,6,7,&8,12,13,14,15,21,!22,23,%24,31";
		Summarize summary = new Summarize();
		assertEquals("1, 3, 6-8, 12-15, 21-24, 31", summary.runSummarize(testSymbols));
	}
	
	//Sort Numbers
	@Test
	public void testSort() {
		String testSort = "1,6,3,7,8,12,13,14,15,21,22,23,31,24";
		Summarize summary = new Summarize();
		assertEquals("1, 3, 6-8, 12-15, 21-24, 31", summary.runSummarize(testSort));
	}
	
	//Remove Duplicates
	@Test
	public void testDuplicates() {
		String testDuplicates = "1,2,3,4,5,7,8,8,9,10,15,17,17";
		Summarize summary = new Summarize();
		assertEquals("1-5, 7-10, 15, 17", summary.runSummarize(testDuplicates));
	}

}
