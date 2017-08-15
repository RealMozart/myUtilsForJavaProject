package image.veritfCode;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Test01 {

	public static void main(String[] args) {
		String randomCode = CodeUtils.getRandomCode(CodeUtils.TYPE_NUM_CHAR, 4, null);
		System.out.println(randomCode);
		BufferedImage imageFromCode = ImageUtils.getImageFromCode(randomCode, 100, 50, 3, true, Color.WHITE, Color.BLACK, null);
		 try {
			File file = new File("h:/test01.jpg");
			ImageIO.write(imageFromCode,"jpg",file);
			System.out.println("成功保存到："+file.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("保存失败");
			e.printStackTrace();
		} 
		
	}
/*	public static void outputStream(HttpServletRequest request,HttpServletResponse response){
		try {
			// 设置浏览器不缓存本页
			response.addHeader("Pragma", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			response.addHeader("Expires", "0");
			// 生成验证码，写入用户session
			String verifyCode = CodeUtils.getRandomCode(CodeUtils.TYPE_NUM_CHAR, 4, null);
			request.getSession().setAttribute("imageVerify", verifyCode);
			// 输出验证码给客户端
			response.setContentType("image/jpeg");
			BufferedImage bim = ImageUtils
					.getImageFromCode(verifyCode, 47, 18, 3, true,
							Color.WHITE, Color.BLACK, null);
			ImageIO.write(bim, "JPEG", response.getOutputStream());

		} catch (Exception e) {
		}
		return null;
	}*/

}
