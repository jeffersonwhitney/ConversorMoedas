import com.google.gson.annotations.SerializedName;

public class Moeda {
    private double Quantidade;
    private String tipoOrigem;
    private String tipoDestino;
    private double ars;
    private double bob;
    private double brl;
    private double clp;
    private double cop;
    private double dol;

    public double getArs() {
        return ars;
    }

    public void setArs(double ars) {
        this.ars = ars;
    }

    public double getBob() {
        return bob;
    }

    public void setBob(double bob) {
        this.bob = bob;
    }

    public double getBrl() {
        return brl;
    }

    public void setBrl(double brl) {
        this.brl = brl;
    }

    public double getClp() {
        return clp;
    }

    public void setClp(double clp) {
        this.clp = clp;
    }

    public double getCop() {
        return cop;
    }

    public void setCop(double cop) {
        this.cop = cop;
    }

    public double getDol() {
        return dol;
    }

    public void setDol(double dol) {
        this.dol = dol;
    }

    public double getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(double quantidade) {
        Quantidade = quantidade;
    }

    public String getTipoOrigem() {return tipoOrigem;}

    public void setTipoOrigem(String tipoOrigem) {
        this.tipoOrigem = tipoOrigem;
    }

    public String getTipoDestino() {
        return tipoDestino;
    }

    public void setTipoDestino(String tipoDestino) {
        this.tipoDestino = tipoDestino;
    }
}
