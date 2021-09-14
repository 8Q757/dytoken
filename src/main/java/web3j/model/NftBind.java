package web3j.model;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.4.
 */
@SuppressWarnings("rawtypes")
public class NftBind extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610cb1806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806311aae362146100515780631d71f1b5146100665780639dc29fac14610079578063a802d82b1461008c575b600080fd5b61006461005f366004610aad565b6100b5565b005b6100646100743660046109f2565b61018e565b610064610087366004610a52565b6102f0565b61009f61009a366004610a7d565b6103d4565b6040516100ac9190610b57565b60405180910390f35b6000828152602081815260409091208251805184936100d8928492910190610725565b5060208281015160018301805460ff191691151591909117905560408301516002830155606083015180516101139260038501920190610725565b506080820151805161012f916004840191602090910190610725565b5060a0820151600582015560c0820151600682015560e08201516007820155610100820151805161016a916008840191602090910190610725565b506101208201518051610187916009840191602090910190610725565b5050505050565b6040516340d097c360e01b81526000906001600160a01b038516906340d097c3906101bd908690600401610b43565b602060405180830381600087803b1580156101d757600080fd5b505af11580156101eb573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061020f9190610a95565b600081815260208181526040909120845180519394508593919261023892849290910190610725565b5060208281015160018301805460ff191691151591909117905560408301516002830155606083015180516102739260038501920190610725565b506080820151805161028f916004840191602090910190610725565b5060a0820151600582015560c0820151600682015560e0820151600782015561010082015180516102ca916008840191602090910190610725565b5061012082015180516102e7916009840191602090910190610725565b50505050505050565b60008181526020819052604081209061030982826107a3565b60018201805460ff1916905560006002830181905561032c9060038401906107a3565b61033a6004830160006107a3565b60058201600090556006820160009055600782016000905560088201600061036291906107a3565b6103706009830160006107a3565b5050604051630852cd8d60e31b81526001600160a01b038316906342966c689061039e908490600401610c36565b600060405180830381600087803b1580156103b857600080fd5b505af11580156103cc573d6000803e3d6000fd5b505050505050565b6103dc6107ea565b600082815260208181526040918290208251815460026001821615610100026000190190911604601f81018490049093028101610160908101909452610140810183815290939192849284919084018282801561047a5780601f1061044f5761010080835404028352916020019161047a565b820191906000526020600020905b81548152906001019060200180831161045d57829003601f168201915b505050918352505060018281015460ff16151560208084019190915260028085015460408086019190915260038601805482516101009682161596909602600019011692909204601f8101849004840285018401909152808452606090940193909183018282801561052d5780601f106105025761010080835404028352916020019161052d565b820191906000526020600020905b81548152906001019060200180831161051057829003601f168201915b505050918352505060048201805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529382019392918301828280156105c15780601f10610596576101008083540402835291602001916105c1565b820191906000526020600020905b8154815290600101906020018083116105a457829003601f168201915b50505050508152602001600582015481526020016006820154815260200160078201548152602001600882018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106815780601f1061065657610100808354040283529160200191610681565b820191906000526020600020905b81548152906001019060200180831161066457829003601f168201915b505050918352505060098201805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529382019392918301828280156107155780601f106106ea57610100808354040283529160200191610715565b820191906000526020600020905b8154815290600101906020018083116106f857829003601f168201915b5050505050815250509050919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061076657805160ff1916838001178555610793565b82800160010185558215610793579182015b82811115610793578251825591602001919060010190610778565b5061079f92915061083f565b5090565b50805460018160011615610100020316600290046000825580601f106107c957506107e7565b601f0160209004906000526020600020908101906107e7919061083f565b50565b6040518061014001604052806060815260200160001515815260200160008152602001606081526020016060815260200160008152602001600081526020016000815260200160608152602001606081525090565b5b8082111561079f5760008155600101610840565b8035801515811461086457600080fd5b92915050565b600082601f83011261087a578081fd5b813567ffffffffffffffff811115610890578182fd5b6108a3601f8201601f1916602001610c3f565b91508082528360208285010111156108ba57600080fd5b8060208401602084013760009082016020015292915050565b60006101408083850312156108e6578182fd5b6108ef81610c3f565b915050813567ffffffffffffffff8082111561090a57600080fd5b6109168583860161086a565b83526109258560208601610854565b602084015260408401356040840152606084013591508082111561094857600080fd5b6109548583860161086a565b6060840152608084013591508082111561096d57600080fd5b6109798583860161086a565b608084015260a084013560a084015260c084013560c084015260e084013560e0840152610100915081840135818111156109b257600080fd5b6109be8682870161086a565b8385015250610120915081840135818111156109d957600080fd5b6109e58682870161086a565b8385015250505092915050565b600080600060608486031215610a06578283fd5b8335610a1181610c66565b92506020840135610a2181610c66565b9150604084013567ffffffffffffffff811115610a3c578182fd5b610a48868287016108d3565b9150509250925092565b60008060408385031215610a64578182fd5b8235610a6f81610c66565b946020939093013593505050565b600060208284031215610a8e578081fd5b5035919050565b600060208284031215610aa6578081fd5b5051919050565b60008060408385031215610abf578182fd5b82359150602083013567ffffffffffffffff811115610adc578182fd5b610ae8858286016108d3565b9150509250929050565b15159052565b60008151808452815b81811015610b1d57602081850181015186830182015201610b01565b81811115610b2e5782602083870101525b50601f01601f19169290920160200192915050565b6001600160a01b0391909116815260200190565b6000602082528251610140806020850152610b76610160850183610af8565b91506020850151610b8a6040860182610af2565b50604085015160608501526060850151601f1980868503016080870152610bb18483610af8565b935060808701519150808685030160a0870152610bce8483610af8565b935060a087015160c087015260c087015160e087015260e08701519150610100828188015280880151925050610120818786030181880152610c108584610af8565b908801518782039092018488015293509050610c2c8382610af8565b9695505050505050565b90815260200190565b60405181810167ffffffffffffffff81118282101715610c5e57600080fd5b604052919050565b6001600160a01b03811681146107e757600080fdfea26469706673582212208d7a9d3275a98938440a2526ce8c83ee3c5ee4521cb992f7c27a29dbd84a4f6264736f6c63430007010033";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_GETNFTDATA = "getNftData";

    public static final String FUNC_SAFEMINT = "safeMint";

    public static final String FUNC_UPDATENFTDATA = "updateNftData";

    @Deprecated
    protected NftBind(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected NftBind(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected NftBind(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected NftBind(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> burn(String dyToken, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_BURN,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, dyToken),
                        new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<NftData> getNftData(BigInteger tokenId) {
        final Function function = new Function(FUNC_GETNFTDATA,
                Arrays.<Type>asList(new Uint256(tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<NftData>() {
                }));
        return executeRemoteCallSingleValueReturn(function, NftData.class);
    }

    public RemoteFunctionCall<TransactionReceipt> safeMint(String dyToken, String to, NftData nftData) {
        final Function function = new Function(
                FUNC_SAFEMINT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, dyToken),
                        new org.web3j.abi.datatypes.Address(160, to),
                        nftData),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateNftData(BigInteger tokenId, NftData nftData) {
        final Function function = new Function(
                FUNC_UPDATENFTDATA,
                Arrays.<Type>asList(new Uint256(tokenId),
                        nftData),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static NftBind load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new NftBind(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static NftBind load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new NftBind(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static NftBind load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new NftBind(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static NftBind load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new NftBind(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<NftBind> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(NftBind.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<NftBind> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(NftBind.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<NftBind> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(NftBind.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<NftBind> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(NftBind.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class NftData extends DynamicStruct {
        public String workerId;

        public Boolean workerStatus;

        public BigInteger workerUptime;

        public String ownerName;

        public String ownerIdCard;

        public BigInteger orderAmount;

        public BigInteger orderNum;

        public BigInteger orderTotal;

        public String locationLat;

        public String LocationLng;

        @Override
        public String toString() {
            return "NftData{" +
                    "workerId='" + workerId + '\'' +
                    ", workerStatus=" + workerStatus +
                    ", workerUptime=" + workerUptime +
                    ", ownerName='" + ownerName + '\'' +
                    ", ownerIdCard='" + ownerIdCard + '\'' +
                    ", orderAmount=" + orderAmount +
                    ", orderNum=" + orderNum +
                    ", orderTotal=" + orderTotal +
                    ", locationLat='" + locationLat + '\'' +
                    ", LocationLng='" + LocationLng + '\'' +
                    '}';
        }

        public NftData(String workerId, Boolean workerStatus, BigInteger workerUptime, String ownerName, String ownerIdCard, BigInteger orderAmount, BigInteger orderNum, BigInteger orderTotal, String locationLat, String LocationLng) {
            super(new Utf8String(workerId), new Bool(workerStatus), new Uint256(workerUptime), new Utf8String(ownerName), new Utf8String(ownerIdCard), new Uint256(orderAmount), new Uint256(orderNum), new Uint256(orderTotal), new Utf8String(locationLat), new Utf8String(LocationLng));
            this.workerId = workerId;
            this.workerStatus = workerStatus;
            this.workerUptime = workerUptime;
            this.ownerName = ownerName;
            this.ownerIdCard = ownerIdCard;
            this.orderAmount = orderAmount;
            this.orderNum = orderNum;
            this.orderTotal = orderTotal;
            this.locationLat = locationLat;
            this.LocationLng = LocationLng;
        }

        public NftData(Utf8String workerId, Bool workerStatus, Uint256 workerUptime, Utf8String ownerName, Utf8String ownerIdCard, Uint256 orderAmount, Uint256 orderNum, Uint256 orderTotal, Utf8String locationLat, Utf8String LocationLng) {
            super(workerId, workerStatus, workerUptime, ownerName, ownerIdCard, orderAmount, orderNum, orderTotal, locationLat, LocationLng);
            this.workerId = workerId.getValue();
            this.workerStatus = workerStatus.getValue();
            this.workerUptime = workerUptime.getValue();
            this.ownerName = ownerName.getValue();
            this.ownerIdCard = ownerIdCard.getValue();
            this.orderAmount = orderAmount.getValue();
            this.orderNum = orderNum.getValue();
            this.orderTotal = orderTotal.getValue();
            this.locationLat = locationLat.getValue();
            this.LocationLng = LocationLng.getValue();
        }
    }
}