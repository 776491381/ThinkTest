package OtherForAli.RedisMQ;

import java.io.Serializable;

/**
 * Message
 * Created by fyy on 6/20/17.
 */
public class Message implements Serializable {

    public static final long serialVersionUID = 1L;
    private String titile;
    private String info;

    public Message(String titile,String info){
        this.titile=titile;
        this.info=info;
    }

    public String getTitile() {
        return titile;
    }
    public void setTitile(String titile) {
        this.titile = titile;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

}
