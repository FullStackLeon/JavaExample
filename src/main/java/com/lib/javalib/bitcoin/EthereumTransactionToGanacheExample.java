package com.lib.javalib.bitcoin;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

import static java.lang.System.out;

public class EthereumTransactionToGanacheExample {

    public static void main(String[] args) throws Exception {
        // Ganache RPC 服务的 URL
        String url = "http://127.0.0.1:7545";

        // 连接到 Ganache 节点
        Web3j web3j = Web3j.build(new HttpService(url));

        // Ganache 账户的私钥
        String privateKey = "0xe4160820633acad543064ad38ec1e938caf2e15acba2aaaf42b65bd50087e9e2";

        // Ganache 账户的地址
        String ganacheAddress = "0xfa82493495CE01b3C8456f971773e0b1f59D98b0";

        // 要发送的以太币数量（以太为单位）1 ETH
        BigDecimal amount = BigDecimal.valueOf(1);

        // 创建凭证对象
        Credentials credentials = Credentials.create(privateKey);

        // 发送交易
        CompletableFuture<TransactionReceipt> transactionReceipt = Transfer.sendFunds(web3j, credentials, ganacheAddress, amount, Convert.Unit.ETHER).sendAsync();

        // 等待交易完成
        transactionReceipt.thenAccept(receipt -> out.println("Transaction receipt hash: " + receipt.getTransactionHash()));
    }
}

