/*
 * Name: ConnectionUtils.java
 * Package: com.safetygame.android.Utils
 * Author: Lorenzo Braghetto
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+------------------+---------------------
 * |   Date   | Programmer       | Changes
 * +----------+------------------+---------------------
 * | 20120506 |Lorenzo Braghetto | + HttpCreateClient
 * |          |                  | + rootXML
 * |          |                  | + parseXML
 * +----------+------------------+---------------------
 *
 */
package com.safetyGame.mobile.Utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.safetyGame.mobile.condivisi.Dati;
import com.safetyGame.mobile.condivisi.Domanda;
import com.safetyGame.mobile.condivisi.Punteggi;

public class ConnectionUtils
{

	public static Object HttpCreateClient(String url, List<NameValuePair> nameValuePairs)
	{
		Element xml;

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);

		try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);

			xml = rootXML(response);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		if (parseXML(xml, "status", 0).equals("OK"))
		{
			if (url.contains("login"))
			{
				return parseXML(xml, "status", 0);
			} else if (url.contains("domanda"))
			{
				String type = parseXML(xml, "type", 0);
				if (type.equals("sino"))
					return new Domanda(Integer.parseInt(parseXML(xml, "id", 0)), type, parseXML(xml, "testo", 0), Integer.parseInt(parseXML(xml, "punteggio", 0)), Integer.parseInt(parseXML(xml, "corretta", 0)));
				else
				{
					int risposteNum = Integer.parseInt(parseXML(xml, "risposteNum", 0));
					String[] risposte = new String[risposteNum];
					for (int i = 0; i < risposteNum; i++)
					{
						risposte[i] = parseXML(xml, "risposta", i);
					}
					return new Domanda(Integer.parseInt(parseXML(xml, "id", 0)), type, parseXML(xml, "testo", 0), risposte, risposteNum, Integer.parseInt(parseXML(xml, "punteggio", 0)), Integer.parseInt(parseXML(xml, "corretta", 0)), Integer.parseInt(parseXML(xml, "tempo", 0)), Boolean.parseBoolean(parseXML(xml, "mobile", 0)), parseXML(xml, "ambito", 0));
				}

			} else if (url.contains("dati"))
			{
				return new Dati(parseXML(xml, "nome", 0), parseXML(xml, "cognome", 0));
			} else if (url.contains("punteggi"))
			{
				int badgesNum = Integer.parseInt(parseXML(xml, "badgesNum", 0));
				String[] badges = new String[badgesNum];
				for (int i = 0; i < badgesNum; i++)
					badges[i] = parseXML(xml, "testo", i);
				return new Punteggi(parseXML(xml, "rispostedate", 0), parseXML(xml, "rispostecorrette", 0), parseXML(xml, "risposteerrate", 0), parseXML(xml, "punti", 0), badges, badgesNum);
			} else if (url.contains("cambioPassw"))
			{
				return Boolean.valueOf(true);
			}
		}

		return null;

	}

	private static Element rootXML(HttpResponse response)
	{
		Document docs = null;
		try {
			docs = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(response.getEntity().getContent());
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		Element root = docs.getDocumentElement();

		return root;
	}

	public static String parseXML(Element root, String stringa, int position)
	{
		if (root != null)
		{
			NodeList nodelist = root.getElementsByTagName(stringa);
			return nodelist.item(position).getFirstChild().getNodeValue();
		} else
		{
			return "";
		}
	}

}