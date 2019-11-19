package com.forezp.creatnotice;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.forezp.creatnotice.messageservice.MessageService;

@Controller
public class CreateNoticeController {
    @Autowired
    MessageService sendMessageService;
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public String GetNews() {
        //在这里获取了id
        //然后到数据库中查询  如果找到了就造一些数据
        String key_word = "tiyu";
        //https://api.isoyu.com/api/News/local_news?name=%E5%B9%BF%E4%B8%9C%E7%9C%81_%E6%B7%B1%E5%9C%B3%E5%B8%82&page=0
        String com_url = "http://v.juhe.cn/toutiao/index?type=" + key_word + "&key=7836f310c365aa7e201d3649f7df3e0f";
        JSONObject Res = null;
        //Map<String,Object> map = new HashMap<String,Object>();
        try {
            java.net.URL url = new java.net.URL(com_url); // 根据 String 表示形式创建 URL 对象。
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection(); // 返回一个 URLConnection 对象，它表示到 URL 所引用的远程对象的连接
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0");//设置代理
            java.io.InputStreamReader isr = new java.io.InputStreamReader(conn.getInputStream()); // 返回从此打开的连接读取的输入流。
            java.io.BufferedReader br = new java.io.BufferedReader(isr); // 创建一个使用默认大小输入缓冲区的缓冲字符输入流。

            String jsonText = readAll(br);
            JSONObject json = new JSONObject(jsonText);

            Res = json;


            String new0title = Res.getJSONObject("result").getJSONArray("data").getJSONObject(0).getString("title");
            String new0url = Res.getJSONObject("result").getJSONArray("data").getJSONObject(0).getString("url");


            String new1title = Res.getJSONObject("result").getJSONArray("data").getJSONObject(1).getString("title");
            String new1url = Res.getJSONObject("result").getJSONArray("data").getJSONObject(1).getString("url");


            String new2title = Res.getJSONObject("result").getJSONArray("data").getJSONObject(2).getString("title");
            String new2url = Res.getJSONObject("result").getJSONArray("data").getJSONObject(2).getString("url");

            String data=new0title+" "+new0url+" "+new1title+" "+new1url+" "+new2title+" "+new2url;
            //把数据传给控制器
            sendMessageService.getOutput().send(MessageBuilder.withPayload(data).build());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return "success";
    }
}