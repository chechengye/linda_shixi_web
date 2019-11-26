package pojo;

import java.io.Serializable;

public class Product implements Serializable{
    private int pid;
    private String pname;
    private String market_price;
    private String shop_price;
    private String pimage;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getMarket_price() {
        return market_price;
    }

    public void setMarket_price(String market_price) {
        this.market_price = market_price;
    }

    public String getShop_price() {
        return shop_price;
    }

    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", market_price='" + market_price + '\'' +
                ", shop_price='" + shop_price + '\'' +
                ", pimage='" + pimage + '\'' +
                '}';
    }
}
