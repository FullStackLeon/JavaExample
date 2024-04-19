package com.lib.javalib.math;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static java.lang.System.*;

public class MurmurHashExample {
    public static void main(String[] args) {
        String input = "Hello MurmurHash";
        int seed = new Random().nextInt();
        int hash = Hashing.murmur3_32(seed).hashString(input, StandardCharsets.UTF_8).asInt();

        out.println("MurmurHash 哈希值为: " + hash);
    }
}
