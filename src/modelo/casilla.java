
package modelo;

public class casilla {
    private boolean mina;
    private boolean descubierta;
    private boolean marcada;
    private int minasAlrededor;

    public casilla() {
        this.mina = false;
        this.descubierta = false;
        this.marcada = false;
        this.minasAlrededor = 0;
    }

    public boolean tieneMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void descubrir() throws CasillaYaDescubiertaException {
        if (descubierta) {
            throw new CasillaYaDescubiertaException("Esta casilla ya fue descubierta");
        }
        this.descubierta = true;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public void marcar() {
        this.marcada = !this.marcada;
    }

    public int getMinasAlrededor() {
        return minasAlrededor;
    }

    public void setMinasAlrededor(int minasAlrededor) {
        this.minasAlrededor = minasAlrededor;
    }

    @Override
    public String toString() {
        if (!descubierta) {
            return marcada ? "M" : "#";
        }
        if (mina) {
            return "X";
        }
        return minasAlrededor > 0 ? String.valueOf(minasAlrededor) : " ";
    }
}