package model;

/**
 * <B>说       明</B>:
 *
 * @author 作  者  名：陈芮芃<br/>
 *         E-mail ：ruipeng110@126.com
 * @version 版 本 号：V1.0.<br/>
 *          创建时间：2017/6/7 0007 18:31
 */
public class Resp<HEAD, BODY> {

    private HEAD head;

    private BODY body;

    private String reponseCode;  //我日，单词还拼错了

    private String messageCode;

    private String messageBody;

    public boolean success(){
        if ("200".equals(reponseCode) && "0".equals(messageCode)){
            return true;
        }
        return false;
    }

    public HEAD getHead() {
        return head;
    }

    public String getReponseCode() {
        return reponseCode;
    }

    public void setReponseCode(String reponseCode) {
        this.reponseCode = reponseCode;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public void setHead(HEAD head) {
        this.head = head;
    }

    public BODY getBody() {
        return body;
    }

    public void setBody(BODY body) {
        this.body = body;
    }
}