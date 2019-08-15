package com.trungthuc.facebook;

import org.apache.poi.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

@Controller
public class FacebookController {



    private Facebook facebook ;
    private ConnectionRepository connectionRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "facebook/login";
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String feed(Model model) {

        if(connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        User userProfile = facebook.userOperations().getUserProfile();
        model.addAttribute("userProfile", userProfile);
        PagedList<Post> userFeed = facebook.feedOperations().getFeed();
        model.addAttribute("userFeed", userFeed);
        return "facebook/feed";
    }
    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    public String friends(Model model) {

        if(connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        User userProfile = facebook.userOperations().getUserProfile();
        model.addAttribute("userProfile", userProfile);
        List<User> friends = facebook.friendOperations().getFriendProfiles();
        model.addAttribute("friends", friends);
        return "facebook/firends";
    }

}
