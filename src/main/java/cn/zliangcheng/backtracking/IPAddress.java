package cn.zliangcheng.backtracking;

import java.util.ArrayList;
import java.util.List;

public class IPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        splitIpAddress(result, 0, 0, s, "", "");
        return result;
    }

    private void splitIpAddress(List<String> result, int index, int segI, String str, String ip, String seg) {
        if (index == str.length() && segI == 3 && isValidIpSeg(seg)) {
            result.add(ip + seg);
            return;
        }

        if (segI > 3 || index >= str.length()) {
            return;
        }

        if (isValidIpSeg(seg + str.charAt(index))) {
            splitIpAddress(result, index + 1, segI, str, ip, seg + str.charAt(index));
        }

        if (!seg.isEmpty()) {
            splitIpAddress(result, index + 1, segI + 1, str, ip + seg + ".", "" + str.charAt(index));
        }

    }

    private boolean isValidIpSeg(String seg) {
        return Integer.parseInt(seg) < 256
                && ("0".equals(seg) || seg.charAt(0) != '0');
    }
}
