package cn;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
 


import javax.servlet.http.HttpServletRequest;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
 /**
  * 消息处理工具类
  * Created by xdp on 2016/1/26.
  */
 public class MessageHandlerUtil {
 
     /**
      * 解析微信发来的请求（XML）
      * @param request
      * @return map
      * @throws Exception
      */
     public static Map<String,String> parseXml(HttpServletRequest request) throws Exception {
         // 将解析结果存储在HashMap中
         Map<String,String> map = new HashMap();
         // 从request中取得输入流
         InputStream inputStream = request.getInputStream();
         System.out.println("获取输入流");
         // 读取输入流
         SAXReader reader = new SAXReader();
         Document document = reader.read(inputStream);
         // 得到xml根元素
         Element root = document.getRootElement();
         // 得到根元素的所有子节点
         List<Element> elementList = root.elements();
 
         // 遍历所有子节点
         for (Element e : elementList) {
             System.out.println(e.getName() + "|" + e.getText());
             map.put(e.getName(), e.getText());
         }
 
         // 释放资源
         inputStream.close();
         inputStream = null;
         return map;
     }
 
     // 根据消息类型 构造返回消息
     public static String buildXml(Map<String,String> map) {
         String result;
         String msgType = map.get("MsgType").toString();
         System.out.println("MsgType:" + msgType);
         if(msgType.toUpperCase().equals("TEXT")){
             result = buildTextMessage(map, "迈傲科技-迈傲室界");
         }else{
             String fromUserName = map.get("FromUserName");
             // 开发者微信号
             String toUserName = map.get("ToUserName");
             result = String
                     .format(
                             "<xml>" +
                                     "<ToUserName><![CDATA[%s]]></ToUserName>" +
                                     "<FromUserName><![CDATA[%s]]></FromUserName>" +
                                     "<CreateTime>%s</CreateTime>" +
                                     "<MsgType><![CDATA[text]]></MsgType>" +
                                     "<Content><![CDATA[%s]]></Content>" +
                                     "</xml>",
                             fromUserName, toUserName, getUtcTime(),
                             "请回复如下关键词：\n文本\n图片\n语音\n视频\n音乐\n图文");
         }
 
         return result;
     }
 
     private static String getUtcTime() {
         Date dt = new Date();// 如果不需要格式,可直接用dt,dt就是当前系统时间
         DateFormat df = new SimpleDateFormat("yyyyMMddhhmm");// 设置显示格式
         String nowTime = df.format(dt);
         long dd = (long) 0;
         try {
             dd = df.parse(nowTime).getTime();
         } catch (Exception e) {
 
         }
         return String.valueOf(dd);
     }
     
     public enum MessageType {
		 TEXT,//文本消息
		 IMAGE,//图片消息
		 VOICE,//语音消息
		 VIDEO,//视频消息
		 SHORTVIDEO,//小视频消息
		 LOCATION,//地理位置消息
		 LINK,//链接消息
		 EVENT//事件消息
	}
	
	/**
	 * 根据消息类型构造返回消息
	 * @param map 封装了解析结果的Map
	 * @return responseMessage(响应消息)
	 */
	 public static String buildResponseMessage(Map map) {
		 //响应消息
		 String responseMessage = "";
	 	//得到消息类型
		 String msgType = map.get("MsgType").toString();
		 System.out.println("MsgType:" + msgType);
		 //消息类型
		 MessageType messageEnumType = MessageType.valueOf(MessageType.class, msgType.toUpperCase());
		 switch (messageEnumType) {
		 	case TEXT:
		 		//处理文本消息
		 		responseMessage = handleTextMessage(map);
		 		break;
		 	default:
		 		break;
		 }
		 //返回响应消息
		 return responseMessage;
	}
	 
	 /**
	 	* 接收到文本消息后处理
	 	* @param map 封装了解析结果的Map
		* @return
		*/
	 private static String handleTextMessage(Map<String, String> map) {
		 //响应消息
		 String responseMessage="";
		 // 消息内容
		 String content = map.get("MsgType");
		 
		 	if(content.equals("text")){
		 		String msgText = map.get("Content")+ "欢迎\n";
		 		
		 		//String s1=null,s2=null;
		 		//try {
		 		//	s1 = java.net.URLEncoder.encode(msgText, "UTF-8");
		 		//	System.out.println(s1);
		 		//	s2= java.net.URLEncoder.encode(s1,"UTF-8");
		 		//	System.out.println(s2);   
		 		//} catch (UnsupportedEncodingException e) {
			 	//	e.printStackTrace();
			 	//}
		 		
		 		//if(msgText.length()<500){
		 		//     msgText = msgText + "\n"+  "<a href=\"http://tsn.baidu.com/text2audio?lan=zh&vol=9&tok=24.002396bd370b62ad1144b520c9ad70c7.2592000.1486037637.282335-9158560&ctp=1&cuid=1&tex=" + s2 + "\" target=\"_blank\">点击播放声音</a>";
		 		//}
		 		
		 		responseMessage = buildTextMessage(map, msgText);
		 	}
/*		 	case "图片":
		 		//通过素材管理接口上传图片时得到的media_id
		 		String imgMediaId = "dSQCiEHYB-pgi7ib5KpeoFlqpg09J31H28rex6xKgwWrln3HY0BTsoxnRV-xC_SQ";
		 		responseMessage = buildImageMessage(map, imgMediaId);
		 		break;
*/		 	if(content.equals("voice")){ 
		 		//通过素材管理接口上传语音文件时得到的media_id
		 		String voiceMediaId = "h3ul0TnwaRPut6Tl1Xlf0kk_9aUqtQvfM5Oq21unoWqJrwks505pkMGMbHnCHBBZ";
//		 		responseMessage = buildVoiceMessage(map,voiceMediaId);
		 		}
/*		 	case "图文":
		 		responseMessage = buildNewsMessage(map);
		 		break;
		 	case "音乐":
		 		Music music = new Music();
		 		music.title = "赵丽颖、许志安 - 乱世俱灭";
		 		music.description = "电视剧《蜀山战纪》插曲";
		 		music.musicUrl = "http://gacl.ngrok.natapp.cn/music/music.mp3";
		 		music.hqMusicUrl = "http://gacl.ngrok.natapp.cn/music/music.mp3";
		 		responseMessage = buildMusicMessage(map, music);
		 		break;
		 	case "视频":
		 		Video video = new Video();
		 		video.mediaId = "GqmIGpLu41rtwaY7WCVtJAL3ZbslzKiuLEXfWIKYDnHXGObH1CBH71xtgrGwyCa3";
		 		video.title = "小苹果";
		 		video.description = "小苹果搞笑视频";
		 		responseMessage = buildVideoMessage(map, video);
		 		break;
		 	
		 	default:
		 		responseMessage = buildWelcomeTextMessage(map);
		 		break;
		 	*/
		 

		 //返回响应消息
		 return responseMessage;
	 }
	 
	 
	 /**
	 * 构造文本消息
	 * @param map 封装了解析结果的Map
	 * @param content 文本消息内容
	 * @return 文本消息XML字符串
	 */
	 private static String buildTextMessage(Map<String, String> map, String content) {
		 //发送方帐号
		 String fromUserName = map.get("FromUserName");
		 // 开发者微信号
		 String toUserName = map.get("ToUserName");
		 /**
		  * 文本消息XML数据格式
		  * <xml>
	 		<ToUserName><![CDATA[toUser]]></ToUserName>
			<FromUserName><![CDATA[fromUser]]></FromUserName>
			<CreateTime>1348831860</CreateTime>
			<MsgType><![CDATA[text]]></MsgType>
			<Content><![CDATA[this is a test]]></Content>
			<MsgId>1234567890123456</MsgId>
			</xml>
		  */
		 return String.format(
				 "<xml>" +
						 "<ToUserName><![CDATA[%s]]></ToUserName>" +
						 "<FromUserName><![CDATA[%s]]></FromUserName>" +
						 "<CreateTime>%s</CreateTime>" +
						 "<MsgType><![CDATA[text]]></MsgType>" +
	                     "<Content><![CDATA[%s]]></Content>" +
	              "</xml>",
	             fromUserName, toUserName, getMessageCreateTime(), content);
	 }
	 
	 private static String getMessageCreateTime(){
		long time = System.currentTimeMillis()/1000;
		//System.out.println(time);
		return String.format("%d", time);
	 }
	 
	
}
