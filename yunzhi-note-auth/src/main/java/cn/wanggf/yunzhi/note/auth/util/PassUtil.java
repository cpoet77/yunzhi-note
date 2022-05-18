package cn.wanggf.yunzhi.note.auth.util;

/**
 * 密码工具
 *
 * @author wanggf
 */
public class PassUtil {
    private PassUtil() {
    }

    public static String randomMd5() {
        return md5hex(String.valueOf(Math.random()));
    }

    public static String md5hex(String pass) {
        return DigestUtil.md5hex(pass);
    }

    public static String md5hex(String pass, String salt) {
        return DigestUtil.md5hex(merge(pass, salt));
    }

    public static String merge(String str1, String str2) {
        byte[] bytes1 = str1.getBytes();
        byte[] bytes2 = str2.getBytes();
        StringBuilder builder = new StringBuilder(bytes1.length + bytes2.length);
        int len = Math.min(bytes1.length, bytes2.length);
        for (int i = 0; i < len; ++i) {
            builder.append(bytes1[i]).append(bytes2[i]);
        }
        bytes1 = bytes1.length == len ? bytes2 : bytes1;
        while (len < bytes1.length) {
            builder.append(bytes1[len++]);
        }
        return builder.toString();
    }
}
