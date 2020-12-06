package eti.policarto.charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String c = "n";
        System.out.println(Charset.defaultCharset().displayName());

        byte[] bytes = c.getBytes(StandardCharsets.UTF_16);
        System.out.println(new String(bytes, StandardCharsets.UTF_16));

    }
}
