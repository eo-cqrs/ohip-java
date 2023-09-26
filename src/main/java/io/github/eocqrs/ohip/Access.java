package io.github.eocqrs.ohip;

import io.github.eocqrs.eokson.Jocument;
import io.github.eocqrs.eokson.JsonOf;

/**
 * Access Token.
 *
 * @since 0.0.0
 */
public final class Access implements Token {

  private final Token origin;

  public Access(final Token orgn) {
    this.origin = orgn;
  }

  @Override
  public String asString() throws Exception {
    return new Jocument(
      new JsonOf(
        this.origin.asString()
      )
    ).leaf("/access_token");
  }
}
