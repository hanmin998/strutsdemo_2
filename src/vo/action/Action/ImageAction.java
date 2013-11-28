package vo.action.Action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport{
	private static final long serialVersionUID=1L;
	private ByteArrayInputStream inputStream;
	//产生四个0-9的随机数，放在一个字符串里
	public String createRandomString(){
		String str="";
		for(int i=0;i<4;i++){
			str+=Integer.toString((new Double(Math.random()*10)).intValue());
		}
		return str;
	}
	//随机产生一个颜色
	public Color createRandomColor(){
		int r=(new Double(Math.random()*256)).intValue();
		int g=(new Double(Math.random()*256)).intValue();
		int b=(new Double(Math.random()*256)).intValue();
		return new Color(r,g,b);
	}
	//生成一个内存图片，将四个随机数写在图片上
	public BufferedImage createImage(String str){
		int width=60;
		int height=22;
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		//获取图形上下文
		Graphics g=image.getGraphics();
		//设定背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//画边框
		g.setColor(Color.black);
		g.drawRect(0,0,width-1,height-1);
		//将认证码显示到图像中
		g.setFont(new Font("Atlantic Inline",Font.PLAIN,18));
		//使用随机颜色
		g.setColor(this.createRandomColor());
		//将随机字符串的每个数字分别写在图片上
		g.drawString(Character.toString(str.charAt(0)), 8, 17);
		g.drawString(Character.toString(str.charAt(1)), 20, 17);
		g.drawString(Character.toString(str.charAt(2)), 33, 17);
		g.drawString(Character.toString(str.charAt(3)), 45, 17);
		//图像生效
		g.dispose();
		return image;
	}
	//将图片一字节形式写在InputStrea里
	public ByteArrayInputStream createInputStream() throws Exception{
		//获取随机字符串
		String str=this.createRandomString();
		BufferedImage image=this.createImage(str);
		//将产生的字符串写入session，供校验时使用
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		session.put("random", str);
		ByteArrayOutputStream output=new ByteArrayOutputStream();
		ImageOutputStream imageOut=ImageIO.createImageOutputStream(output);
		ImageIO.write(image, "JPEG", imageOut);
		imageOut.close();
		ByteArrayInputStream input=new ByteArrayInputStream(output.toByteArray());
		output.close();
		return input;
	}
	@Override
	public String execute() throws Exception {
		setInputStream(createInputStream());
		return SUCCESS;
	}
	public ByteArrayInputStream getInputStream(){
		return inputStream;
	}
	public void setInputStream(ByteArrayInputStream inputStream){
		this.inputStream=inputStream;
	}
}
