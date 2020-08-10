package com.rps.friends.api.controller;

import com.rps.friends.domain.dto.Friend;
import com.rps.friends.domain.service.FriendService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller("/v1/friends")
public class FriendController {

  private FriendService friendService;

  @Inject
  public FriendController(FriendService friendService) {
    this.friendService = friendService;
  }

  @Get(produces = MediaType.APPLICATION_JSON)
  public Map<String, Object> getFriends(@Header(value = "X-Account-ID") String accountId) {
    Set<Friend> friends = friendService.getMyFriends(accountId);

    Map<String, Object> responseObj = new HashMap<>();
    responseObj.put("data", friends);

    return responseObj;
  }

  @Post(produces = MediaType.APPLICATION_JSON, value = "/{friendId}")
  public HttpResponse addFriend(
      @Header(value = "X-Account-ID") String accountId, @PathVariable String friendId) {
    try {
      friendService.addFriend(accountId, friendId);
      return HttpResponse.accepted();
    } catch (Exception ex) {
      return HttpResponse.serverError(ex);
    }
  }

  @Delete(produces = MediaType.APPLICATION_JSON)
  public Map<String, Object> removeFriend(@Header(value = "X-Account-ID") String accountId) {
    Set<Friend> friends = friendService.getMyFriends(accountId);

    Map<String, Object> responseObj = new HashMap<>();
    responseObj.put("data", friends);

    return responseObj;
  }
}
