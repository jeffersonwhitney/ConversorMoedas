import com.google.gson.annotations.SerializedName;

public class Moeda {
    private double Quantidade;
    private String tipoOrigem;
    private String tipoDestino;
    private double taxaDestino;



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

    public double getTaxaDestino() {return taxaDestino;}

    public void setTaxaDestino(double taxaDestino) {
        this.taxaDestino = taxaDestino;
    }
}
