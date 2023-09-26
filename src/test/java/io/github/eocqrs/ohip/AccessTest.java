package io.github.eocqrs.ohip;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

/**
 * Test suite for {@link Access}.
 *
 * @since 0.0.0
 */
final class AccessTest {

  @Test
  void readsAccessInRightFormat() throws Exception {
    MatcherAssert.assertThat(
      "Access in right format",
      new Access(new Token.Mock())
        .asString(),
      new IsEqual<>(
        "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInBhc3N"
        + "3b3JkIjoiZGV2IiwiaWF0IjoxNjk1NzIyMDY3LCJleHAiOjE2OTU3MzI4Njd9."
        + "BMHn2DyIk6vfScKpGlMu55plGhFqhmkHbRoM52XoMlo"
      )
    );
  }
}
