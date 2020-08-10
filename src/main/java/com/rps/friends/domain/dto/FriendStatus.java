package com.rps.friends.domain.dto;

public enum FriendStatus {
  UNKNOWN("Unknown"),
  ONLINE("Online"),
  OFFLINE("Offline");

  private String value;

  FriendStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
