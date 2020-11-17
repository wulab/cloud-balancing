package cloudbalancing;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
	@Test public void testMain() {
    String[] args = null;

		try {
			App.main(args);
		} catch (Exception e) {
      fail("Expected no exceptions");
		}
	}
}
