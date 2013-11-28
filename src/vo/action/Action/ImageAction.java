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
	//�����ĸ�0-9�������������һ���ַ�����
	public String createRandomString(){
		String str="";
		for(int i=0;i<4;i++){
			str+=Integer.toString((new Double(Math.random()*10)).intValue());
		}
		return str;
	}
	//�������һ����ɫ
	public Color createRandomColor(){
		int r=(new Double(Math.random()*256)).intValue();
		int g=(new Double(Math.random()*256)).intValue();
		int b=(new Double(Math.random()*256)).intValue();
		return new Color(r,g,b);
	}
	//����һ���ڴ�ͼƬ�����ĸ������д��ͼƬ��
	public BufferedImage createImage(String str){
		int width=60;
		int height=22;
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		//��ȡͼ��������
		Graphics g=image.getGraphics();
		//�趨����ɫ
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//���߿�
		g.setColor(Color.black);
		g.drawRect(0,0,width-1,height-1);
		//����֤����ʾ��ͼ����
		g.setFont(new Font("Atlantic Inline",Font.PLAIN,18));
		//ʹ�������ɫ
		g.setColor(this.createRandomColor());
		//������ַ�����ÿ�����ֱַ�д��ͼƬ��
		g.drawString(Character.toString(str.charAt(0)), 8, 17);
		g.drawString(Character.toString(str.charAt(1)), 20, 17);
		g.drawString(Character.toString(str.charAt(2)), 33, 17);
		g.drawString(Character.toString(str.charAt(3)), 45, 17);
		//ͼ����Ч
		g.dispose();
		return image;
	}
	//��ͼƬһ�ֽ���ʽд��InputStrea��
	public ByteArrayInputStream createInputStream() throws Exception{
		//��ȡ����ַ���
		String str=this.createRandomString();
		BufferedImage image=this.createImage(str);
		//���������ַ���д��session����У��ʱʹ��
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
