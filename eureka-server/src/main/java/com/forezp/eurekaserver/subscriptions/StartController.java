//package com.forezp.subscriptions.subscriptions;
//
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.JSONObject;
//import com.forezp.subscriptions.messageservice.MessageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.SubscribableChannel;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//
//@RestController
//public class StartController {
//    private  Integer  id=0;
//    @Autowired
//    private MessageService sendMessageService;
//
//
////    @RequestMapping(value = "/result",method=RequestMethod.POST)
////    public String result(@ModelAttribute(value = "form") Form form, Model model) throws IOException {
////        String c=form.getChannel();
////        //假设现在有了个id
////        id++;
////        c=Integer.toString(id)+" "+c;
////        MessageController messageController=new MessageController();
////        sendMessageService.getOutput().send(MessageBuilder.withPayload(c).build());
////        System.out.println("消息已经发送");
////        model.addAttribute("form", form);
////        return "start";
////    }
//
//    @RequestMapping(value="/update")
//    @ResponseBody
//
//    public String update(@RequestBody JSONObject params){
//        //@RequestBody只能给方法的参数注解，表明一次接收到请求参数
//        //JSONObject为alibaba的fastjson包下类，推荐使用。另外也可以使用String来接收前端的json格式传参。
//        String channel = params.getString("channel");
//        System.out.println("接收到参数"+channel);
//
//        //传递数据
//        //假设现在有了个id
//        id++;
//        String data=Integer.toString(id)+" "+channel;
//        sendMessageService.getOutput().send(MessageBuilder.withPayload(data).build());
//        System.out.println("消息已经发送");
//        return "start";
//    }
//}
