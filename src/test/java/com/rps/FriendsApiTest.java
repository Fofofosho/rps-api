package com.rps;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class FriendsApiTest {

  @Inject EmbeddedApplication application;

  @Test
  void testItWorks() {
    Assertions.assertTrue(application.isRunning());
  }
}
