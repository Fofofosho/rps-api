package com.rps.friends.api.tranformer;

import com.rps.friends.api.dto.FriendDto;
import com.rps.friends.domain.dto.Friend;

public class FriendTransformer {

  public static FriendDto toApi(Friend domain) {
    return new FriendDto()
        .setUsername(domain.getUsername())
        .setFriendStatus(domain.getFriendStatus());
  }
}
