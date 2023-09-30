package io.github.eocqrs.ohip;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Envelope for {@link Environment}.
 *
 * @since 0.0.0
 */
public abstract class EnvironmentEnvelope implements Environment {

  /**
   * OHIP Hostname.
   */
  private final String hostname;

  /**
   * OHIP App Key.
   */
  private final String app;

  /**
   * OHIP Auth.
   */
  private final String auth;

  /**
   * OHIP Username.
   */
  private final String username;

  /**
   * OHIP Password.
   */
  private final String password;

  /**
   * OHIP Hotel ID.
   */
  private final String hotel;


  /**
   * Ctor.
   *
   * @param hstnm OHIP Hostname
   * @param app   OHIP App Key
   * @param auth  OHIP Auth
   * @param user  OHIP Username
   * @param pwd   OHIP Password
   * @param htl   OHIP Hotel ID
   */
  protected EnvironmentEnvelope(
    final String hstnm,
    final String app,
    final String auth,
    final String user,
    final String pwd,
    final String htl
  ) {
    this.hostname = hstnm;
    this.app = app;
    this.auth = auth;
    this.username = user;
    this.password = pwd;
    this.hotel = htl;
  }

  @Override
  public final Map<String, String> value() {
    final Map<String, String> vars = new HashMap<>(6);
    vars.put("hostname", this.hostname);
    vars.put("app", this.app);
    vars.put("auth", this.auth);
    vars.put("username", this.username);
    vars.put("password", this.password);
    vars.put("hotel", this.hotel);
    return Collections.unmodifiableMap(vars);
  }
}
