package web3j.test;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Numeric;
import web3j.model.NftBind;

import java.math.BigInteger;

public class Test {

    //      区块链浏览器
    //    https://goerli.etherscan.io/

    //    RPC网关 (g网)
    private static final String RPC_GATE_WAY = "https://goerli.infura.io/v3/dde407ecee1e42f7a6258d07d41363eb";
    //    账户地址
    private static final String ADMIN_ADDRESS = "0x166f006e4bb5d5f5efa32a5207a867e43b259cb6";
    //    私钥
    private static final String PRIVATE_KEY = "3c390bddd8ca03a12b5adfefd68f862bd70a9d26e0fe2fc38a77ad2a13603cbc";
    //    721合约地址
    private static final String NFT_CONTRACT_ADDRESS = "0xB9A74E79B6D1ac46a1F3E3A2FED6E019e53A398a";
    //    业务合约地址
    private static final String BIND_CONTRACT_ADDRESS = "0x71adf7ca4e2beffc7f582d011b5ec5cb942be83b";

    public static void main(String[] args) throws Exception {

        Web3j web3j = Web3j.build(new HttpService(RPC_GATE_WAY));
        Credentials credentials = Credentials.create(PRIVATE_KEY);
        System.err.println("账户地址：" + credentials.getAddress());

        System.out.println("===========载入合约===========");
        NftBind nftBind = NftBind.load(BIND_CONTRACT_ADDRESS, web3j, credentials, new DefaultGasProvider());
//        RemoteCall<NftBind> nftBindRemoteCall = NftBind.deploy(web3j, credentials, new DefaultGasProvider());
//        NftBind nftBind = nftBindRemoteCall.send();

        System.err.println("合约地址：" + nftBind.getContractAddress());
        System.err.println("是否可用：" + nftBind.isValid());

//        mintNft(nftBind, ADMIN_ADDRESS);
        getNftData(nftBind, "1");
    }

    //    增发NFT
    public static void mintNft(NftBind nftBind, String to) throws Exception {
        System.out.println("===========增发NFT===========");

        //        构造数据
        NftBind.NftData nftData = new NftBind.NftData(
                "Test_work_Id", true, new BigInteger("180"),
                "admin", "3701xx",
                new BigInteger("100"), new BigInteger("10"), new BigInteger("10"),
                "37.241142141", "90.41414141"
        );
        //         发送交易
        RemoteFunctionCall<TransactionReceipt> addOrUpdateNftData = nftBind.safeMint(NFT_CONTRACT_ADDRESS, to, nftData);
        TransactionReceipt send = addOrUpdateNftData.send();
        System.err.println("交易hash:" + send.getTransactionHash());
        System.err.println("交易状态:" + send.getStatus());
    }

    //    查询NFT业务数据
    public static void getNftData(NftBind nftBind, String tokenId) throws Exception {
        System.out.println("===========查询NFT===========");
        RemoteFunctionCall<NftBind.NftData> bindNftData = nftBind.getNftData(new BigInteger(tokenId));
        NftBind.NftData data = bindNftData.send();
        System.err.println(data);
    }

    //  新建用户
    public static void newAccount() throws Exception {
        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
        Credentials credentials = Credentials.create(ecKeyPair);
        System.err.println("钱包地址：" + credentials.getAddress());
        System.err.println("钱包私钥：" + Numeric.toHexStringNoPrefix(credentials.getEcKeyPair().getPrivateKey()));
    }
}