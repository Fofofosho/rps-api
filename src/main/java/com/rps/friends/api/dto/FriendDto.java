package com.rps.friends.api.dto;

import com.rps.friends.domain.dto.FriendStatus;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FriendDto {
  String username;
  FriendStatus friendStatus;
}
