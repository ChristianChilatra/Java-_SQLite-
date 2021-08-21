package modelo.vo;

public class Requerimiento_2Vo {


    // Su código

    public Requerimiento_2Vo() {
    }

    private String proveedro;
    private int idProyecto;
    private final int NUM_COLUM = 2;

    public Requerimiento_2Vo(String proveedro, int idProyecto) {
        this.proveedro = proveedro;
        this.idProyecto = idProyecto;
    }

    public String getProveedro() {
        return this.proveedro;
    }

    public void setProveedro(String proveedro) {
        this.proveedro = proveedro;
    }

    public int getNumColum() {
        return this.NUM_COLUM;
    }

    public int getIdProyecto() {
        return this.idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

}
