package messenger.shared.model

import kotlin.test.Test
import kotlin.test.assertEquals

class HelloTest {

	@Test
	fun test() {
		assertEquals(
				"Hello Foo!",
				Hello().hello()
		)
	}
}