package modelo.vo;

public class Requerimiento_2Vo {
    // Su código

    private String proveedro;
    private int idProyecto;

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

    public int getIdProyecto() {
        return this.idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

}
