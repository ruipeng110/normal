package model.token;

import org.hibernate.validator.constraints.NotBlank;

/**
 * <B>说       明</B>:
 *
 * @author 作  者  名：陈芮芃<br/>
 *         E-mail ：ruipeng110@126.com
 * @version 版 本 号：V1.0.<br/>
 *          创建时间：2017/6/7 0007 18:52
 */
public class TokenReqHead {
    @NotBlank(message = "版本号不能为空")
    private String version = "v1";    //匹配接口版本匹配接口版本
    @NotBlank(message = "接口代码不能为空")
    private String function = "getToken";    //接口功能接口功能
    @NotBlank(message = "发送时间不能为空")
    private String transTime ;    //请求发起时间请求发起时间
    @NotBlank(message = "渠道ID不能为空")
    private String channelId = "007";
    private String reqMsgId;    //唯一定位一次报文请求，由发起方生成，应答方原样返回唯一定位一次报文请求，由发起方生成，应答方原样返回

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getReqMsgId() {
        return reqMsgId;
    }

    public void setReqMsgId(String reqMsgId) {
        this.reqMsgId = reqMsgId;
    }
}
