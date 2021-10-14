package me.mcdcs.rgbtext;

public class Num {

    private String num;

    private String[] zm = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","s","y","z"};

    public Num(String num){
        this.num = num;
    }

    public String sze(int jz){//十进制转任意进制
        StringBuilder n = new StringBuilder();
        int i = Integer.parseInt(num);
        while (true){
            int y = i % jz;
            if (y >= 10){
                n.insert(0,zm[y-10]);
            }else {
                n.insert(0, y);
            }
            if ((double) i / jz == (double) 1 / jz){
                break;
            }
            i = (i - y) / jz;
        }
        return n.toString();
    }

    public String ezs(int jz){//任意进制转十进制
        int n = 0;
        char[] cs = num.toCharArray();
        int m = num.length() - 1;
        for (char c : cs){
            String s = String.valueOf(c);
            int i = 1;
            int b = 0;
            while (b != m){
                i = i * jz;
                b++;
            }
            int p = 0;
            for (String k : zm){
                if (k.equalsIgnoreCase(s)){
                    p += 10;
                    break;
                }
                p++;
            }
            if (p < 10){
                p = Integer.parseInt(s);
            }
            n += i * p;
            m--;
        }
        return String.valueOf(n);
    }
}