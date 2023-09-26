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

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.body.MultipartBody;
import org.cactoos.Scalar;

import java.util.Map;

/**
 * OHIP API Post.
 *
 * @since 0.0.0
 */
public interface Post extends Scalar<MultipartBody> {

  /**
   * Token Post Request.
   */
  final class Token implements Post {

    /**
     * Environment.
     */
    private final Environment environment;

    /**
     * Ctor.
     *
     * @param env Environment
     */
    public Token(final Environment env) {
      this.environment = env;
    }

    @Override
    public MultipartBody value() throws Exception {
      final Map<String, String> envs = this.environment.value();
      Unirest.setTimeouts(0L, 0L);
      return Unirest.post(
          "%s/oauth/v1/tokens".formatted(envs.get("hostname"))
        )
        .header("Content-Type", "application/x-www-form-urlencoded")
        .header("x-app-key", envs.get("app"))
        .header("Authorization", "Basic " + envs.get("auth"))
        .field("username", envs.get("username"))
        .field("password", envs.get("password"))
        .field("grant_type", "password");
    }
  }
}
