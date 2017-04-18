package cn.github.lianqu1990.utils.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class IpUtil {
	private static final Logger log = LoggerFactory.getLogger(IpUtil.class);

	/**
	 * 判断当前操作是否Windows.
	 * 
	 * @return true---是Windows操作系统
	 */
	public static boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		return isWindowsOS;
	}

	public static List<String> getLocalIPs() {
		InetAddress ip = null;
		List<String> innerIpList = new ArrayList<String>();
		try {
			// 如果是Windows操作系统
			/*
			 * if (isWindowsOS()) {
			 * ip = InetAddress.getLocalHost();
			 * innerIpList.add(ip);
			 * }
			 */
			//
			Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
				// ----------特定情况，可以考虑用ni.getName判断
				// 遍历所有ip
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = (InetAddress) ips.nextElement();
					if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() // 127.开头的都是lookback地址
							&& ip.getHostAddress().indexOf(":") == -1) {
						innerIpList.add(ip.getHostAddress());
					}
				}

			}
		} catch (Exception e) {
			log.error("get local ip error:", e);
		}
		return innerIpList;
	}

	/**
	 * 获取本机IP地址，并自动区分Windows还是Linux操作系统
	 * 
	 * @return String
	 */
	public static String getLocalIP() {
		
		// 如果是Windows操作系统
		/*
		 * if (isWindowsOS()) {
		 * ip = InetAddress.getLocalHost();
		 * innerIpList.add(ip);
		 * }
		 */
		//
		List<String> ips = getLocalIPs();
		if(ips.size() > 0){
			return ips.get(ips.size()-1);
		}else{
			return "";
		}
	}

	public static Long getIpFlag(int flag) {
		String ip = IpUtil.getLocalIP();
		log.info("ip=" + ip);
		String ips[] = ip.split("[.]");
		return Long.valueOf(ips[flag - 1]);
	}

}
