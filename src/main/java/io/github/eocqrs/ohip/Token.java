package io.github.eocqrs.ohip;

import org.cactoos.Text;

/**
 * Token.
 *
 * @since 0.0.0
 */
public interface Token extends Text {

  /**
   * OHIP OAuth Token.
   */
  final class Oauth implements Token {

    /**
     * Post.
     */
    private final Post post;

    /**
     * Ctor.
     *
     * @param pst Post
     */
    public Oauth(final Post pst) {
      this.post = pst;
    }

    @Override
    public String asString() throws Exception {
      return this.post.value().asString()
        .getBody();
    }
  }
}
