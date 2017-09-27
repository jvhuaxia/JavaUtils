package com.jvhuaxia.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyUtils {

	public static void downloadFile(String url, String path) throws IOException {
		downloadFile(url, new File(path));
	}

	public static void downloadFile(String url, File file) throws IOException {
		HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
		httpURLConnection.connect();
		InputStream is = httpURLConnection.getInputStream();
		System.out.println(is.available());
		writeInputStream2File(is, file);
		httpURLConnection.disconnect();
	}

	public static void writeInputStream2File(InputStream is, File file, int buffLength) throws IOException {
		byte[] buff = new byte[buffLength];
		int readWhere = -1;
		FileOutputStream fos = new FileOutputStream(file);
		while ((readWhere = is.read(buff)) != -1) {
			fos.write(buff, 0, readWhere);
		}
		fos.close();
		is.close();
	}

	public static void writeInputStream2File(InputStream is, String path) throws IOException {
		writeInputStream2File(is, new File(path), 10240);
	}

	public static void writeInputStream2File(InputStream is, File file) throws IOException {
		writeInputStream2File(is, file, 10240);
	}
}
