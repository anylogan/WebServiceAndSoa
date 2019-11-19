package com.forezp.subscriptions.subscriptions;

import com.alibaba.fastjson.JSONObject;
import com.forezp.subscriptions.messageservice.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class StartController {
    private  Integer  id=30;
    private String new0title;
    private String new1title;
    private String new2title;
    private String new0url;
    private String new1url;
    private String new2url;
    @Autowired
    private MessageService sendMessageService;
    @StreamListener("data")
    public void onReceive(String messageInfo) {
        System.out.println("接受到的消息：" + messageInfo);
        String []data=messageInfo.split(" ");
        new0title=data[0];
        new0url=data[1];
        new1title=data[2];
        new1url=data[3];
        new2title=data[4];
        new2url=data[5];

    }


//    @RequestMapping(value = "/result",method=RequestMethod.POST)
//    public String result(@ModelAttribute(value = "form") Form form, Model model) throws IOException {
//        String c=form.getChannel();
//        //假设现在有了个id
//        id++;
//        c=Integer.toString(id)+" "+c;
//        MessageController messageController=new MessageController();
//        sendMessageService.getOutput().send(MessageBuilder.withPayload(c).build());
//        System.out.println("消息已经发送");
//        model.addAttribute("form", form);
//        return "start";
//    }

    @RequestMapping(value="/update")
    @ResponseBody
    public Object update(@RequestBody JSONObject params){
        System.out.println("成功执行");
        //@RequestBody只能给方法的参数注解，表明一次接收到请求参数
        //JSONObject为alibaba的fastjson包下类，推荐使用。另外也可以使用String来接收前端的json格式传参。
        String channel = params.getString("channel");
        System.out.println("接收到参数"+channel);
//以上就是获取到参数体内id和name。后面再加上自己的业务逻辑即可。如果是dubbo方式的consumer，请将service注入进来，直接调用即可
        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("message","更新成功了！");

        //传递数据
        //假设现在有了个id
        id++;
        String data=Integer.toString(id)+" "+channel;
        sendMessageService.getOutput().send(MessageBuilder.withPayload(data).build());
        System.out.println("消息已经发送");
        return map;
    }
    @GetMapping("/index")
    public String index(){
        return "start"; //当浏览器输入/index时，会返回 /static/home.html的页面
    }
    @RequestMapping(value = "/login/{username}/{password}",method = RequestMethod.GET)
    public Object login(@PathVariable String username,@PathVariable String password){
        System.out.println(username);
        System.out.println(password);
        return "success";
    }
    @RequestMapping("/show")
    public String show(Model model){


        model.addAttribute("new0",new0title);
        model.addAttribute("new0url",new0url);

        model.addAttribute("new1",new1title);
        model.addAttribute("new1url",new1url);

        model.addAttribute("new2",new2title);
        model.addAttribute("new2url",new2url);

        return "ShowSubscription";
    }


}
