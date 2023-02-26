package Model;

import java.io.Serializable;

public class LopHoc implements Serializable {
    String MaLop;
    String TenLop;

    public LopHoc(String maLop, String tenLop) {
        MaLop = maLop;
        TenLop = tenLop;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String tenLop) {
        TenLop = tenLop;
    }
}
