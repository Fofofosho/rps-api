package com.rps.friends.domain.service;

import com.rps.friends.domain.dto.Friend;

import java.util.Set;

public interface FriendService {

  Set<Friend> getMyFriends(String accountId);

  void addFriend(String accountId, String friendId);
}
