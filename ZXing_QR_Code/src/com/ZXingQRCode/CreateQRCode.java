package com.ZXingQRCode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;;

public class CreateQRCode {

	public static void main(String[] args) {
		int width = 300;
		int height = 300;

		String format = "png";
		// QRCode默认支持中文
		String Content = "在这里放上你想要存储的信息";

		// 定义二维码的参数
		HashMap<EncodeHintType, Comparable> hints = new HashMap<EncodeHintType, Comparable>();
		
		// 注意在使用中文时请将这里的编码格式改为 GBK
		hints.put(EncodeHintType.CHARACTER_SET, "GBK");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);

		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(Content, BarcodeFormat.QR_CODE, width, height, hints);
			
			// 生成的图片的保存路径
			File file = new File("D:/img.png");
			try {
				MatrixToImageWriter.writeToFile(bitMatrix, format, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
