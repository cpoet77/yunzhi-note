package cn.wanggf.yunzhi.note.comm.util;

import javax.servlet.http.HttpServletRequest;

/**
 * request工具
 *
 * @author wanggf
 */
public class ReqsUtil {
    public static final String HEADER_USER_AGENT = "User-Agent";

    private ReqsUtil() {
    }

    /**
     * 获取UA
     *
     * @param request 请求
     * @return UA
     */
    public static String getUserAgent(HttpServletRequest request) {
        return request == null ? "" : request.getHeader(HEADER_USER_AGENT);
    }

    /**
     * 获取ip地址
     *
     * @param request 请求
     * @return ip地址
     */
    public static String findIpAddress(HttpServletRequest request) {
        if (request == null) {
            return "";
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
