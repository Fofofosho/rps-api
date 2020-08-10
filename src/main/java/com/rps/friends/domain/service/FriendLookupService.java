package com.rps.friends.domain.service;

import com.rps.friends.domain.dto.Friend;

import java.util.Optional;

public interface FriendLookupService {

  Optional<Friend> lookup(String friendId);
}
