package model.token;

import org.hibernate.validator.constraints.NotBlank;

/**
 * <B>说       明</B>:
 *
 * @author 作  者  名：陈芮芃<br/>
 *         E-mail ：ruipeng110@126.com
 * @version 版 本 号：V1.0.<br/>
 *          创建时间：2017/6/7 0007 19:15
 */
public class TokenDataBody {

    @NotBlank(message = "交易ID不能为空")
    private String proposalFormId;    //标志一次交易投保的交易标志一次交易投保的交易
    @NotBlank(message = "交易TOKEN不能为空")
    private String proposalFormToken;    //每次调用接口的令牌每次调用接口的令牌

    public String getProposalFormId() {
        return proposalFormId;
    }

    public void setProposalFormId(String proposalFormId) {
        this.proposalFormId = proposalFormId;
    }

    public String getProposalFormToken() {
        return proposalFormToken;
    }

    public void setProposalFormToken(String proposalFormToken) {
        this.proposalFormToken = proposalFormToken;
    }
}
