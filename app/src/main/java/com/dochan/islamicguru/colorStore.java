package com.dochan.islamicguru;

public class colorStore {
    private String deepColor;
    private String lightColor;


    public static colorStore[] colors = {
      new colorStore("#b30c00","#ff7a71"),
      new colorStore("#8e0332","#e83a75"),
      new colorStore("#620073","#a347b3"),
      new colorStore("#2e0080","#7b59b7"),
      new colorStore("#01147d","#5b69b5"),
      new colorStore("#00355f","#53a8ea"),
      new colorStore("#005850","#54d2c6"),
      new colorStore("#025405","#67bf6b"),
      new colorStore("#774a08","#e0a650"),
      new colorStore("#6f650c","#ffeb3b"),
      new colorStore("#6f2f17","#795548"),
      new colorStore("#842b0f","#fb7b53"),
      new colorStore("#163f52","#83a2b1"),
    };

    private colorStore(String deepColor, String lightColor) {
        this.deepColor = deepColor;
        this.lightColor = lightColor;
    }

    public String getDeepColor() {
        return deepColor;
    }

    public String getLightColor() {
        return lightColor;
    }

    public String toString(){
        return this.deepColor;
    }
}
