package com.rps.friends.data.service;

import com.rps.friends.domain.dto.Friend;
import com.rps.friends.domain.dto.FriendStatus;
import com.rps.friends.domain.service.FriendLookupService;

import java.util.Optional;

public class FriendLookupServiceData implements FriendLookupService {
  @Override
  public Optional<Friend> lookup(String friendId) {
    return Optional.of(new Friend("123", "username1", FriendStatus.ONLINE));
  }
}
