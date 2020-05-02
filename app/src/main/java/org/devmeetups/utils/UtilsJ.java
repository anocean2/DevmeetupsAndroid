package org.devmeetups.utils;

import java.util.UUID;
import android.util.Log;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

public class UtilsJ {

    public static String getUniqueID() {
        String str = UUID.randomUUID().toString();
        Log.v(Constants.INSTANCE.getLOGS_TAG(), "Сгенерированный UUID.randomUUID " + str);

        String encoded = android.util.Base64.encodeToString(str.getBytes(), android.util.Base64.DEFAULT).toString();
        Log.v(Constants.INSTANCE.getLOGS_TAG(), "Сгенерированный токен " + encoded);
        return encoded;
    }

    public static String md5Apache(String st) {
        String s = new String(Hex.encodeHex(DigestUtils.md5(st)));
        return s;
    }
}
