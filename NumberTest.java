package Demo.Problems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberTest {

	@Test
	void test() {
		NumberConversion nc = new NumberConversion();
		assertEquals(13, nc.bin2dec(1101l));
		assertEquals(59, nc.bin2dec(111011l));
		assertEquals(19, nc.bin2dec(10011l));
		assertEquals(31, nc.bin2dec(11111l));
	}

}
