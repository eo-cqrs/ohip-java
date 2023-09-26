/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2023 Aliaksei Bialiauski, EO-CQRS
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.eocqrs.ohip;

import io.github.eocqrs.eokson.Jocument;
import io.github.eocqrs.eokson.MutableJson;
import org.cactoos.Text;

/**
 * Token.
 *
 * @since 0.0.0
 */
public interface Token extends Text {

  /*
   * @todo #1:45min\DEV We need to implement
   *   dynamic JWT token generation;
   *   maybe, it can bre based on provided
   *   username and password
   * */

  /**
   * Mocked Token.
   *
   * @since 0.0.0
   */
  final class Mock implements Token {

    /**
     * Refresh Token.
     */
    private static final String REFRESH =
      "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInBhc3N3b3JkI"
      + "joiZGV2IiwiaWF0IjoxNjk1NzIyMDY3LCJleHAiOjE2OTU3MzI4Njd9."
      + "BMHn2DyIk6vfScKpGlMu55plGhFqhmkHbRoM52XoMlo";

    /**
     * Access Token.
     */
    private static final String ACCESS =
      "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiI"
      + "sInBhc3N3b3JkIjoiZGV2IiwiaWF0IjoxNjk1NzIyMDY3LCJleHAiOjE2OTU3MzI4Njd9"
      + ".BMHn2DyIk6vfScKpGlMu55plGhFqhmkHbRoM52XoMlo";

    @Override
    public String asString() throws Exception {
      return new Jocument(
        new MutableJson()
          .with("expires_in", 3600)
          .with("token_type", "Bearer")
          .with("oracle_tk_context", "user_assertion")
          .with("refresh_token", Token.Mock.REFRESH)
          .with("access_token", Token.Mock.ACCESS)
          .with(
            "oracle_grant_type",
            "urn:ietf:params:oauth:grant-type:jwt-bearer"
          )
      ).pretty();
    }
  }

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
