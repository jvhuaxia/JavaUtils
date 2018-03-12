package com.jvhuaxia.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyUtils
{

	public static void downloadFile(String url, String path) throws IOException
	{
		downloadFile(url, new File(path));
	}

	public static void downloadFile(String url, File file) throws IOException
	{
		HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
		httpURLConnection.connect();
		InputStream is = httpURLConnection.getInputStream();
		System.out.println(is.available());
		writeInputStream2File(is, file);
		httpURLConnection.disconnect();
	}

	public static void writeInputStream2File(InputStream is, File file, int buffLength) throws IOException
	{
		byte[] buff = new byte[buffLength];
		int readWhere = -1;
		FileOutputStream fos = new FileOutputStream(file);
		while ((readWhere = is.read(buff)) != -1)
		{
			fos.write(buff, 0, readWhere);
		}
		fos.close();
		is.close();
	}

	public static void writeInputStream2File(InputStream is, String path) throws IOException
	{
		writeInputStream2File(is, new File(path), 10240);
	}

	public static void writeInputStream2File(InputStream is, File file) throws IOException
	{
		writeInputStream2File(is, file, 10240);
	}

	public static void writrString2File(File file, String string, String charset, boolean isAppend) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(file, isAppend);
		fos.write(string.getBytes(charset));
		fos.close();
	}

	public static void writeString2File(String filePath, String string) throws IOException
	{
		writrString2File(new File(filePath), string, "UTF-8", false);
	}

	public static int bytes2int(byte[] bs)
	{
		int value;
		value = (bs[0] & 0xFF) | ((bs[1] & 0xFF) << 8) | ((bs[2] & 0xFF) << 16) | ((bs[3] & 0xFF) << 24);
		return value;
	}

	public static boolean isNumber(String inNUmberString)
	{
		for (int i = 0; i < inNUmberString.length(); i++)
		{
			char c = inNUmberString.charAt(0);
			if (!(c <= 48 || c >= 57))
				return false;
		}
		return true;
	}

	public static String toUpperCase(String string)
	{
		StringBuilder resultString = new StringBuilder();
		for (int i = 0; i < string.length(); i++)
		{
			char c = string.charAt(i);
			if (c >= 'a' && c <= 'z')
			{
				c -= 32;
				resultString.append(c);
			} else
			{
				resultString.append(c);
			}
		}
		return resultString.toString();
	}

	public static String toLowerCase(String string)
	{
		StringBuilder resultString = new StringBuilder();
		for (int i = 0; i < string.length(); i++)
		{
			char c = string.charAt(i);
			if (c >= 'A' && c <= 'Z')
			{
				c += 32;
				resultString.append(c);
			} else
			{
				resultString.append(c);
			}
		}
		return resultString.toString();
	}
	public static void bs(int[] is) {
		for (int i = 0; i < is.length - 1; i++) {
			for (int j = 0; j < is.length - i - 1; j++) {
				if (is[j] > is[j + 1]) {
					int temp = is[j];
					is[j] = is[j + 1];
					is[j + 1] = temp;
				}
			}
		}
	}
}
