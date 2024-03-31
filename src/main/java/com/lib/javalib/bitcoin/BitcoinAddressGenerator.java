package com.lib.javalib.bitcoin;

import org.bitcoinj.core.*;
import org.bitcoinj.params.MainNetParams;

import static java.lang.System.*;

public class BitcoinAddressGenerator {

    public static void main(String[] args) {
        // 使用比特币主网的参数
        NetworkParameters params = MainNetParams.get();

        // 生成新的比特币密钥对
        ECKey key = new ECKey();

        // 获取公钥哈希（即公钥的 RIPEMD160 哈希值）
        byte[] publicKeyHash = key.getPubKeyHash();

        // 创建比特币地址
        Address address = LegacyAddress.fromPubKeyHash(params, publicKeyHash);

        // 打印生成的比特币地址
        out.println("Bitcoin Address: " + address);
    }
}
