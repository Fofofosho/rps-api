package com.rps.friends.domain.dto;

import lombok.Value;

@Value
public class Friend {
  String id;
  String username;
  FriendStatus friendStatus;
}
