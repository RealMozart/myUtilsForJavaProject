package image.veritfCode;

import java.util.Random;

public class CodeUtils {
	
	public static final int TYPE_ONLYNUM = 1; //纯数字
	
	public static final int TYPE_NUM_CHAR = 2; //数字+(大小写)字母
	
	public static final int TYPE_ONLYCHAR = 3; //纯(大小写)字母
	
	public static final int TYPE_LOWERCASE_LETTER = 4; //纯(小写)字母
	
	public static final int TYPE_UPPERCASE_LETTERS = 5; //纯(大写)字母
	
	public static final int TYPE_NUM_LOWER = 6; //数字 + 小写字母
	
	public static final int TYPE_NUM_UPPER = 7; //数字 + 大写字母
	
	/**
	 * 生成随机验证码
	 * @param type  类型
	 * @param length   长度
	 * @param exChars  排除的字符
	 * @return
	 */
	public static String getRandomCode(int type,int length,String exChars){
		if(length<=0||type<0)return "";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		int i=0;
		switch (type) {
		case TYPE_ONLYNUM://纯数字
			while(i<length){
				 int t=random.nextInt(10);
				 if(exChars==null||exChars.indexOf(t+"")<0){//排除特殊字符
	                 sb.append(t);
	                 i++;
	             }
			}
			break;
		case TYPE_NUM_CHAR://数字+(大小写)字母
			while(i<length){
				int t=random.nextInt(123);
                if((t>=97||(t>=65&&t<=90)||(t>=48&&t<=57))&&(exChars==null||exChars.indexOf((char)t)<0)){
                    sb.append((char)t);
                    i++;
                }
			}
			break;
		case TYPE_ONLYCHAR://纯(大小写)字母
			while(i<length){
				 int t=random.nextInt(123);
	             if((t>=97||(t>=65&&t<=90))&&(exChars==null||exChars.indexOf((char)t)<0)){
                    sb.append((char)t);
                    i++;    
	             }
			}
			break;
		case TYPE_LOWERCASE_LETTER://纯(小写)字母
			while(i<length){
				 int t=random.nextInt(123);
	                if((t>=97)&&(exChars==null||exChars.indexOf((char)t)<0)){
	                    sb.append((char)t);
	                    i++;
	                }
			}
			break;
		case TYPE_UPPERCASE_LETTERS://纯(大写)字母
			while(i<length){
				 int t=random.nextInt(123);
	             if((t>=97||(t>=65&&t<=90))&&(exChars==null||exChars.indexOf((char)t)<0)){
                    sb.append((char)t);
                    i++;    
	             }
			}
			break;
        case TYPE_NUM_UPPER: //数字 + 大写字母
            while(i<length){
                int t=random.nextInt(91);
                if((t>=65||(t>=48&&t<=57))&&(exChars==null||exChars.indexOf((char)t)<0)){
                    sb.append((char)t);
                    i++;
                }
            }
            break;        
            
        case TYPE_NUM_LOWER: //数字 + 小写字母
            while(i<length){
                int t=random.nextInt(123);
                if((t>=97||(t>=48&&t<=57))&&(exChars==null||exChars.indexOf((char)t)<0)){
                    sb.append((char)t);
                    i++;
                }
            }
            break;        
		default:
			break;
		}
		return sb.toString();
	}
}
