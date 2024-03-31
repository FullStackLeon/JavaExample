package com.lib.javalib.bitcoin;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;

import static java.lang.System.*;

public class EthereumAddressGenerator {

    public static void main(String[] args) throws Exception {
        // 生成新的以太坊 ECKeyPair（公钥和私钥）
        ECKeyPair keyPair = Keys.createEcKeyPair();

        // 将 ECKeyPair 转换为 Credentials 对象
        Credentials credentials = Credentials.create(keyPair);

        // 获取生成的以太坊地址
        String address = credentials.getAddress();

        // 打印生成的以太坊地址
        out.println("Ethereum Address: " + address);
    }
}
