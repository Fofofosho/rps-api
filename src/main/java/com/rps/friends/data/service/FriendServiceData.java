package com.rps.friends.data.service;

import com.rps.friends.domain.dto.Friend;
import com.rps.friends.domain.service.FriendLookupService;
import com.rps.friends.domain.service.FriendService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class FriendServiceData implements FriendService {
  private static final ConcurrentHashMap<String, Set<Friend>> map = new ConcurrentHashMap();

  private FriendLookupService friendLookupService;

  @Inject
  public FriendServiceData(FriendLookupService friendLookupService) {
    this.friendLookupService = friendLookupService;
  }

  @Override
  public Set<Friend> getMyFriends(String accountId) {
    return map.getOrDefault(accountId, Collections.emptySet());
  }

  @Override
  public void addFriend(String accountId, String friendId) {
    Set<Friend> currentFriends = getMyFriends(accountId);

    Optional<Friend> existing = currentFriends.stream()
      .filter(friend -> friend.getId().equalsIgnoreCase(friendId))
      .findFirst();

    if (existing.isEmpty()) {
      friendLookupService.lookup(friendId)
        .ifPresent(friend -> {
          currentFriends.add(friend);
          map.put(accountId, currentFriends);
        });
    }
  }
}
