package model;

/**
 * <B>说       明</B>:
 *
 * @author 作  者  名：陈芮芃<br/>
 *         E-mail ：ruipeng110@126.com
 * @version 版 本 号：V1.0.<br/>
 *          创建时间：2017/6/7 0007 18:29
 */
public class Req<HEAD, BODY> {

    private HEAD head;

    private BODY body;

    public HEAD getHead() {
        return head;
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
