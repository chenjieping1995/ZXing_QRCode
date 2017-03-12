package com.ZXingQRCode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReadQRCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MultiFormatReader formatReader = new MultiFormatReader();

			// 这里填入二维码图片的路径
			File file = new File("D:/img.png");

			BufferedImage image = ImageIO.read(file);

			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

			// 定义二维码的参数
			HashMap hints = new HashMap();
			// QRCode默认支持中文
			// 注意在使用中文时请将这里的编码格式改为 GBK
			hints.put(EncodeHintType.CHARACTER_SET, "GBK");

			Result result = formatReader.decode(binaryBitmap, hints);

			System.out.println("解析结果：" + result.toString());
			System.out.println("二维码的格式类型：" + result.getBarcodeFormat());
			System.out.println("二维码的文本内容：" + result.getText());

		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
